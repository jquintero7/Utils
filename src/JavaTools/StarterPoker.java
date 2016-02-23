package JavaTools;

/*
* CSIT 150
* Generating Poker Hands
* Created by: Jaeseung Lee
* date 01-25-2016
*/

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author Jaeseung
 */
public class StarterPoker {

    public static void disPlayIntro() {
        String prompt = "This program will start \n" +
                " two hands of poker.\n\n" +
                " Both hands will be displayed\n\n" +
                " It will play 5 rounds then" +
                " After five hands, program will determine" +
                " which player had the most wins" +
                " Then you will be asked if you wish to\n" +
                " play another game\n";
        System.out.println(prompt);
    }

    public static int countingCards(int[][] player, int number) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (i == j)
                    continue;
                if (player[i][1] == player[j][1]) {
                    counter += 1;
                    System.out.println("player" + number + " has " + counter + " pair");
                    System.out.println(player[i][1] + " " + player[j][1] + "\n");
                    return 0;
                }
            }
            if (i == 4)
                System.out.println("player" + number + " has no pair");
        }
        return -1;
    }

    public static void main(String[] args)
    {
        disPlayIntro();
        //int[][] deck = new int[13][4];
        int[][] player1 = new int[5][2];
        int[][] player2 = new int[5][2];
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int gameCounter = 0;
        boolean done = false;
        while (!done)
        {
            int[][] deck = new int[13][4]; //JERRY I moved this here to reset the value of deck and to stop the infinite loop.
            Random randGen = new Random();
            String hand1 = "";
            //dealing hand 1
            for (int dex = 0; dex < player1.length; dex++)
            {
                boolean goodCard = false;

                while (!goodCard)
                {
                    int suit = randGen.nextInt(4);
                    int card = randGen.nextInt(13);
                    if (deck[card][suit] == 0) //JERRY This is where the infinite loop was happening, since deck wasn't being reset.
                    {
                        goodCard = true;
                        deck[card][suit] = 1;
                        player1[dex][0] = suit;
                        player1[dex][1] = card;
                        hand1 += "     " + cards[card] + " of " + suits[suit] + "\n";
                    }
                    if(gameCounter == 5) //JERRY This is how I found the infinite loop.
                        System.out.println("I'm STUCK!!!!");
                }
            }

            String hand2 = "";
            //dealing hand 2
            for (int dex = 0; dex < player2.length; dex++)
            {
                boolean goodCard = false;
                while (!goodCard)
                {
                    int suit = randGen.nextInt(4);
                    int card = randGen.nextInt(13);
                    if (deck[card][suit] == 0)
                    {
                        goodCard = true;
                        deck[card][suit] = 1;
                        player2[dex][0] = suit;
                        player2[dex][1] = card;
                        hand2 += "     " + cards[card] + " of " + suits[suit] + "\n";
                    }
                }
            }
            String results = "The first hand of cards:\n\n" + hand1 + "\n\n\n";
            System.out.println("-+-+-+-+-+-+-+-+-");
            countingCards(player1, 1);
            countingCards(player2, 2);
            System.out.println("-+-+-+-+-+-+-+-+-");
            gameCounter += 1;
            results += "The second hand of cards:\n\n" + hand2 + "\n";
            if (gameCounter < 5)
            {
                results += "Do you want another two hands?\nenter 'Y'  or 'N'";
            }
            else
            {
                results += "If you want to play another game" + "\nenter 'Y'  or 'N'";
            }
            String ans = JOptionPane.showInputDialog(null, results, "game" + gameCounter, 1);
            if (ans.equalsIgnoreCase("Y"))
            {
                if(gameCounter == 5)
                {
                    gameCounter = 0;
                    done = false;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Program terminating!", "Generate Poker Hands", 1);
                System.exit(0);
            }
        }
    }
}