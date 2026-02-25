import java.net.*;
import java.io.*;

public class VulnerableServer {
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Vulnerable server started on port 5000");
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );
        String message = in.readLine(); // no validation
        System.out.println("client Says: " + message);

        socket.close();
        serverSocket.close();
    }
}