/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №2 UDP Клиент	
 * Дата выполнения: 07.10.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     UDP клиент, считывает файл и отправляет его серверу
 *     датаграммами. Когда файл кончился отправляет "#END#"
 */
// ------------------------------------------- // 

import java.io.*;
import java.net.*;

public class Client {
	//ПОРТ
	public static final int PORT = 1099;

	public static void main(String[] args) throws Exception {
		String e = "#END#";
		// создаем сокет
		DatagramSocket clientSocket = new DatagramSocket();
		// получаем IP
		InetAddress IPAddress = InetAddress.getByName("localhost");
		// создаем буфер для отправки
		byte[] dataToSend = new byte[1024];
		// открываем файл для чтения
		FileInputStream fr = new FileInputStream("test_s.mp3");
		while (fr.read(dataToSend, 0, 1024) != -1) {
			// создаем датаграмму
			DatagramPacket pac = new DatagramPacket(dataToSend, dataToSend.length, IPAddress, PORT);
			// отправляем датаграмму
			clientSocket.send(pac);
			Thread.sleep(1);
		}
		// отправляем датаграмму с командой завершения
		DatagramPacket pac = new DatagramPacket(e.getBytes(), e.getBytes().length, IPAddress, PORT);
		clientSocket.send(pac);
		// закрываем файл
		fr.close();
		// закрываем сокет
		clientSocket.close();
		System.out.println("Closing ...");
	}
}

//------------------------------------------- // 
/*
 * Closing ...
 */