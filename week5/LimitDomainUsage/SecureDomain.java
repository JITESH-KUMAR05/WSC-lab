import java.util.*;

public class SecureDomain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Secure: Validate the URL against a whitelist
        List<String> allowed = Arrays.asList("example.com", "localhost");
        
        System.out.println("Enter Domain to connect:");
        String url = sc.nextLine();
        
        if (allowed.contains(url)) {
            System.out.println("Connecting to: " + url);
            // Proceed with connection
        } else {
            System.out.println("Invalid URL. Connection denied.");
        }
        sc.close();
    }
}