import java.io.*;
import java.net.*;


public class Server {
	static int port = 8080;
	
	public static void main(String[] args) throws IOException{

		ServerSocket s = new ServerSocket( port);
		System.out.println("Started "+s);
		Socket socket = s.accept();
		
		System.out.println("Connection accepted: "+socket);
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));

		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream())),true);
		
		while (true) {
			String str = in.readLine();
			if (str.equals("END")) break;

			String sa[] = str.split("\\s");
			String message = "";
			for (int i = 1; i < sa.length-1; i++) {
				message += sa[i] + " ";
			}
			System.out.println(message);
			out.println("# " + sa[0] + " received");
		}
		socket.close();
		s.close();
	}

}