
/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №1 TCP Сервер	
 * Дата выполнения: 07.10.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     TCP сервер, устанавливает соединение с клиентом,
 *     принимает сообщения и выводих их на экран
 */
// ------------------------------------------- // 

import java.io.*;
import java.net.*;

public class Server {
	// порт
	static int port = 8080;

	public static void main(String[] args) throws IOException{
		// создаем серверный сокет
		ServerSocket s = new ServerSocket( port);
		// выводим его параметры
		System.out.println("Started "+s);
		// ждем соединения
		Socket socket = s.accept();
		// выводим параметры соединения
		System.out.println("Connection accepted: "+socket);
		// создаем поток для приема данных
		BufferedReader in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		// создаем поток для отправки данных
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream())),true);
		
		while (true) {
			// принимаем данные
			String str = in.readLine();
			// если это команда завершения заканчиваем
			if (str.equals("END")) break;
			
			String sa[] = str.split("\\s");
			String message = "";
			for (int i = 1; i < sa.length-1; i++) {
				message += sa[i] + " ";
			}
			// выводим сообщение на экран
			System.out.println(message);
			// отправляем подтверждение получения
			out.println("# " + sa[0] + " received");
		}
		// закрываем соединение
		socket.close();
		// закрываем серверный сокет
		s.close();
		System.out.println("shut down...");
	}

}

/*
 * Started ServerSocket[addr=0.0.0.0/0.0.0.0,localport=8080] Connection
 * accepted: Socket[addr=/127.0.0.1,port=50331,localport=8080] another message
 * another message another message another message another message another
 * message another message another message another message another message
 * another message another message another message another message another
 * message shut down...
 */

