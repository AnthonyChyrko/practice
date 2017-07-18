package forInstanceOf;

public class Run {

	public static void main(String[] args) {
//		doLogic(new BaseCourse());
//		doLogic(new OptionalCourse());
//		doLogic(new FreeCourse());
		
		doLogic(new Course());

	}
	
	public static void doLogic(Course c) {
		if(c instanceof Course){
			System.out.println("Course instanceOf Course");
		}else{
			System.out.println("Course NOTinstanceOf Course");
		}
		if (c instanceof BaseCourse) {
		System.out.println("BaseCourse");
		} else if (c instanceof OptionalCourse) {
		System.out.println("OptionalCourse");
		} else {
		System.out.println("Что-то другое.");
		}
	}

}
