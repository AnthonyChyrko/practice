package com.infongen.selenium.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.xerces.parsers.DOMParser;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDataProviderAlternative {

  private static final String PATH_TO_XML = "src/main/resources/data/data_provider_common.xml";

  @DataProvider
  public static Object[][] dataProviderForSearchSpecialSymbolsTest(ITestNGMethod method) {
    String testName = method.getDescription();
    return parseXML(testName);
  }

  private static Object[][] parseXML(String testName) {

    Map<String, String> result = new HashMap<>();
    String key;
    String value;
    DOMParser parser = new DOMParser();
    try {
      parser.parse(PATH_TO_XML);
    } catch (SAXException | IOException e) {
      System.out.println("Can't parse XML!" + e);
    }
    Document document = parser.getDocument();
    document.getDocumentElement().normalize();
    Element root = document.getDocumentElement();
    NodeList dataProviders = root.getElementsByTagName("dataProvider");
    for (int i = 0; i < dataProviders.getLength(); i++) {
      Node dataProvider = dataProviders.item(i);
      Element elDataProvider = (Element) dataProvider;
      if (elDataProvider.getAttribute("name").equalsIgnoreCase(testName)) {
        NodeList testsList = elDataProvider.getElementsByTagName("test");
        int length = testsList.getLength();
        for (int j = 0; j < length; j++) {
          Node test = testsList.item(j);
          Element elTest = (Element) test;
          key = elTest.getElementsByTagName("value").item(0).getTextContent();
          value = elTest.getElementsByTagName("result").item(0).getTextContent();
          result.put(key, value);
        }
      }
    }
    return createResult(result);
  }

  private static Object[][] createResult(Map<String, String> map) {
    Object[][] result = new Object[map.size()][2];
    int i = 0;
    for (Map.Entry entry : map.entrySet()) {
      result[i][0] = entry.getKey();
      result[i][1] = entry.getValue();
      i++;
    }
    return result;
  }
}
