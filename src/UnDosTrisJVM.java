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


import java.util.Scanner;

public class UnDosTrisJVM
{

    static final int X = 1;
    static final int O = -1;

    public static void main(String[] args)
    {
        System.out.println("Let's play Three in a Row!");
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
        int numCPU ;
        int numUser ;
        if (userChoice.equalsIgnoreCase("X"))
        {
            numUser = X;
            numCPU = O;
        }
        else { numUser = O; numCPU = X; }

        int[][] config = Methods.createNewConfig();
        Methods.printConfigGame(config);

        Methods.CPUMove(config, numCPU, numUser);
        
        int[][] testArray = {
                {1,1,1},
                {0,0,0},
                {0,0,0}
        };
        Methods.verifyVictory(testArray, 1, -1);
    }
}
