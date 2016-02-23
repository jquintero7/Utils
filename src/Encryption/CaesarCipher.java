package Encryption;

import java.util.Scanner;

public class CaesarCipher {

    private Scanner keyboard;
    private String prevEncryption = "";
    private int key;

    public CaesarCipher() {
        keyboard = new Scanner(System.in);
        String option;
        do
        {
            System.out.print("Encrypt, decrypt, or quit?(e/d/q): ");
            option = keyboard.next();
            keyboard.nextLine();
            if(option.equalsIgnoreCase("q"))
                break;
            else if(option.equalsIgnoreCase("e"))
            {
                encrypt();
            }
            else if(option.equalsIgnoreCase("d"))
            {
                decrypt();
            }
        } while(option.equalsIgnoreCase("e") || option.equalsIgnoreCase("d"));
        keyboard.close();
    }

    public void encrypt() {
        String input;

        System.out.print("Enter a message: ");
        input = keyboard.nextLine();
        System.out.print("Enter the value to shift: ");
        int shift = keyboard.nextInt();

        String encryptedPhrase = shiftCharacters(input, shift);
        key = 26 - shift;

        prevEncryption = encryptedPhrase;
        System.out.println(input +  "\n" + encryptedPhrase + "\nKey: " + key);
    }

    public void decrypt() {
        if(!prevEncryption.equals(""))
        {
            System.out.print("Use previously encrypted message?(y/n): ");
            String option = keyboard.nextLine();
            if(option.equalsIgnoreCase("y"))
            {
                String message = shiftCharacters(prevEncryption, key);
                System.out.println(prevEncryption + "\n" + message);
            }
            else if(option.equalsIgnoreCase("n"))
            {
                prevEncryption = "";
                key = -1;

                System.out.print("Enter a message to decrypt: ");
                String messageToDecrypt = keyboard.nextLine();
                System.out.print("Enter the key: ");
                int keyVal = keyboard.nextInt();
                String message = shiftCharacters(messageToDecrypt, keyVal);

                System.out.println(messageToDecrypt + "\n" + message);
            }
        }
        else
        {
            System.out.print("Enter a message to decrypt: ");
            String messageToDecrpyt = keyboard.nextLine();
            System.out.print("Enter the key: ");
            int keyVal = keyboard.nextInt();
            String message = shiftCharacters(messageToDecrpyt, keyVal);

            System.out.println(message);
        }
    }

    public String shiftCharacters(String phrase, int shift) {
        String shiftedPhrase = "";
        int phraseLength = phrase.length();
        for(int i = 0; i < phraseLength; i++)
        {
            int asciiValue = (int)phrase.charAt(i);
            if(asciiValue >= 65 && asciiValue <= 90)
            {
                asciiValue += shift;
                if(asciiValue >= 65 && asciiValue <= 90)
                {
                    shiftedPhrase += (char)asciiValue;
                }
                else if(asciiValue > 90)
                {
                    shiftedPhrase += (char)((asciiValue - 90) + 64);
                }
            }
            else if(asciiValue >= 97 && asciiValue <= 122)
            {
                asciiValue += shift;
                if(asciiValue >= 97 && asciiValue <= 122)
                {
                    shiftedPhrase += (char)asciiValue;
                }
                else if(asciiValue > 122)
                {
                    shiftedPhrase += (char)((asciiValue - 122) + 96);
                }
            }
            else
            {
                shiftedPhrase += phrase.charAt(i);
            }
        }
        return shiftedPhrase;
    }

    public static void main(String[] args) {
        new CaesarCipher();
    }
}