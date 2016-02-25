package JavaUtils;

public class JavaSyntax {

    public static void main(String[] args) {
        //ternaryOperator();
        lambdaExpresson();
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
        //(null) -> System.out.println("Zero argumets.");
    }

}
