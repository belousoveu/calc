import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
String expression = new Scanner(System.in).nextLine();
byte operation=getOperation(expression);
    }

    private static byte getOperation(String expression) {
    byte result=0;
    if (expression.indexOf('+')!=-1) {
        result=1;
    }
    return result;

    }
}