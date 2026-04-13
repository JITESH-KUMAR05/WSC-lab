import java.io.*;
import java.net.*;

public class HttpCookieUnsafe {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server running on port 8080...");

        while (true) {
            Socket socket = server.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String response =
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n\r\n" +
                    "<h1>Welcome Guest</h1>";

            out.println(response);
            out.flush();
            socket.close();
        }
    }
}