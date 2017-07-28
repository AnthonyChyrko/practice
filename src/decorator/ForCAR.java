package decorator;

interface Vehicle {
	int getPrice();
}

class Car implements Vehicle {
	private int price;
	Car(int price){
		this.price = price;
	}
	@Override
	public int getPrice() {		
		return price;
	}
}

abstract class DecorateVehicle implements Vehicle{
	Vehicle vehicle;
	public DecorateVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}

class VehicleWithLeather extends DecorateVehicle{

	public VehicleWithLeather(Vehicle vehicle) {
		super(vehicle);		
	}

	@Override
	public int getPrice() {		
		return this.vehicle.getPrice() + 15;
	}
	
}

class VehicleWithTitaniumDiscs extends DecorateVehicle{

	public VehicleWithTitaniumDiscs(Vehicle vehicle) {
		super(vehicle);		
	}

	@Override
	public int getPrice() {		
		return this.vehicle.getPrice() + 17;
	}
	
}

class VehicleWithBulletProofGlass extends DecorateVehicle{

	public VehicleWithBulletProofGlass(Vehicle vehicle) {
		super(vehicle);		
	}

	@Override
	public int getPrice() {		
		return this.vehicle.getPrice() + 170;
	}
	
}


public class ForCAR {

	public static void main(String[] args) {
		Vehicle car1 = new Car(100);
		Vehicle car2 = new Car(100);
		DecorateVehicle car1AfterDecor = new VehicleWithLeather(new VehicleWithTitaniumDiscs(car1));
		DecorateVehicle car2AfterDecor = new VehicleWithBulletProofGlass(new VehicleWithTitaniumDiscs(car2));
		System.out.println(car1AfterDecor.getPrice());
		System.out.println(car2AfterDecor.getPrice());
	}

}
