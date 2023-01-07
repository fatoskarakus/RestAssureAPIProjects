package RestAssureAPITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC001_GET_REQUEST {

    //Validate status code & Status line
    @Test
    public void GetBooksDetails() {

        //Specify base URI
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET);
        System.out.println("Response=>" + response.prettyPrint());

        String responseBody = response.getBody().asString();
        System.out.println("response Body  : " + responseBody);

        //status code validation
        int StatusCode = response.getStatusCode();
        System.out.println("response code  : " + StatusCode);
        Assert.assertEquals(StatusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status line is  :" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
