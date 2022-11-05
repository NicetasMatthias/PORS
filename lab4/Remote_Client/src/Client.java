
/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №4 Удаленный калькулятор Клиент	
 * Дата выполнения: 05.11.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     Клиент считывает ввод пользователя из консоли, 
 *     разбирает строку и вызывает удаленный метод на сервере. 
 *     Результат выполнения выводится на экран.
 */
// ------------------------------------------- // 

import java.net.*;
import java.rmi.*;
import java.util.*;

public class Client {
	// порт
	static int port = 8080;
	// символьное имя объекта
	public static final String OBJECT_NAME = "CalculatorImpl";
	// адрес объекта с используемым методом
	public static final String ADDRESS = "rmi://127.0.0.1:" + port + "/" + OBJECT_NAME;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// Получаем ссылку на заглушку для удаленного объекта, связанного с указанным
		// адресом
		Calculator calc = (Calculator) Naming.lookup(ADDRESS);

		// Создается объект сканера
		Scanner in = new Scanner(System.in);

		// Цикл обработки
		while (true) {
			// Вывод строки - приглашения к вводу
			System.out.println("\nPrint:\n - arithmetic expression: to calculate\n - 'exit': to close program");

			// Считывается ввод пользователя
			String str = in.nextLine();

			// Если это команда завершения, выходим из цикла обработки
			if (Objects.equals(str, "exit")) {
				break;
			}

			// Разбиваем строку с разделителем - пробелом
			String[] strList = str.split(" ");
			// Если размер получившегося массива не равен 3, значит ввод некорректен.
			// Выводим сообщение об ошибке и переходим к следующему циклу обработки
			if (strList.length != 3) {
				System.out.println("Invalid String");
				continue;
			}

			// Разбираем строку на оператор и два операнда
			float a = Float.parseFloat(strList[0]);
			char operator = strList[1].charAt(0);
			float b = Float.parseFloat(strList[2]);

			// Переменная для записи результата
			float result;

			// Выбор метода в зависимости от оператора и его вызов
			switch (operator) {
			case '+':
				result = calc.sum(a, b);
				break;
			case '-':
				result = calc.sub(a, b);
				break;
			case '*':
				result = calc.mul(a, b);
				break;
			case '/':
				result = calc.div(a, b);
				break;
			default:
				// В случае некорректного оператора выводим сообщение об ошибке и переходим к
				// следующему циклу обработки
				System.out.println("Invalid operator");
				continue;
			}

			// Выводим результат вычисления
			System.out.println(str + " = " + result);
		}

		in.close();
		System.out.println("Close application");
	}

}
//--------------------------------------------- //
/*
 * Print: - arithmetic expression: to calculate - 'exit': to close program 
 * 1
 * Invalid String
 * 
 * Print: - arithmetic expression: to calculate - 'exit': to close program 
 * 1 = 1
 * Invalid operator
 * 
 * Print: - arithmetic expression: to calculate - 'exit': to close program 
 * 1 + 1
 * 1 + 1 = 2.0
 * 
 * Print: - arithmetic expression: to calculate - 'exit': to close program 
 * exit
 * Close application
 */
