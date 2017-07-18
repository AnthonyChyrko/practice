package interfaces;

public class TwoInterfaceHaveSimilarMethod {

	public static void main(String[] args) {		
//		TestMachine testMachine = new TestMachine();
//		Display interfaceA = testMachine;
//		System.out.println(interfaceA.commonString);
//		System.out.println(((Display)testMachine).commonString);
//		System.out.println(((File)testMachine).commonString);
//		System.out.println(((Display)testMachine).print());
//		System.out.println(((File)testMachine).print());
		
		//----------------------------------------------------------------------
		InheritAndExt inheritAndExt = new InheritAndExt();/**Таким образом у нас есть возможность создать экземпляр
		класса в котором не определен метод реализуемого интерфейса!Компилятор считает, что реализовывать метод не надо,
		 так как в родительском классе уже есть метод с такой же сигнатурой.
		*/
		
		int a = 300;
		Integer b = 301;
		System.out.println();
	}
}
