import java.io.*;
import java.net.*;

public class Client {
	public static final int PORT = 1099;

	public static void main(String[] args) throws Exception {
		String e = "#END#";

		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] dataToSend = new byte[1024];

		FileInputStream fr = new FileInputStream("test_s.mp3");
		while (fr.read(dataToSend, 0, 1024) != -1) {
			DatagramPacket pac = new DatagramPacket(dataToSend, dataToSend.length, IPAddress, PORT);
			clientSocket.send(pac);
			Thread.sleep(1);
		}
		DatagramPacket pac = new DatagramPacket(e.getBytes(), e.getBytes().length, IPAddress, PORT);
		clientSocket.send(pac);
		fr.close();

		System.out.println("Closing ...");
		clientSocket.close();
	}
}
