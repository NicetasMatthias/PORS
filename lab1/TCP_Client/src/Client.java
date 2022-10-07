
/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №1 TCP Клиент	
 * Дата выполнения: 07.10.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     TCP клиент, устанавливает соединение с сервером 
 *     и отправляет 15 одинаковых сообщение
 */
// ------------------------------------------- // 

import java.io.*;
import java.net.*;

public class Client {
	// адрес
	static String addr = "localhost";
	// порт
	static int port = 8080;

	public static void main(String[] args) throws IOException {
		// создаем сокет
		Socket socket = new Socket(addr, port);
		// выводим его параметры
		System.out.println("socket = " + socket);
		// создаем поток для отправки
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		// создаем поток для приема
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		for (int i = 15000; i < 15015; i++) {
			// отправляем сообщения
			out.println(i + " another message #");
			// принимаем ответ
			String str = in.readLine();
			// выводим его в консоль
			System.out.println(str);

		}
		// отправляем команду завершения
		out.println("END");
		// закрываем сокет
		socket.close();
		System.out.println("shut down...");
	}

}
//--------------------------------------------- //
/*
 * Результат работы программы socket =
 * Socket[addr=localhost/127.0.0.1,port=8080,localport=50331] # 15000 received #
 * 15001 received # 15002 received # 15003 received # 15004 received # 15005
 * received # 15006 received # 15007 received # 15008 received # 15009 received
 * # 15010 received # 15011 received # 15012 received # 15013 received # 15014
 * received shut down...
 */
