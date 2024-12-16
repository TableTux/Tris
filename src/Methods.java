import java.util.Scanner;

public class Methods
{
    public static final int SIZE =  3;

    public static final int EMPTY = 0;
    public static final int X = +   1;
    public static final int O = -   1;

    private static char convertNumToChar(int num)
    {
        switch (num)
        {
            case X :    return 'X';
            case O :    return 'O';
            default :   return ' ';
        }
    }

    static void printConfigGame(int[][] configGame)
    {
        System.out.print(convertNumToChar(configGame[0][0]));
        System.out.print('|');
        System.out.print(convertNumToChar(configGame[0][1]));
        System.out.print('|');
        System.out.println(convertNumToChar(configGame[0][2]));
        System.out.println("-+-+-");

        System.out.print(convertNumToChar(configGame[1][0]));
        System.out.print('|');
        System.out.print(convertNumToChar(configGame[1][1]));
        System.out.print('|');
        System.out.println(convertNumToChar(configGame[1][2]));
        System.out.println("-+-+-");

        System.out.print(convertNumToChar(configGame[2][0]));
        System.out.print('|');
        System.out.print(convertNumToChar(configGame[2][1]));
        System.out.print('|');
        System.out.println(convertNumToChar(configGame[2][2]));
    }
    static int[][] createNewConfig()
    {
        return new int [3][3];
    }

    static void CPUMove(int[][] configGame, int numCPU, int numUser)
    {
        if(CPUMove1(configGame, numCPU, numUser))
        {
            return;
        }

        if(CPUMove2(configGame, numCPU, numUser))
        {
            return;
        }

        if(CPUMove3(configGame, numCPU, numUser))
        {
            return;
        }
        if(CPUMove4(configGame, numCPU, numUser))
        {
            return;
        }
        if(CPUMove5(configGame, numCPU, numUser))
        {
            return;

        }
        if (CPUMove6(configGame, numCPU, numUser))
        {
            return;
        }
    }

    private static boolean CPUMove1(int[][] configGame, int numCPU, int numUser)
    {
        // Check vertical and horizontal
        for (int y = 0; y < SIZE; y++)
        {
            int numCPUCase  =   0;
            int emptyCase   =   -1;
            for (int x = 0; x < SIZE; x++)
            {
                if(configGame[y][x] == numCPU)
                {
                    numCPUCase++;
                }
                else if (configGame[y][x] == EMPTY)
                {
                    emptyCase = x;
                }
            }
            if (numCPUCase == 2 && emptyCase != -1)
            {
                configGame[y][emptyCase] = numCPU;
                return true;
            }
        }
        for (int x = 0; x < SIZE; x++)
        {
            int numCPUCase = 0;
            int emptyCase = -1;
            for (int y = 0; y < SIZE; y++)
            {
                if(configGame[y][x] == numCPU)
                {
                    numCPUCase ++;
                }
                else if (configGame[y][x]  == EMPTY)
                {
                    emptyCase = y;
                }
            }
            if (numCPUCase == 2 && emptyCase != -1)
            {
                configGame[emptyCase][x] = numCPU;
                return true;
            }
        }
        /* Verify diagonal conditions
        x . .
        . x .
        . . x
         */
        {
            int numCPUCase = 0;
            int emptyCase = -1;
            for (int i = 0; i < SIZE; i++)
            {
                if (configGame[i][i] == numCPU)
                {
                    numCPUCase ++;
                }
                else if (configGame[i][i] == EMPTY)
                {
                    emptyCase = i;
                }
            }
            if (numCPUCase == 2 && emptyCase != -1)
            {
                configGame[emptyCase][emptyCase]= numCPU;
                return true;
            }
        }
        /*
        and
        . . x
        . x .
        x . .
        */
        {
            int numCPUCase = 0;
            int emptyCase = -1;
            for (int i = 0; i < SIZE; i++)
            {
                int iFlipped = SIZE-i-1;
                if (configGame[i][iFlipped] == numCPU)
                {
                    numCPUCase ++;
                }
                else if (configGame[i][iFlipped] == EMPTY)
                {
                    emptyCase = i;
                }
            }
            if (numCPUCase == 2 && emptyCase != -1)
            {
                int emptyCaseFlipped = SIZE-emptyCase-1;
                configGame[emptyCase][emptyCaseFlipped]= numCPU;
                return true;
            }
        }

        return false;
    }

    private static boolean CPUMove2(int[][] configGame, int numCPU, int numUser)
    {
        // Check vertical and horizontal
        for (int y = 0; y < SIZE; y++)
        {
            int numUserCase = 0;
            int emptyCase = -1;
            for (int x = 0; x < SIZE; x++)
            {
                if(configGame[y][x] == numUser)
                {
                    numUserCase ++;
                }
                else if (configGame[y][x]  == EMPTY)
                {
                    emptyCase = x;
                }
            }
            if (numUserCase == 2 && emptyCase != -1)
            {
                configGame[y][emptyCase] = numCPU;
                return true;
            }
        }
        for (int x = 0; x < SIZE; x++)
        {
            int numUserCase = 0;
            int emptyCase = -1;
            for (int y = 0; y < SIZE; y++)
            {
                if(configGame[y][x] == numUser)
                {
                    numUserCase ++;
                }
                else if (configGame[y][x]  == EMPTY)
                {
                    emptyCase = y;
                }
            }
            if (numUserCase == 2 && emptyCase != -1)
            {
                configGame[emptyCase][x] = numCPU;
                return true;
            }
        }
        /* Verify diagonal conditions
        x . .
        . x .
        . . x
         */
        {
            int numUserCase = 0;
            int emptyCase = -1;
            for (int i = 0; i < SIZE; i++)
            {
                if (configGame[i][i] == numUser)
                {
                    numUserCase ++;
                }
                else if (configGame[i][i] == EMPTY)
                {
                    emptyCase = i;
                }
            }
            if (numUserCase == 2 && emptyCase != -1)
            {
                configGame[emptyCase][emptyCase]= numCPU;
                return true;
            }
        }
        /*
        and
        . . x
        . x .
        x . .
        */
        {
            int numUserCase = 0;
            int emptyCase = -1;
            for (int i = 0; i < SIZE; i++)
            {
                int iFlipped = SIZE-i-1;
                if (configGame[i][iFlipped] == numUser)
                {
                    numUserCase ++;
                }
                else if (configGame[i][iFlipped] == EMPTY)
                {
                    emptyCase = i;
                }
            }
            if (numUserCase == 2 && emptyCase != -1)
            {
                int emptyCaseFlipped = SIZE-emptyCase-1;
                configGame[emptyCase][emptyCaseFlipped]= numCPU;
                return true;
            }
        }

        return false;
    }

    private static boolean CPUMove3(int[][] configGame, int numCPU, int numUser)
    {
        if (configGame[1][1] == EMPTY)
        {
            configGame[1][1] = numCPU;
            return true;
        }
        return false;
    }

    private static boolean CPUMove4(int[][] configGame, int numCPU, int numUser)
    {
        /*
        if x . .
           . . .
           . . .
        then
           x . .
           . . .
           . . O
        */
        if(configGame[0][0] == numUser)
        {
            configGame[2][2] = numCPU;
            return true;
        }
        /*
        if . . x
           . . .
           . . .
        then
           . . x
           . . .
           O . .
        */
        if(configGame[0][2] == numUser)
        {
            configGame[2][0] = numCPU;
            return true;
        }
        /*
        if . . .
           . . .
           . . X
        then
           O . .
           . . .
           . . x
        */
        if (configGame[2][2] == numUser)
        {
            configGame[0][0] = numCPU;
            return true;
        }
        /*
        if . . .
           . . .
           x . .
        then
           . . O
           . . .
           X . .
        */
        else if (configGame[2][0] == numUser)
        {
            configGame[0][2] = numCPU;
            return true;
        }
        return false;
    }

    private static boolean CPUMove5(int[][] configGame, int numCPU, int numUser)
    {
        /*
        if / . .
           . . .
           . . .
        then
           / . .
           . . .
           . . O
        */
        if(configGame[0][0] == EMPTY)
        {
            configGame[2][2] = numCPU;
            return true;
        }
        /*
        if . . /
           . . .
           . . .
        then
           . . /
           . . .
           O . .
        */
        if(configGame[0][2] == EMPTY)
        {
            configGame[2][0] = numCPU;
            return true;
        }
        /*
        if . . .
           . . .
           . . /
        then
           O . .
           . . .
           . . /
        */
        if (configGame[2][2] == EMPTY)
        {
            configGame[0][0] = numCPU;
            return true;
        }
        /*
        if . . .
           . . .
           / . .
        then
           . . O
           . . .
           / . .
        */
        else if (configGame[2][0] == EMPTY)
        {
            configGame[0][2] = numCPU;
            return true;
        }
        return false;
    }

    //if there is space, put numCPU in a random space
    private static boolean CPUMove6(int[][] configGame, int numCPU, int numUser)
    {
        int count = 0;
        int positionX = - 1;
        int positionY = - 1;

        for(int y = 0; y < SIZE; y ++) for(int x = 0; x < SIZE; x ++)
        {
            if(configGame[y][x] == EMPTY)
            {
                count ++;

                if((int) ((double) count * Math.random()) == 0)
                {
                    positionX = x;
                    positionY = y;
                }
            }
        }

        if(positionX != - 1 && positionY != - 1)
        {
            configGame[positionY][positionX] = numCPU;
            return true;
        }
        
        return false;
    }

    static void userMove(int[][] configGame, int numUser)
    {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[\\s,-]+"); // Regex pattern to accept space, comma and dash as delimiter
        int row = -1, column = -1;
        while (row == -1 && column == -1) {
            System.out.println("Write the position you want occupy [row][column]: ");
            row = sc.nextInt();
            column = sc.nextInt();
            if (row < 0 || row >= 3 || column < 0 || column >= 3) {
                System.out.println("\u001B[31mError: Position out of range!\u001B[0m");
                row = -1;
            }
            if (configGame[row][column] != 0){
                System.out.println("\u001B[31mError: Cell already occupied! Please select another cell.\u001B[0m");
                row = -1;
            }
        }
        configGame[row][column] = numUser;
    }

    // Method to check if victory condition is present
    public static boolean verifyVictory(int[][] configGame, int numCPU, int numUser)
    {

        int wiener = 0; // -1 CPU 1 USER

        // Vertical & Horizontal check
        for (int i = 0; i < configGame.length; i++) {
            int hSum = 0, vSum = 0, dSum = 0;
            for(int j = 0; j < configGame[i].length; j++){
                hSum += configGame[i][j];
                vSum += configGame[j][i];
            }
            if (hSum == (numCPU * 3) || vSum == (numCPU * 3)){
                wiener = -1;
                break;
            }else if(hSum == (numUser * 3) || vSum == (numUser * 3)){
                wiener = 1;
                break;
            }
        }

        // Diagonal check
        int lDiagSum = 0;
        int rDiagSum = 0;
        for (int i = 0; i < configGame.length; i++)
        {
            lDiagSum += configGame[i][i];
            rDiagSum += configGame[i][configGame.length-i-1];
        }
        if (lDiagSum == (numCPU * 3) || rDiagSum == (numCPU * 3)){
            wiener = -1;
        }else if (lDiagSum == (numUser * 3) || rDiagSum == (numUser * 3)){
            wiener = 1;
        }

        if (wiener != 0){
            System.out.println(((wiener == -1)? "CPU " : "USER ") + "have won the game!");
            return true;
        }
        return false;
    }
}