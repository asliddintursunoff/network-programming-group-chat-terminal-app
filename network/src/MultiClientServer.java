import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientServer {
    public static void main(String []args) throws Exception{
        ServerSocket server = new ServerSocket(2000);
        while (true){
            Socket socket = server.accept();
            System.out.println("User: "+socket+" connected");
            ClientController obj = new ClientController(socket);
            obj.start();
        }
    }
}

class ClientController extends Thread{

    Socket socket;

    ClientController(Socket soc){
        socket = soc;
    }
    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            String message;
            do{
                message = in.readLine();
                System.out.println("User: "+socket+" "+message);
                out.println(message);
            }while (message !=null);
            socket.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
