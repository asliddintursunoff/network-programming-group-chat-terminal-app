import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.BufferOverflowException;
import java.util.HashSet;
import java.util.Set;

public class MultClientContinious {
    private static Set<PrintWriter> clientconsoles = new HashSet<>();
    public static  void main(String []args) throws Exception{

        ServerSocket server = new ServerSocket(3000);

        while(true){
            Socket socket = server.accept();
            System.out.println("Server connected: "+socket);

            ClientSideServer obj = new ClientSideServer(socket);
            obj.start();

        }
    }

    synchronized public static void adding_writer(PrintWriter obj){
        clientconsoles.add(obj);
    }
    synchronized public static void broadcast(String message,PrintWriter message_owner,String username){
            for(PrintWriter obj:clientconsoles){
                if(message_owner == obj){
                    continue;
                }
                obj.println(username+":  "+message);
            }
    }

    synchronized static void pop_out_client(PrintWriter cl){
        clientconsoles.remove(cl);
    }
}

class ClientSideServer extends Thread{
    Socket client;
    String username;

    public ClientSideServer(Socket cl){
        client = cl;
    }

    @Override
    public void run(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(),true);

            String line;
            line = reader.readLine();
            username = line;
            MultClientContinious.adding_writer(writer);

            do {
                line = reader.readLine();
                if (line != null) {
                    MultClientContinious.broadcast(line,writer,username);
                }
            } while (line != null && !line.equals("fuck"));

            MultClientContinious.pop_out_client(writer);

        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try { client.close(); } catch(IOException e) {}
        }


    }
}
