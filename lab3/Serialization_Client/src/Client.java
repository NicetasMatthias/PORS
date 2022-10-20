
/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №3 Сериализация Клиент	
 * Дата выполнения: 20.10.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     клиент создает объект класса Rectangle, сериализует его
 *     и отправляет серверу. Затем получает результат вычисления 
 *     площади от сервера и выводит его на экран
 */
// ------------------------------------------- // 

import java.io.*;
import java.net.*;

//Класс описывающий прямоугольник
class Rectangle implements Serializable {
	// Длины двух сторон прямоугольника
	private double a;
	private double b;

	// ID
	public static final long serialVersionUID = 2L;

	// Конструктор класса с двумя параметрами
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	// Метод получения площади прямоугольника
	public double square() {
		return a * b;
	}
}

public class Client {
	// адрес
	static String addr = "localhost";
	// порт
	static int port = 8080;

	public static void main(String[] args)  throws IOException, ClassNotFoundException {
		// создаем сокет
		Socket socket = new Socket(addr, port);
		
		// Создаем класс прямоугольника со сторонами 4 и 6
		var rect = new Rectangle(4, 6);

		// создаем поток для отправки
		ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());

		// создаем поток для приема
		DataInputStream in = new DataInputStream(socket.getInputStream());

		// отправляем объект
		outObj.writeObject(rect);

		// принимаем ответ
		double square = in.readDouble();

		// выводим его в консоль
		System.out.println(square);

		// закрываем сокет
		socket.close();
		System.out.println("shut down...");
	}

}
//--------------------------------------------- //
/*
 * Результат работы программы
 * 24.0
 * shut down...
 */
