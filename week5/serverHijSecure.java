import java.io.*;
import java.net.*;

public class serverHijSecure {
    public static final List<String> allowedCommands = Arrays.asList("TIME", "DATE", "HELLO");
    public static void main(String[] args) throws Exception {
       
        // secure server
        ServerSocket server = new ServerSocket(6003);
        System.out.println("Server is listening on port 6003...");

        Socket socket = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Enter the command");
        String command = in.readLine();
        System.out.println("Received command: " + command);

        if(allowedCommands.contains(command.toUpperCase())) {
            // Execute the command securely (e.g., using a predefined set of commands)
            System.out.println("Executing command: " + command);
            // Here you can implement the logic to execute the allowed commands
        } else {
            System.out.println("Invalid command received: " + command);
        }
        
        socket.close();
        server.close();
    }
}