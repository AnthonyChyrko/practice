package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Anton_Chyrko on 8/30/2017.
 */
public class RestAssuredDemoTest {
    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/";
    }

    @Test
    public void checkStatusCode(){
        Response rp = given().get("/posts").andReturn();

        int actualStatusCode = rp.getStatusCode();
        Assert.assertEquals(actualStatusCode,200);
    }

}
