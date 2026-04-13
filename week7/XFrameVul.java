import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;

public class XFrameVul {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", exchange -> {
            String response = "<h2>Vulnerable Page</h2>" + "<p>No X-Frame-Options header set</p>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
        System.out.println("Vulnerable Server started on http://localhost:8000");
    }
}