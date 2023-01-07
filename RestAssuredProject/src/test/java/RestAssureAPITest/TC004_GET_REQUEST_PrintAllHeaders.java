package RestAssureAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_GET_REQUEST_PrintAllHeaders {

    @Test
    public void getAllBookApiHedears() {

        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println("responseBody=>" + responseBody);

        //Validation Header
        String contentType = response.header("Content-Type");
        System.out.println("contentType=>" + contentType);
        Assert.assertEquals(contentType, "application/json; charset=utf-8");

        //All Validation Headers
         Headers allHedears=response.headers();  //we ll capture all headers from response
        for (Header header:allHedears) {
            System.out.println(header.getName()+"     "+header.getValue());
        }


    }
}
