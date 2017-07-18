package exercise.exr01;

public class ForCats {	
	
	public static void main(String[] args) {
		Cat A = new Cat(3);
		Cat B = A;
		changeCat(B);
		System.out.println(A.getAge());
		System.out.println(B.getAge());
	}
	
	static void changeCat(Cat X){
		X = new Cat(10);
		X.setAge(18);
		Integer i1 = 10;
		int y1 = 10;
		int y2 = 10;
		Integer i2 = 10;
		System.out.println(i1 == i2);
		System.out.println(y1 == y2);
		i1 = 128;
		i2 = 128;
		y1 = 128;
		y2 = 128;
		System.out.println(i1 == i2);
		System.out.println(y1 == y2);

	}
	

}
