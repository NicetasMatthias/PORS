import java.io.*;
import java.net.*;

public class Server {
  public final static int PORT = 1099;
  public static void main(String[] args) throws IOException {
      DatagramSocket serverSocket = new DatagramSocket(PORT);
      try {
          byte[] receivingDataBuffer = new byte[1024];
          DatagramPacket inputPacket =
                            new DatagramPacket(receivingDataBuffer,
                            		receivingDataBuffer.length);
          System.out.println("Waiting for a client to connect...");
          FileOutputStream fo = new FileOutputStream("test_r.mp3",true);
          while(true) {
        	  serverSocket.receive(inputPacket);
        	  String receivedData = new String(inputPacket.getData());
        	  if(receivedData.contains("#END#")) {
        		  System.out.print(receivedData);
        		  break;
        	  }
        	  
        	  fo.write(inputPacket.getData());
        	  
        	  for(int j=0; j < 1024; j++) receivingDataBuffer[j] = 0;
          } 

          fo.close();
      } 
      catch (SocketException e){
    	  e.printStackTrace();
      } finally {
    	  System.out.println("**Server Closing ...");
    	  serverSocket.close();
      }   
  }
}