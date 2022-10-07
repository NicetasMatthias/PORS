/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №2 UDP Сервер	
 * Дата выполнения: 07.10.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     UDP сервер, принимает датаграммы от клиента и записывает
 *     их в файл, пока не получит пакет, содержащий "#END#"
 */
// ------------------------------------------- // 

import java.io.*;
import java.net.*;

public class Server {
	// ПОРТ
	public final static int PORT = 1099;

	public static void main(String[] args) throws IOException {
		// создаем сокет
		DatagramSocket serverSocket = new DatagramSocket(PORT);
		try {
			// создаем буфер для приема пакета
			byte[] receivingDataBuffer = new byte[1024];
			// создаем датаграмму
			DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
			System.out.println("Waiting for a client to connect...");
			// открываем файл для записи
			FileOutputStream fo = new FileOutputStream("test_r.mp3", true);
			while (true) {
				// получаем датаграмму от клиента
				serverSocket.receive(inputPacket);
				// преобразуем в строку чтобы записать в файл
				String receivedData = new String(inputPacket.getData());
				// если встретили #END# завершаем работу
				if (receivedData.contains("#END#")) {
					System.out.print("File recieved");
					break;
				}
				// записываем датаграмму в файл
				fo.write(inputPacket.getData());
				// обнуляем буфер
				for (int j = 0; j < 1024; j++)
					receivingDataBuffer[j] = 0;
			}
			// закрываем файл
			fo.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Server Closing ...");
			// закрываем сокет
			serverSocket.close();
		}
	}
}

//------------------------------------------- // 
/*
 * Waiting for a client to connect... File recieved Server Closing ...
 */