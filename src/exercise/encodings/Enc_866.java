package exercise.encodings;

public class Enc_866 {

	public static void main(String[] args) {
	String file1 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\866\\file - cyr - 866.txt";
	String file2 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\866\\file - en - 866.txt";
	String charset = "866";
	
	System.out.println(Encodings.readFileWithCharset(file1, charset));
	System.out.println(Encodings.readFileWithCharset(file2, charset));
		
	}
}
