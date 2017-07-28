package jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class FoodJAXBMarshaller {

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		JAXBContext context = JAXBContext.newInstance(Food.class);
		Marshaller m = context.createMarshaller();
		Food food = new Food();
		food.setId(123);
		food.setName("nnn");
		food.setDescription("ddd");
		food.setCalories(234);
		food.setPrice("333");
		File file = new File(".\\src\\jaxb\\xmlFile.xml");
		m.marshal(food, new FileOutputStream(file));
		m.marshal(food, System.out);
//		System.out.println("XML-פאיכ סמחהאם");
		
	}

}
