package JavaUtils;

public class JavaSyntax {

    public static void main(String[] args) {
        //varArgs();
        //ternaryOperator();
        lambdaExpresson();
    }

    public static void varArgs() {
        int[] firstList = {1, 2, 3, 4, 5, 6, 7};
        int[] secondList = {10, 100, 1000, 10000};
        printLists(firstList);
        printLists(secondList);
    }

    private static void printLists(int... numbers) {
        for(int num : numbers)
        {
            System.out.println(num);
        }
    }

    public static void ternaryOperator() {
        /* Ternary Conditional Operator */
        /* boolean statement ? true result : false result */
        System.out.println(true ? "true!" : "false");
        System.out.println(false ? "true" : "false!");

        int num1 = 0, num2 = 1;
        int result = num1 == num2 ? 7 : 11;
        System.out.println(result);
    }

    public static void lambdaExpresson() {
        Message test1 = message ->
                System.out.println("Hello " + message);
        Message test2 = (message) ->
                System.out.println("Hello " + message + ", this is a lambda!!");
        test1.printMessage("World");
        test2.printMessage("World");

        Math operation1 = (int firstNum, int secondNum) ->
                System.out.println(firstNum + secondNum);
        Math operation2 = (int num1, int num2) ->
                System.out.println(num1 * num2);
        operation1.operate(5, 2);
        operation2.operate(7, 7);
    }

    interface Message {
        void printMessage(String message);
    }

    interface Math {
        void operate(int numb1, int num2);
    }

}
