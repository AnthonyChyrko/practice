package exercise.encodings;

public class Enc_utf16 {

	public static void main(String[] args) {
		String file1 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\utf 8 - 16 - 32 -BOM\\file - cyr - utf16be-BOM.txt";
		String file2 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\utf 8 - 16 - 32 -BOM\\file - cyr - utf16le-BOM.txt";
		String file3 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\utf 8 - 16 - 32 -BOM\\file - en - utf16be-BOM.txt";
		String file4 = "c:\\Users\\Anton_Chyrko\\Downloads\\file encoding\\utf 8 - 16 - 32 -BOM\\file - en - utf16le-BOM.txt";
		String charsetBE = "Utf-16be";
		String charsetLE = "Utf-16le";
		
		System.out.println(Encodings.readFileWithCharset(file1, charsetBE));
		System.out.println(Encodings.readFileWithCharset(file2, charsetLE));
		System.out.println(Encodings.readFileWithCharset(file3, charsetBE));
		System.out.println(Encodings.readFileWithCharset(file4, charsetLE));

	}
}
