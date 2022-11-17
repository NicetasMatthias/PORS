import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CarServiceImpl extends UnicastRemoteObject implements CarService {

	ArrayList<Car> carList = new ArrayList<Car>();

	protected CarServiceImpl() throws RemoteException {
		super();
	}

	public String addNewCar(Car car) throws RemoteException {
		carList.add(car);
		return "Add new car:\nnumber - " + car.getNumber() + "\nowner - " + car.getOwner();
	}

	public String getAllCars() throws RemoteException {
		String res = "Number\tOwner\n";
		for (Car car : carList) {
			res = res + car.getNumber() + "\t" + car.getOwner() + "\n";
		}
		return res;
	}

	public String changeOwner(String number, String newOwner) throws RemoteException {
		for (Car car : carList) {
			if (Objects.equals(car.getNumber(), number)) {
				car.setOwner(newOwner);
				return "done";
			}
		}
		return ("There is no cars with number " + number);

	}

	public String getOwner(String number) throws RemoteException {
		for (Car car : carList) {
			if (Objects.equals(car.getNumber(), number)) {
				return "Owner of car number " + number + ": " + car.getOwner();
			}
		}
		return "There is no cars with number " + number;
	}

}
