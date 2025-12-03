import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class EchoClient {
    public static void main(String[]args) throws Exception{
        System.out.println("Client Started");
        Socket ss = new Socket("0.tcp.in.ngrok.io",11459);

        BufferedReader reader = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        PrintWriter writer =  new PrintWriter(ss.getOutputStream(),true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.print("Enter your username: ");
        line = keyboard.readLine();
        writer.println(line);
        System.out.println("Hello "+line+". Welcome to group chat! ");
        ReadingThread thread = new ReadingThread(reader);
        thread.start();


        System.out.print(">> ");
        do {

            line = keyboard.readLine();
            writer.println(line);
            System.out.print(">> ");

        }while (line!=null);

        ss.close();
    }
}
class ReadingThread extends Thread{
    BufferedReader reader;

    ReadingThread(BufferedReader obj){
        reader = obj;
    }
    @Override
    public void run(){
        String message;
        while(true){
            try {
                message = reader.readLine();
                System.out.println(message);
                System.out.print(">> ");

            }
            catch (IOException e){}
        }
    }

}