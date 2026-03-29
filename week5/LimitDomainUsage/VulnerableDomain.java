import java.util.Scanner;
public class VulnerableDomain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL to connect:");
        String url = sc.nextLine();
        // Vulnerable Accepts any URL
        System.out.println("Connecting to: " + url);
        // attacker can enter
        // http://malicious.com to steal data
        // server will connect blindly
        sc.close();
    }
}