package javaIO;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Runner {

	public static void main(String[] args) throws IOException {
		byte[] data = { 'H', 'e', 'l', 'l', 'o' };
		InputStream in = new ByteArrayInputStream(data);
		OutputStream out = new FileOutputStream(".\\src\\javaIO\\__HELLO.txt");
		copy(in, out);

	}

	private static void copy(InputStream in, OutputStream out) throws IOException {
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}

		in.close();
		out.flush();
		out.close();
	}

}
