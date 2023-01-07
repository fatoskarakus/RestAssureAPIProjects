package RestAssureAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_GET_REG_VALIDATE_EACH_NODE {

    @Test
    public void validateEveryNodeJsonSucces() {

        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        //Response object
        Response response = httpRequest.request(Method.GET, "/Book?ISBN=9781449325862"); //working with parameters

        JsonPath jsonPather = response.jsonPath();
        //jsonPather.get("isbn");   //we are getting the special "isbn" node
        System.out.println("isbn Node:      " + jsonPather.get("isbn"));
        System.out.println("title Node:     " + jsonPather.get("title"));
        System.out.println("author Node:    " + jsonPather.get("author"));
        System.out.println("publisher Node: " + jsonPather.get("publisher"));
        System.out.println("pages Node:     " + jsonPather.get("pages"));
        Assert.assertEquals(jsonPather.get("isbn"),"9781449325862");
    }


    @Test
    public void validateEveryNodeJsonFailed() {

        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        //Response object
        Response response = httpRequest.request(Method.GET, "/Book?ISBN=9781449325862"); //working with parameters

        JsonPath jsonPather = response.jsonPath();
        //jsonPather.get("isbn");   //we are getting the special "isbn" node
        System.out.println("isbn Node:      " + jsonPather.get("isbn"));
        System.out.println("title Node:     " + jsonPather.get("title"));
        System.out.println("author Node:    " + jsonPather.get("author"));
        System.out.println("publisher Node: " + jsonPather.get("publisher"));
        System.out.println("pages Node:     " + jsonPather.get("pages"));
        Assert.assertFalse(false,"9781449385862");

    }
}
