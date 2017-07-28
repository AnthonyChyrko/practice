package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class FoodJAXBUnMarshaller {

	public static void main(String[] args) throws JAXBException {
		
		File file = new File(".\\src\\jaxb\\xmlFile.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Food.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Food food = (Food) jaxbUnmarshaller.unmarshal(file);
		System.out.println(food.getName());
		System.out.println(food.getCalories());

	}

}
