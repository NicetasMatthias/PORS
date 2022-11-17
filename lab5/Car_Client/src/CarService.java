import java.rmi.*;

public interface CarService extends Remote {
	public String addNewCar(Car car) throws RemoteException;

	public String getAllCars() throws RemoteException;

	public String changeOwner(String number, String newOwner) throws RemoteException;

	public String getOwner(String number) throws RemoteException;

}
