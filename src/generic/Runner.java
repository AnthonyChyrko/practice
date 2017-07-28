package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}

class Company implements Iterable<Employee> {
	private Employee[] employees = new Employee[0];

	public void setEmployee(Employee[] employees) {
		this.employees = employees;
	}

	@Override
	public Iterator<Employee> iterator() {
		return new ArrayIterator(employees);
	}
}

class ArrayIterator<T> implements Iterator<T> {
	private final T[] data;
	private int index = 0;

	
	public ArrayIterator(T[] data) {		
		this.data = data;
	}

	@Override
	public boolean hasNext() {		
		return index < data.length;
	}

	@Override
	public T next() {
		return data[index++];
	}

}

// class MyGeneric<T> {
// private T data;
//
// public T getData() {
// return data;
// }
//
// @Override
// public String toString() {
// return "MyGeneric [data=" + data + "]";
// }
//
// @Override
// public int hashCode() {
// final int prime = 31;
// int result = 1;
// result = prime * result + ((data == null) ? 0 : data.hashCode());
// return result;
// }
//
// @Override
// public boolean equals(Object obj) {
// if (this == obj)
// return true;
// if (obj == null)
// return false;
// if (getClass() != obj.getClass())
// return false;
// MyGeneric other = (MyGeneric) obj;
// if (data == null) {
// if (other.data != null)
// return false;
// } else if (!data.equals(other.data))
// return false;
// return true;
// }
//
// public void setData(T data) {
// this.data = data;
// }
//
// }

public class Runner {

	public static void main(String[] args) {
		Company company = new Company();
		Employee[] employees = { new Employee("Mike"), new Employee("Sarah") };
		company.setEmployee(employees);
		for (Employee empl : company) {
			System.out.println(empl.toString());
		}

		//
		// MyGeneric<String> genStr = new MyGeneric<>();
		// MyGeneric<int[]> genIntArr = new MyGeneric();
		// MyGeneric<Integer> genInt = new MyGeneric();
		// genInt.setData(15);
		// genStr.setData("Hello!");
		// genIntArr.setData(new int[] { 12, 23, 34 });
		//
		// List<MyGeneric> listData = new ArrayList<>();
		// listData.add(genStr);
		// listData.add(genIntArr);
		// listData.add(genInt);
		//
		// for (MyGeneric myGeneric : listData) {
		//
		// System.out.println(myGeneric);
		// }

	}

}
