package exercise.encodings;

public class Enc_utf8 {

	public static void main(String[] args) {
		String file1 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\utf 8 - 16 - 32 -BOM\\file - cyr - utf8-BOM.txt";
		String file2 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\utf 8 - 16 - 32 -BOM\\file - en - utf8-BOM.txt";
		String charset = "Utf-8";		
		
		System.out.println(Encodings.readFileWithCharset(file1, charset));
		System.out.println(Encodings.readFileWithCharset(file2, charset));

	}

}
