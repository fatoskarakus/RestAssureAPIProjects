package RestAssureAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_GET_JSON_RESPONSE {

    @Test
    public void getJsonBodySucces() {
        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/Book?ISBN=9781449325862"); //working with parameters
        String responseBody = response.getBody().asString();
        response.prettyPrint();

        Assert.assertEquals(responseBody.contains("9781449325862"), true);

    }

    @Test
    public void getJsonBodyFailed() {
        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        //Response object
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();

        System.out.println("Resrponse Body  :"+responseBody);
        Assert.assertEquals(responseBody.contains("9781449325887"), false);

    }
}
