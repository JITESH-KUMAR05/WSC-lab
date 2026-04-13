import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.List;

public class HttpCookieSafe {
    public static void main(String args[]) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
        server.createContext("/", exchange -> {
            String response;
            Headers requestHeaders = exchange.getRequestHeaders()
        })
    }
}