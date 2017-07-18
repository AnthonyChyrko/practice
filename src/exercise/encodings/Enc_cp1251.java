package exercise.encodings;

public class Enc_cp1251 {

	public static void main(String[] args) {		
		String file1 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\cp1251\\file - cyr -1251.txt";
		String file2 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\cp1251\\file - en - 1251.txt";
		String charset = "windows-1251";
			
		System.out.println(Encodings.readFileWithCharset(file1, charset));
		System.out.println(Encodings.readFileWithCharset(file2, charset));			
	}
}
