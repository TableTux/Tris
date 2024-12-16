public class Methods
{
    private static char convertNumToChar(int num)
    {
        switch (num)
        {
            case 1 : return 'X';
            case -1 : return 'O';
            default : return ' ';
        }
    }

    static void printConfigGame( int[][] configGame)
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
    }

    private static boolean CPUMove1(int[][] configGame, int numCPU, int numUser)
    {
        // Check vertical and horizontal
        for (int y = 0; y < 3; y++)
        {
            int numUserCase = 0;
            int emptyCase = -1;
            for (int x = 0; x < 3; x++)
            {
                if(configGame[y][x] == numUser)
                {
                    numUserCase ++;
                }
                else if (configGame[y][x]  == 0)
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
        for (int x = 0; x < 3; x++)
        {
            int numUserCase = 0;
            int emptyCase = -1;
            for (int y = 0; y < 3; y++)
            {
                if(configGame[y][x] == numUser)
                {
                    numUserCase ++;
                }
                else if (configGame[y][x]  == 0)
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
            for (int i = 0; i < 3; i++) {
                if (configGame[i][i] == numUserCase) {
                    numUserCase++;
                }
                if (configGame[i][i] == 0) {
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
            for (int i = 0; i < 3; i++) {
                if (configGame[i][2-i] == numUserCase) {
                    numUserCase++;
                }
                if (configGame[i][2-i] == 0) {
                    emptyCase = 2-i;
                }
            }
            if (numUserCase == 2 && emptyCase != -1)
            {
                configGame[emptyCase][emptyCase]= numCPU;
                return true;
            }
        }

        return false;
    }

    private static boolean CPUMove2(int[][] configGame, int numCPU, int numUser)
f    private static boolean CPUMove3(int[][] configGame, int numCPU, int numUser)
    {
        if(configGame[1][1] == 0)
        {
            configGame[1][1] = numCPU;
            return true;
        }

        return false;
    }
    private static boolean CPUMove4(int[][] configGame, int numCPU, int numUser)
    {
        /*
        if
         */
        if(configGame[0][0] ==0)
        {
            configGame[2][2] = numCPU;
        }
        if(configGame[0][2] == 0)
        {
            configGame[2][0] = numCPU;
        }
        if ()
    }

    static void userMove(int[][] configGame, int numCPU, int numUser)
    {

    }
    // Method to check if victory condition is present
    public static void verifyVictory(int[][] configGame, int numCPU, int numUser)
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
            rDiagSum += configGame[i][configGame.length-1];
        }
        if (lDiagSum == (numCPU * 3) || rDiagSum == (numCPU * 3)){
            wiener = -1;
        }else if (lDiagSum == (numUser * 3) || rDiagSum == (numUser * 3)){
            wiener = 1;
        }

        if (wiener != 0){
            System.out.println((wiener == -1)? "CPU " : "USER " + "have won the game!");
        }
    }
}