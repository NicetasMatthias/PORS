
/*
 * Выполнил: Матвеев Никита группа №8362
 * Задание: №4 Удаленный калькулятор Сервер	
 * Дата выполнения: 05.11.2022
 * Версия: 0.1
 */

// ------------------------------------------- // 
/*
 * Общее описание программы
 *     Сервер строит реестр удаленных объектов, привязанный к 
 *     определенному порту, создает сам удаленный объект и 
 *     заносит имя удаленного объекта и имя ссылки на него в реестр
 */
// ------------------------------------------- // 

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	// порт
	static int port = 8080;

	// символьное имя объекта
	public static final String OBJECT_NAME = "CalculatorImpl";

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {

		// Создается реестр с портом для связи
		final Registry registry = LocateRegistry.createRegistry(port);

		// Предоставляется удаленный объект и запускается процесс обработки удаленного
		// вызова
		Calculator calc = new CalculatorImpl();

		// Имя объекта и ссылки заносятся в реестр и связываются
		registry.bind(OBJECT_NAME, calc);

		System.out.println("Server started");

	}

}

//--------------------------------------------- //
/*
 * Server started
 */
