package RestAssureAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_REQUEST {

    //succes Scenerio
    @Test
    public void PostUserDetails() {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", "TQ123");
        requestParams.put("isbn", "9781449325862");

        request.header("Content-Type", "application/json");

        request.body(requestParams.toJSONString());

        Response response = request.post("/BookStoreV1BooksPost");
        System.out.println("The status received: " + response.statusLine());

    }

    //fail scenerio
    // @Test
    public void UserRegistration() {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "test_rest");
        requestParams.put("password", "Testrest@123");

        request.body(requestParams.toJSONString());

        Response response = request.put("/User");
        int StatusCode = response.getStatusCode();

        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

        Assert.assertEquals(StatusCode, 400);

    }
}
