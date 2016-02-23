package Encryption;

public class XOR {

    public static void main(String[] args) {
        String string1 = "This is a really long string that is supposed to fill 64 bits!!!";
        String string2 = "AJGNDMITOELPTNGHSBYTJEODKBMTIGLOPECDSJFNGJDTEFGJSDECXZWQITUYHTIG";
        String xoredString = "";
        //string1 = string1.toUpperCase();

        int stringLength = string1.length();
        for(int i = 0; i < stringLength; i++)
        {
            int value = (int)string1.charAt(i) ^ (int)string2.charAt(i);
            xoredString += (char)value;
        }
        System.out.println(xoredString);
    }

}
