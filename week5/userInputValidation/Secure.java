import java.util.*;

public class Secure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        // Secure: Validate the input to prevent malicious content
        if (name.matches("[a-zA-Z ]+")) {
            System.out.println("Hello, " + name + "!");
        } else {
            System.out.println("Invalid input. Please enter a valid name.");
        }
        sc.close();
    }
}