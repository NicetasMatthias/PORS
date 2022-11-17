
/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №5 Удаленный Клиент	
 * Дата выполнения: 17.11.2022
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
	public static final String OBJECT_NAME = "CarServiceImpl";
	// адрес объекта с используемым методом
	public static final String ADDRESS = "rmi://127.0.0.1:" + port + "/" + OBJECT_NAME;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// Получаем ссылку на заглушку для удаленного объекта, связанного с указанным
		// адресом
		CarService carServ = (CarService) Naming.lookup(ADDRESS);

		// Создается объект сканера
		Scanner in = new Scanner(System.in);

		// Цикл обработки
		while (true) {
			// Вывод строки - приглашения к вводу
			System.out.println(
					"\nPrint:\n - add: to add car\n - all: to print all cars\n - owner: to get car owner\n - change_owner: to change car owner\n - 'exit': to close program");

			// Считывается ввод пользователя
			String str = in.nextLine();

			// Если это команда завершения, выходим из цикла обработки
			if (Objects.equals(str, "exit")) {
				break;
			}

			if (Objects.equals(str, "add")) {
				System.out.print("Owner: ");
				String owner = in.nextLine();
				System.out.print("Number: ");
				String number = in.nextLine();
				System.out.println(carServ.addNewCar(new Car(owner, number)));
				continue;
			}

			if (Objects.equals(str, "all")) {
				System.out.println(carServ.getAllCars());
				continue;
			}

			if (Objects.equals(str, "owner")) {
				System.out.print("Print number of car: ");
				String number = in.nextLine();
				System.out.println(carServ.getOwner(number));
				continue;
			}

			if (Objects.equals(str, "change_owner")) {
				System.out.print("Print number of car: ");
				String number = in.nextLine();
				System.out.println("New owner for car number " + number + ": ");
				Scanner input = new Scanner(System.in);
				String newOwner = input.nextLine();
				System.out.println(carServ.changeOwner(number, newOwner));
				continue;
			}

		}

		in.close();
		System.out.println("Close application");
	}

}
//--------------------------------------------- //
/*
Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
add
Owner: me
Number: 123
Add new car:
number - 123
owner - me

Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
add
Owner: not_me
Number: 321
Add new car:
number - 321
owner - not_me

Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
all
Number	Owner
123	me
321	not_me


Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
owner 

Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
owner
Print number of car: 123
Owner of car number 123: me

Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
change_owner
Print number of car: 123
New owner for car number 123: 
not_me_too
done

Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
all
Number	Owner
123	not_me_too
321	not_me


Print:
 - add: to add car
 - all: to print all cars
 - owner: to get car owner
 - change_owner: to change car owner
 - 'exit': to close program
exit
Close application
 */
