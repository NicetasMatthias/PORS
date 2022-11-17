import java.io.Serializable;

public class Car implements Serializable {

// уникальный идентификатор версии сериализованного класса
	private static final long serialVersionUID = 1L;

	private String owner;
	private String number;

	public Car(String owner, String number) 
	{
		super();
		this.owner = owner;
		this.number = number;
	}

	public String getOwner() 
	{
		return owner;
	}

	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	public String getNumber() 
	{
		return number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

// Сравнение Автомобилей (Car) ведется по номерам (number)
	@Override
	public boolean equals(Object car) 
	{
		return this.getNumber().equals(((Car) car).getNumber());
	}
}