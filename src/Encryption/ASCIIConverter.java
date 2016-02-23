package Encryption;

import java.util.Scanner;

public class ASCIIConverter {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String answer;
        do {
            System.out.print("Enter a String: ");
            String word = keyboard.nextLine();

            System.out.print("Enter value for conversion: ");
            int convertingValue = keyboard.nextInt();

            System.out.println(word + "\t" + convertingValue);

            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++)
            {
                charArray[i] = (char) (charArray[i] + convertingValue);
            }
            String convertedWord = "";
            for (int i = 0; i < charArray.length; i++)
            {
                convertedWord += charArray[i];
            }
            System.out.println(convertedWord + " +" + convertingValue);

            convertedWord = "";
            charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++)
            {
                charArray[i] = (char) (charArray[i] - convertingValue);
            }
            for (int i = 0; i < charArray.length; i++)
            {
                convertedWord += charArray[i];
            }
            System.out.println(convertedWord + " -" + convertingValue);

            System.out.print("Again? (y/n): ");
            answer = keyboard.next();
            keyboard.nextLine();
        }while(answer.equals("y"));
    }

}
