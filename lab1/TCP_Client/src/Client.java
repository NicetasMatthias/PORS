import java.io.*;
import java.net.*;


public class Client {
	static String addr = "localhost";
	static int port = 8080;

	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(addr, port);
		System.out.println("socket = "+socket);
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream())),true);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		for (int i = 15000; i < 15015; i++) {
			out.println(i + " another message #");
			String str = in.readLine();
			System.out.println(str);
		}
		
		out.println("END");
		System.out.println("shut down...");		
		socket.close();
	}

}

