package Encryption;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Symmetric-Key Encryption
 * Created by Jerry
 * Last Edit: 2/24/2016.
 */
public class SymmetricKeyEncryption {

    private Scanner keyboard;
    private String message;
    private int messageLength;
    private int[] messageNumbers;
    private int[] key;
    private HashMap<Integer, Character> charDict;

    public SymmetricKeyEncryption() {
        createDictionary();
        keyboard = new Scanner(System.in);
        System.out.print("Encrypt, decrypt, or quit?(e/d/q): ");
        String option = keyboard.next();
        keyboard.nextLine();

        if(option.equalsIgnoreCase("e"))
        {
            encrypt();
        }
        else if(option.equalsIgnoreCase("d"))
        {
            decrypt();
        }
        keyboard.close();
    }

    private void createDictionary() {
        charDict = new HashMap<Integer, Character>();
        //Add the capital letters to the dictionary.
        int charValue = 1;
        for(int i = 65; i < 91; i++)
        {
            charDict.put(charValue, (char)i);
            charValue++;
        }
        //Add the lower case letters to the dictionary.
        for(int i = 97; i < 123; i++)
        {
            charDict.put(charValue, (char)i);
            charValue++;
        }
        //Add commonly used punctuation.
        charValue++;
        charDict.put(charValue, (char)46); //.
        charValue++;
        charDict.put(charValue, (char)44); //,
        charValue++;
        charDict.put(charValue, (char)33); //!
        charValue++;
        charDict.put(charValue, (char)63); //?
        charValue++;
        charDict.put(charValue, (char)45); //-
    }

    private void encrypt() {
        System.out.print("Enter the message to encrypt: ");
        message = keyboard.nextLine();
        messageLength = message.length();
        messageNumbers = new int[messageLength];
        generateKey();
        for(int i = 0; i < messageLength; i++)
        {
            for (Map.Entry<Integer, Character> entry: charDict.entrySet())
            {
                if(entry.getValue().equals(message.charAt(i)))
                {
                    System.out.println(charDict.get(i) + " " + entry.getKey());
                }
            }
        }
    }

    private void decrypt() {

    }

    private void generateKey() {
        Random random = new Random();
        int maxValue = charDict.size();
        key = new int[messageLength];

        for(int i = 0; i < messageLength; i++)
        {
            key[i] = random.nextInt(maxValue) + 1;
        }
    }
    public static void main(String[] args) {
        new SymmetricKeyEncryption();
    }

}
