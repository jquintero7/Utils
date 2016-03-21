package Encryption;

import java.util.HashMap;
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
    private int[] keyPAD;
    private HashMap<Integer, Character> charDict;
    private int dictSize;

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
        //Add commonly used punctuation and space.
        charDict.put(charValue, (char)46); //.
        charValue++;
        charDict.put(charValue, (char)44); //,
        charValue++;
        charDict.put(charValue, (char)32); //Space
        charValue++;
        charDict.put(charValue, (char)33); //!
        charValue++;
        charDict.put(charValue, (char)63); //?
        charValue++;
        charDict.put(charValue, (char)45); //-
        charValue++;
        charDict.put(charValue, (char)95); //_

        dictSize = charDict.size();
    }

    private void encrypt() {
        System.out.print("Enter the message to encrypt: ");
        message = keyboard.nextLine();
        messageLength = message.length();
        generatePADKey(); //Create the randomized PAD Key.

        //Apply the encrypting algorithm for SymmetricKeyEncryption.
        String encryptedMessage = "";
        int PADCount = 0;
        for(int count = 0; count < messageLength; count++)
        {
            for(int key : charDict.keySet())
            {
                if(message.charAt(count) == charDict.get(key))
                {
                    int newKey = key + keyPAD[PADCount]; //Add the generated PAD Key.
                    newKey = newKey > dictSize ? newKey - dictSize : newKey; //Check for results over the character count.
                    encryptedMessage += charDict.get(newKey);
                    PADCount++;
                }
            }
        }
        System.out.println(encryptedMessage);
        for(int i : keyPAD)
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    private void decrypt() {
        System.out.print("Enter a message to decrypt: ");
        message = keyboard.nextLine();
        messageLength = message.length();

        //Separate the PAD Key by it's delimiter.
        System.out.print("Enter the PAD key: ");
        String PAD = keyboard.nextLine().trim();
        String PADStrings[] = PAD.split(/*String.valueOf(PAD.charAt(2))*/ " ");
        if(PADStrings.length != message.length())
        {
            System.out.println("Message length and PAD key length need to match!" +
                                "\nMessage length: " + messageLength +
                                "\nPAD Key length: " + PADStrings.length);
            System.exit(0);
        }
        //Convert the Strings into integers.
        keyPAD = new int[PADStrings.length];
        for(int count = 0; count < PADStrings.length; count++)
        {
            keyPAD[count] = Integer.parseInt(PADStrings[count]);
        }

        //Apply the decrypting algorithm for SymmetricKeyEncryption.
        String decryptedMessage = "";
        int PADCount = 0;
        for(int count = 0; count < messageLength; count++)
        {
            for(int key : charDict.keySet())
            {
                if(message.charAt(count) == charDict.get(key))
                {
                    int newkey = key - keyPAD[PADCount]; //Generate the new key by subtracting the PAD.
                    newkey = newkey < 1 ? newkey + dictSize : newkey; //Check for results under the character count.
                    decryptedMessage += charDict.get(newkey);
                    PADCount++;
                }
            }
        }
        System.out.println(decryptedMessage);
    }

    private void generatePADKey() {
        Random random = new Random();
        int maxValue = charDict.size();
        keyPAD = new int[messageLength];

        for(int i = 0; i < messageLength; i++)
        {
            keyPAD[i] = random.nextInt(maxValue) + 1;
        }
    }

    public static void main(String[] args) {
        new SymmetricKeyEncryption();
    }

}
