package RestAssureAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GET_REQUEST {

    @Test
    public void validateTheHeaders() {

        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET);

        // System.out.println("Response=>" + response.prettyPrint());
        // String responseBody = response.getBody().asString();
        // System.out.println("response Body  : " + responseBody);

        //Validate the headers
        String contentType=response.header("Content-Type");
        System.out.println("Content Type. " +contentType);
        Assert.assertEquals(contentType,"application/json; charset=utf-8");

        String server=response.header("Server");
        System.out.println("Content Type. " +server);
        Assert.assertEquals(server,"nginx/1.17.10 (Ubuntu)");

    }
}
