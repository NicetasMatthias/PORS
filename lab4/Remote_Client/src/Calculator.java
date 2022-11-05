import java.rmi.*;

public interface Calculator extends Remote {
	float sum(float a, float b) throws RemoteException;

	float sub(float a, float b) throws RemoteException;

	float mul(float a, float b) throws RemoteException;

	float div(float a, float b) throws RemoteException;
}
