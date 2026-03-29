import java.io.*;
import java.net.*;

public class serverHijacVul {
    public static void main(String[] args) throws Exception {
        // vulnerable server
        ServerSocket server = new ServerSocket(6003);
        System.out.println("Server is listening on port 6003...");

        Socket socket = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Enter the command");
        String command = in.readLine();
        System.out.println("Received command: " + command);

        Runtime.getRuntime().exec(command);
        System.out.println("Executed command: " + command);
        socket.close();
        server.close();
        
    }
}