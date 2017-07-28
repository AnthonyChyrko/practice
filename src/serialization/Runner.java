package serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Point implements Serializable {
	private static final long serialVersionUID = -1981164164549372676L;

	private double x;
	private double y;
	private String name;
	Point couple;

	Point(String name) {
		this.name = name;

	}

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	Point(Point source) {
		this.x = source.getX();
		this.y = source.getY();
		this.couple = source.couple;
		this.name = source.name;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", name=" + name + ", couple=" + couple + "]";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class Runner {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		{
			Object[] src = new Object[0];
			Object[] dst = copy(src);
			System.out.println(src.equals(dst));
		}
		{
			Object[] src = new Object[0];
			Object[] dst = src.clone();
			System.out.println(src.equals(dst));
			System.out.println(src==dst);
		}

	}

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T copy(T obj) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		ObjectOutput objectOutput = new ObjectOutputStream(buff);
		objectOutput.writeObject(obj);
		objectOutput.flush();
		objectOutput.close();

		byte[] data = buff.toByteArray();
		ObjectInput objectInput = new ObjectInputStream(new ByteArrayInputStream(data));
		return (T) objectInput.readObject();
	}

}
