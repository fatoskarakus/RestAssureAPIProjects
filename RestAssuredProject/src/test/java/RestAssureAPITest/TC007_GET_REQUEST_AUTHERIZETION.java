package RestAssureAPITest;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_GET_REQUEST_AUTHERIZETION {

    @Test
    public void GetAutherizetionFailScenerio() {

        RestAssured.baseURI = "https://demoqa.com/Account/v1/User/UUID";

        //basic autherization
        PreemptiveBasicAuthScheme autherization = new PreemptiveBasicAuthScheme();
        autherization.setUserName("test");
        //autherization.setPassword("test");
        RestAssured.authentication=autherization;

        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        //Response object
        Response response = httpRequest.request(Method.GET);

        String responsBody = response.getBody().asPrettyString();
        System.out.println("Response Body:  " + responsBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code   :" + statusCode);
        Assert.assertEquals(statusCode, 401);




    }
}
