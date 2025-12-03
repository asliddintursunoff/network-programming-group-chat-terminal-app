import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args){
        try{
            System.out.println("Server started");
            ServerSocket socket = new ServerSocket(2000);

            Socket soc = socket.accept();

            System.out.println("Client Connected: "+soc);

            BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter writer = new PrintWriter(soc.getOutputStream(),true);

            String message;
            do{
                message = reader.readLine();
                System.out.println("client send: "+message);
                writer.println(message);
            }while (!message.equals("end"));



            socket.close();
            soc.close();
        }
        catch (Exception e){
            System.out.println("Error occured: "+e);
        }

    }
}
