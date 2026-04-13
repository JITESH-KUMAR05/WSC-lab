import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;

public class XFrameSecure {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", exchange -> {
            exchange.getResponseHeaders().add("X-Frame-Options", "DENY"); // prevent framing
            // or same origin
            String response = "<h2>Secure Page</h2>" + "<p>X-Frame-Options header set to DENY</p>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
        System.out.println("Secure Server started on http://localhost:8000");
    }
}