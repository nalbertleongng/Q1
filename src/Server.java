import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.*;

public class Server {

    static void clientHandler(Socket socket) {

        try (socket;
             Scanner in = new Scanner(socket.getInputStream());
             PrintWriter out = new PrintWriter(socket.getOutputStream())) {

            // generate random number
            // print the number (on server side) for debugging (use System.out.println)

            // initialize guess count
            // send a string to the client using **out**, tell the client to start playing
            // out.flush() can be used to send immediately
            // note: you may use \r\n at the end of each String to tell client to print a new line

            // repeatedly get client's input by **in**
            // update guess count and response using out (exit the loop when correct)
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String args[]) {
        int port;
        if(args.length!=1)
            port = 2000;
        else
            port = Integer.parseInt(args[0]);

        ExecutorService executor = Executors.newCachedThreadPool();
        try(ServerSocket ss = new ServerSocket(port)) {
            while(true) {
                Socket s = ss.accept();
                executor.execute(() -> clientHandler(s) );
            }
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
