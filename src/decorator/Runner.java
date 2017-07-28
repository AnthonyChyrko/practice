package decorator;

interface Product{
	int getPrice();
}

class Milk implements Product{
	private int price;
	
	Milk(int price){
		this.price = price;
	}
	
	@Override
	public int getPrice() {		
		return this.price;
	}	
}

abstract class Decorator implements Product{
	Product product;	
	Decorator(Product product){
		this.product = product;
	}
	
}

class MilkDiscount extends Decorator{

	MilkDiscount(Product product) {
		super(product);		
	}	
	
	@Override
	public int getPrice() {		
		return this.product.getPrice() - 15;
	}	
}

class MilkSuperDiscount extends Decorator{

	MilkSuperDiscount(Product product) {
		super(product);		
	}

	@Override
	public int getPrice() {		
		return this.product.getPrice() - 23;
	}
	
}





public class Runner {

	public static void main(String[] args) {
		Product milk = new Milk(50);
		Decorator milkDiscount = new MilkSuperDiscount(new MilkDiscount(milk));
		System.out.println(milkDiscount.getPrice());

	}

}
