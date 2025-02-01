package ip.src.main.java;
import java.util.Scanner;

public class Eepy {

    public static void echo (String[] args){
        System.out.println("Start Echo");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        System.out.println("_____________________________________");
        while (!userInput.equals("bye")) {
            System.out.println("    Echo: " + userInput);
            System.out.println("_____________________________________");
            userInput = input.nextLine();
            System.out.println("_____________________________________");
        }
        System.out.println("End of Echo, bye! Hope to see you again soon :>");
        System.out.println("_____________________________________");
    }
    public static void main(String[] args) {
        System.out.println("_____________________________________");
        System.out.println("Hello! I'm Eepy" + "\n" + "What can I do for you?");
        echo(args);
    }
}
