package JavaUtils;

import java.util.Scanner;
import javax.swing.*;

public class CustomMessage {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, keyboard.nextLine(), "", JOptionPane.INFORMATION_MESSAGE);
        keyboard.close();
    }

}