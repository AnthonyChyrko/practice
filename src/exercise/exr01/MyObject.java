package exercise.exr01;

import java.io.IOException;

class MyObject {
	int a,b,c;
	MyObject(){
		a = 1;
		b = 2;
		c = 3;
	}
	MyObject(int a, int b, int c){
		try{
			this.a = a;
			this.b = b;
			this.c = c;
		}catch(NumberFormatException ioe){
			System.out.println("Exception!!!");
		}
	}
	
	MyObject getMyObject(){
		return this;		
	}
	
	int getA(){
		return this.a;
	}
	int getB(){
		return this.b;
	}
	int getC(){
		return this.c;
	}
	
	void setA(int A){
		this.a = A;
	}
	void setB(int B){
		this.b = B;
	}
	void setC(int C){
		this.c = C;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyObject other = (MyObject) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyObject [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}
