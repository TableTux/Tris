/*
Esercizio 6 (Gioco del Tris)
Scrivere un programma Java che consenta all’utente di giocare a Tris contro il computer.
Il computer gioca secondo le seguenti regole, prese dal Capitolo 1 del libro “L’Algoritmo Definitivo.
La macchina che impara da sola e il futuro del nostro mondo”, di Pedro Domingos, edizioni Bollati
Boringhieri (2016):
1. se l'avversario ha occupato due caselle di fila, occupare la casella rimanente;
2. altrimenti, se c'è una mossa che crea due coppie di caselle adiacenti in un colpo solo,
scegliere quella;
3. altrimenti, se la casella centrale è libera, occuparla;
4. altrimenti, se l'avversario ha occupato una casella d'angolo, occupare la casella opposta;
5. altrimenti, se c'è un angolo vuoto, occuparlo;
6. altrimenti, occupare una casella vuota qualsiasi.
Il programma chiederà anzitutto se l’utente vuole fare o no la prima mossa, e poi giocherà secondo
le regole date sopra. Assegnare il simbolo O all’utente, mentre il computer userà il simbolo X.
La classe Metodi conterrà almeno i seguenti metodi:
 stampaConfigurazioneDiGioco(): stampa la configurazione attuale del gioco (di cui si passa
    un riferimento, come argomento), secondo lo schema che segue:
O|O|O
-+-+-
|X|
-+-+-
X|X|
 creaNuovaConfigurazione(): crea una nuova tabella, vuota, pronta per giocare. Restituisce
    al chiamante un riferimento a tale tabella;
 mossaComputer(): prende come argomento un riferimento alla configurazione attuale del
    gioco, ed esegue la prossima mossa del computer, secondo le regole riportate sopra;
 mossaUtente(): prende come argomento un riferimento alla configurazione attuale del gioco,
    e chiede all’utente di fare la propria mossa. Se l’utente specifica una casella già occupata,
    stampa un opportuno messaggio d’errore e chiede nuovamente di specificare la mossa;
 verificaVittoria(): prende come argomento un riferimento alla configurazione attuale del
    gioco, e restituisce al chiamante: 1 se l’utente ha vinto, – 1 se il computer ha vinto, 0 se non
    ha vinto nessuno.
Prima di invocare i metodi mossaComputer() e mossaUtente(), assicurarsi che sia effettivamente
possibile fare una mossa.
Osservazione finale: nel libro di Domingos si dice che l’algoritmo è ottimale, nel senso che non
perde mai. Giocare qualche partita per vedere se è vero!
 */


import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class UnDosTrisJVM
{

    static final int X = 1;
    static final int O = -1;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Let's play Tic Tac Toe!");
        String userChoice = "choose";
        while (!userChoice.equalsIgnoreCase( "X") && !userChoice.equalsIgnoreCase("O"))
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a character between 'X' and 'O':");
            System.out.print(">");
            userChoice = scanner.nextLine();
            if (!userChoice.equalsIgnoreCase("X") && !userChoice.equalsIgnoreCase("O"))
            {
                System.out.println("\u001B[31mError: the character chosen must be 'X' or 'O'\u001B[0m");
                continue;
            }
        }
        int numCPU = 0, numUser = 0;
        if (userChoice.equalsIgnoreCase("X"))
        {
            numUser = X;
            numCPU = O;
        }
        else
        {
            numUser = O;
            numCPU = X;
        }


        int[][] config = Methods.createNewConfig();
        Methods.printConfigGame(config);

        //Methods.CPUMove(config, numCPU, numUser);

        // Game Loop while user response is yes to new match
        boolean gameFinished = false;

        // Who starts the game
        int whoStarts = (int) Math.random() * 1; // if 0 cpu else user
        while(!gameFinished){

            Methods.userMove(config, numUser);
            if (Methods.verifyVictory(config, numCPU, numUser)){
                gameFinished = true;
            }
            Methods.printConfigGame(config);
            Thread.sleep(1000);
            clearScreen();
            System.out.println(">>CPU is doing their move<<");
            Thread.sleep(1500);
            Methods.CPUMove(config, numCPU, numUser);
            if (Methods.verifyVictory(config, numCPU, numUser)){
                gameFinished = true;
            }
            Methods.printConfigGame(config);
        }
    }
}

