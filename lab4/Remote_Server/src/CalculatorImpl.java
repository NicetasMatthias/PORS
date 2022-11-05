import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

	protected CalculatorImpl() throws RemoteException {
		super();
	}

	public float sum(float a, float b) throws RemoteException {
		return a + b;
	}

	public float sub(float a, float b) throws RemoteException {
		return a - b;
	}

	public float mul(float a, float b) throws RemoteException {
		return a * b;
	}

	public float div(float a, float b) throws RemoteException {
		return a / b;
	}

}
