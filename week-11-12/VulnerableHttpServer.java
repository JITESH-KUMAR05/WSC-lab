import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;

public class VulnerableHttpServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/submit", exchange -> {
            // simulated user input (query string)
            String query = exchange.getRequestURI().getQuery();
            //  Example: /submit?msg=Hello
            exchange.getResponseHeaders().set("Content-Type","text/html" );
            String response = "<h2> User Message: " + query + "</h2>"; 
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
        System.out.println("Vulnerable HTTP Server started on port http://localhost:8000/submit?msg=Hello");
        
    }
}