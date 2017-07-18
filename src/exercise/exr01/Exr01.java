package exercise.exr01;

import java.awt.Rectangle;
import java.lang.ref.SoftReference;

public class Exr01 {

	public static void main(String[] args) {
//		SoftReference<MyObject> myObject = new SoftReference<MyObject>(new MyObject());
//		System.out.println(myObject.get());
		MyObject myObject1 = new MyObject(4,5,6);
//		MyObject myObject2 = new MyObject();
//		System.out.println(myObject1.toString());
//		myObject2.setA(5);
//		System.out.println(myObject2.toString());
//		myObject2 = myObject1;
//		System.out.println(myObject2.toString());
		System.out.println(myObject1.toString());
//		System.out.println(myObject2.getA());//		
//		char[] data = {'\u0043', '\u0062', 'V', 'A'};
//		String str = new String(data,2,1);
//		System.out.println(str);
		String str = "Hello!";
		System.out.println(str.length());
		System.out.println(Double.MIN_VALUE);
		
	}

}
