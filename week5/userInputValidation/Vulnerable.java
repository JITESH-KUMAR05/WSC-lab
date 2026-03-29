import java.util.*;

public class Vulnerable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        // Vulnerable: No validation on user input
        System.out.println("Hello, " + name + "!");
        sc.close();
    }
}