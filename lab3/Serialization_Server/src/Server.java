
/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №3 Десериализация Сервер	
 * Дата выполнения: 20.10.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     Сервер десериализует объект класса Rectangle, полученный
 *     от клиента. Затем вычисляет его площадь с помощью метода 
 *     класса Rectangle, выводит ее в консоль и отправляет клиенту
 */
// ------------------------------------------- // 

import java.io.*;
import java.net.*;

// Класс описывающий прямоугольник
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

public class Server {
	// порт
	static int port = 8080;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// создаем серверный сокет
		ServerSocket s = new ServerSocket(port);

		// ждем соединения
		Socket socket = s.accept();

		// создаем поток для приема данных
		ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());

		// создаем поток для отправки данных
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());

		// принимаем данные
		Rectangle receivedRect = (Rectangle) inObj.readObject();

		// вычисляем площадь прямоугольника
		double square = receivedRect.square();

		// выводим площадь на экран
		System.out.println(square);

		// отправляем площадь клиенту
		out.writeDouble(square);

		// закрываем соединение
		socket.close();
		// закрываем серверный сокет
		s.close();
		System.out.println("shut down...");

	}

}

//--------------------------------------------- //
/*
* Результат работы программы
* 24.0
* shut down...
*/
