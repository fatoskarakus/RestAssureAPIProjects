package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ExcelLibraries.ExcelLibraries;

import java.io.IOException;


public class TC001_DataDriven_AddNewEmployes_Request {
    private ExcelLibraries excelData;

    @Test(dataProvider = "empdataprovider")
    public void PostNewEmployes(String ename, String eage, String eSal) {

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", ename);
        requestParams.put("salary", eage);
        requestParams.put("age", eSal);

        //add header information
        request.header("Content-Type", "application/json");

        //add body detail using json
        request.body(requestParams.toJSONString());

        //POST REQUEST
        Response response = request.post("/create");

        //capture response body
        String responseBody = response.getBody().asString();
        System.out.println("The status received: " + responseBody);

        Assert.assertEquals(responseBody.contains(ename), true);
        Assert.assertEquals(responseBody.contains(eage), true);
        Assert.assertEquals(responseBody.contains(eSal), true);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    //    @DataProvider(name = "empdataprovider")
//    String[][] getEmpData() throws IOException {
//
//        String path = "C:/Users/FATMA/IdeaProjects/RestAssuredProject/TestData/TestData.xlsx";
//
//        excelData=new ExcelLibraries(path);
//        int rowCount = excelData.getRowCount("employee"); //6
//        System.out.println(rowCount);
//        int columnCount = excelData.getColumnCount("employee"); //3
//        System.out.println(columnCount);
//        //String empdata[][]={{"empYST124","25888","20"},{"empYSTyt4","25768","300"},{"EXTH564","55412","64"}};
//        String empdata[][] = new String[rowCount][columnCount];
//        for (int i = 1; i <= rowCount; i++) {
//
//            for (int j =1 ; j <= columnCount; j++) {
//                empdata[i-1][j] = excelData.readOneData("employee",i,j);
//                System.out.println(empdata[i][j]);
//            }
//        }
//        return (empdata);
//    }
    @DataProvider(name = "empdataprovider")
    public String[][] getDat() throws IOException {
        String path = "C:/Users/FATMA/IdeaProjects/RestAssuredProject/TestData/TestData.xlsx";
        ExcelLibraries excelData = new ExcelLibraries(path);

        int rowCount = excelData.getRowCount("employee"); //6
        System.out.println(rowCount);
        int columnCount = excelData.getColumnCount("employee"); //3
        System.out.println(columnCount);

        String[][] value = excelData.getEmpData2( "employee", rowCount, columnCount);
        System.out.println("excel datası    :"+value);
        return (value);
    }

}
