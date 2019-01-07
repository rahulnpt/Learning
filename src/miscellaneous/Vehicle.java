package miscellaneous;

public class Vehicle {
	String name;
	int id;
	
	public Vehicle(String name,int id) {
		this.name = name;
		this.id = id;
	}
	public static void main(String[] args) {
		Vehicle vehicle =new Vehicle("van",1);
		System.out.println(vehicle.id+" "+vehicle.name);
		
		Vehicle vehicle2 = vehicle;
		
		vehicle.id = 5;
		
		System.out.println(vehicle.id+" "+vehicle.name);
		System.out.println(vehicle2.id+" "+vehicle2.name);
		
	}
}
