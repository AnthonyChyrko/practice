package reflection;

public class Person {	
	private int age;	
	private String name;
	public String Surname;
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() { return name; }
	
	private int getAge() { return age; }
	
	public int getCalculateRating(int age){
		
		int result = age*2+secureCalculateRating(age);
		return result;		
	}
	
	private int secureCalculateRating(int age){
		int result = age*3;
		return result;		
	}

}
