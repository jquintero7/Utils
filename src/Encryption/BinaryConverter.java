package Encryption;

import java.util.Scanner;

public class BinaryConverter {

    private String userInput; //Holds the user's input, binary or phrase.
    private int numberOfBytes; //Holds the number of bytes in the String, 1 ca
    private String[] binaryStrings;
    private byte[] sequenceBytes;

    public BinaryConverter(String input, boolean isBinary) {
        if(isBinary)
        {
            userInput = input;
            convertBinaryToString();
        }
        else
        {
            userInput = input;
            convertStringToBinary();
        }
    }

    private void convertBinaryToString() {
        int length = userInput.length();
        if(length % 8 != 0)
        {
            System.out.println("Not true binary!");
            System.exit(0);
        }
        numberOfBytes = length/8;
        binaryStrings = new String[numberOfBytes];
        sequenceBytes = new byte[numberOfBytes];


        int start = 0, end = 8;
        for(int i = 0; i < numberOfBytes; i++)
        {
            binaryStrings[i] = userInput.substring(start, end);
            sequenceBytes[i] = Byte.parseByte(binaryStrings[i], 2);
            start += 8;
            end += 8;
        }
    }

    private void convertStringToBinary() {
        sequenceBytes = userInput.getBytes();
        numberOfBytes = sequenceBytes.length;
        binaryStrings = new String[numberOfBytes];
        for(int i = 0; i < numberOfBytes; i++)
        {
            binaryStrings[i] = String.format("%8s", Integer.toBinaryString(sequenceBytes[i])).replace(' ', '0');
        }
    }

    @Override
    public String toString() {
        String str = "";
        String phrase = "";
        String binary = "";
        for(int num = 0; num < numberOfBytes; num++)
        {
            str += binaryStrings[num] + " = " + sequenceBytes[num] + "\t" + (char)sequenceBytes[num] + "\n";
            phrase += (char)sequenceBytes[num];
            binary += binaryStrings[num];
        }
        str += "Phrase: " + phrase;
        str += "\nBinary: " + binary;
        return str;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Phrase or binary sequence(P/B): ");
        if(keyboard.nextLine().equalsIgnoreCase("B"))
        {
            System.out.print("Enter the binary sequence: ");
            BinaryConverter bc = new BinaryConverter(keyboard.nextLine().replaceAll("\\s+", ""), true);
            System.out.println(bc.toString());
        }
        else
        {
            System.out.print("Enter a phrase: ");
            BinaryConverter bc = new BinaryConverter(keyboard.nextLine(), false);
            System.out.println(bc.toString());
        }
    }
}