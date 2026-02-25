import java.net.*;
import java.io.*;


public class SecureServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("secure server started on port 5000");
        Socket socket = serverSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );
        String message = in.readLine();

        // testing + validation

        if(message == null || message.trim().isEmpty()){
            out.println("Rejected: Empty message");
        }
        else if(message.length() > 50){
            out.println("Rejected: Message too long");
        }
        else if(!message.matches("[a-zA-Z0-9]+")){
            out.println("Rejected: Ivalid Characters");
        }
        else{
            out.println("Message Accepted: " + message);
        }

        socket.close();
        serverSocket.close();


    }    
}
