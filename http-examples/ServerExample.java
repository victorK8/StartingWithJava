import java.io.*;
import java.net.*;

public class ServerExample{

  public static void main(String[] Args){
    int PORT = 8888;

    try{
      // Create server socket
      ServerSocket SSocket = new ServerSocket(PORT);

      // Accept external connections
      Socket s = SSocket.accept();

      // Get data
      DataInputStream dis=new DataInputStream(s.getInputStream());

      // Convert to UTF
      String msg = (String)dis.readUTF();

      // Log message
      System.out.println("message= " + msg);

      // Close Server socket
      SSocket.close();

    }catch(Exception e){
      e.printStackTrace();
    }

  }

}
