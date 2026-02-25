import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;

public class SecureHttpServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/submit", exchange -> {
            // simulated user input (query string)
            String query = exchange.getRequestURI().getQuery();
            String message = "";
            if(query != null && query.startsWith("msg=")){
                message = query.substring(4); // extract message after "msg="
            }
            String response;
            // input testing + validation
            if(message.isEmpty()){
                response = "<h2> Rejected: Empty message </h2>";
            }
            else if(message.length() > 50){   
                response = "<h2> Rejected: Message too long </h2>";
            }
            else if(!message.matches("[a-zA-Z0-9]+")){
                response = "<h2> Rejected: Invalid Characters </h2>";
            }
            else{
                response = "<h2> Message Accepted: " + message + "</h2>";
            }
            exchange.getResponseHeaders().set("Content-Type","text/html" );
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
        System.out.println("Secure HTTP Server started on port http://localhost:8000/submit?msg=Hello");
    }
}