package JavaTools;

import java.util.Random;

public class Example {

    public static void main(String[] args) {
        int[][] player = new int[5][2];
        player[0][0] = 1;
        player[0][1] = 4;

        player[1][0] = 1;
        player[1][1] = 5;

        player[2][0] = 1;
        player[2][1] = 8;

        player[3][0] = 1;
        player[3][1] = 7;

        player[4][0] = 1;
        player[4][1] = 7;

        boolean spade = false, club = false, heart = false, diamond = false;

        for (int i = 0; i < player.length; i++)
        {
            for (int j = 0; j < player.length; j++)
            {
                if(i == j)
                    continue;
                if(player[i][1] == player[j][1])
                {
//                    if(!spade)
                        System.out.println("PAIR: " + player[i][1] + " " + player[j][1]);
//                    switch (numbers[i][0])
//                    {
//                        case 1:
//                            spade = true;
//                            break;
//                        case 2:
//                            club = true;
//                            break;
//                    }
                }
            }
        }


    }

}
