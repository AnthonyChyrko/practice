package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Refl {

	public static void main(String[] args) {

		Person footballer = new Person("Sergio Buskets", 45);
//		Class c = Person.class;		
//		String name = c.getName();//��������� ����� ������
//		System.out.println(name);
//		
////		������������ ������������� ������
//		int mods = c.getModifiers(); 
//		if (Modifier.isPublic(mods)) { 
//		    System.out.println("public"); 
//		} 
//		if (Modifier.isAbstract(mods)) { 
//		    System.out.println("abstract"); 
//		} 
//		if (Modifier.isFinal(mods)) { 
//		    System.out.println("final"); 
//		} 
		System.out.println(footballer.getName());
//		
////		������������, ��������� � ��������� �������� ����� ������.
		Class c1 = footballer.getClass();
		Field[] publicFields = c1.getFields(); // only open fields
		Field[] prFields = c1.getDeclaredFields();//��� ���� ���� private
		for (Field field : prFields) { 		   
		    System.out.println("���: " + field.getName()); 
		    System.out.println("���: " + field.getType().getName()); 
		} 
		
		try {
			Field fieldName = c1.getDeclaredField("name");
			fieldName.setAccessible(true);
			try {
				fieldName.set(footballer, "Sergio Leone");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(footballer.getName());
//		
//		������������ ������������� ������
//		Class classFootballer = footballer.getClass(); 
//		Constructor[] constructors = classFootballer.getConstructors(); 
//		for (Constructor constructor : constructors) { 
//		    Class[] paramTypes = constructor.getParameterTypes(); 
//		    for (Class paramType : paramTypes) { 
//		        System.out.print(paramType.getName() + " "); 
//		    } 
//		    System.out.println(); 
//		} 
//		������������ ���������� � ������, ����� ������.
//		Class c2 = footballer.getClass(); 
//		Method[] methods = c2.getMethods(); 
//		for (Method method : methods) { 
//		    System.out.println("���: " + method.getName()); 
//		    System.out.println("������������ ���: " + method.getReturnType().getName()); 
//		 
//		    Class[] paramTypes = method.getParameterTypes(); 
//		    System.out.print("���� ����������: "); 
//		    for (Class paramType : paramTypes) { 
//		        System.out.print(" " + paramType.getName()); 
//		    } 
//		    System.out.println(); 
//		} 
		Class c3 = footballer.getClass(); 
		Class[] paramTypes = new Class[] {  int.class }; 
		Method method = null;
		try {
			method = c3.getMethod("getCalculateRating", paramTypes);
		} catch (NoSuchMethodException | SecurityException e1) {		
			e1.printStackTrace();
		} 
		Object[] arguments = new Object[] {  new Integer(10) , new Integer(20) }; 
		try {
			for (int i = 0; i < arguments.length; i++) {
				Integer d =  (Integer) method.invoke(footballer, arguments[i]);
				System.out.println(d);
			}
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {			
			e.printStackTrace();
		} 
		
		
		
		Class[] secParamTypes = new Class[] {  int.class }; 
		Method secureMethod = null;
		try {
			method = c3.getDeclaredMethod("secureCalculateRating", secParamTypes);
			method.setAccessible(true);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!to permit changes
		} catch (NoSuchMethodException | SecurityException e1) {		
			e1.printStackTrace();
		} 
		Object[] secArgs = new Object[] {  new Integer(10) , new Integer(20) }; 
		try {
			for (int i = 0; i < secArgs.length; i++) {
				Integer d =  (Integer) method.invoke(footballer, secArgs[i]);
				System.out.println(d);
			}
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {			
			e.printStackTrace();
		} 
		
//		�������� � ������������ �������� ���������� ������
		
		
	}
}
