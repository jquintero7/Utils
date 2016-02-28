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
        charValue++;
        charDict.put(charValue, (char)95); //_

        dictSize = charDict.size();
    }

    private void encrypt() {
        System.out.print("Enter the message to encrypt: ");
        message = keyboard.nextLine();
        messageLength = message.length();
        messageNumbers = new int[messageLength];

        generateKeyPAD();
        String encryptedMessage = "";
        int PADcount = 0;
        for (int key : charDict.keySet())
        {
            for(int count = 0; count < messageLength; count++)
            {
                if(message.charAt(count) == charDict.get(key))
                {
                    int newkey = key + keyPAD[PADcount];
                    newkey = newkey > dictSize ? newkey - dictSize : newkey;
                    encryptedMessage += charDict.get(newkey);
                    PADcount++;
                }
            }
        }
        System.out.println(encryptedMessage);
    }

    private void decrypt() {

    }

    /**
     * Method to get the key from a value in a HashMap
     * @param hashMap the HashMap.
     * @param value the value being used to get the key..
     * @return the value's key.
     */
    private Object getKeyFromValue(Map hashMap, Object value) {
        for (Object key : hashMap.keySet())
        {
            if(hashMap.get(key).equals(value))
                return key;
        }
        return null;
    }


    private void generateKeyPAD() {
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
