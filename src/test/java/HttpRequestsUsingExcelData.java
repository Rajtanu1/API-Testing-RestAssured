import static io.restassured.RestAssured.*;

import java.io.IOException;

import utils.ExtractExcelData;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class HttpRequestsUsingExcelData {
	@Test
     public void postRequestUsingExcelData() throws IOException {
    	 baseURI = "http://localhost:3000";
    	 
    	 JSONObject payload = new JSONObject();
    	 ExtractExcelData excelWorkbook = new ExtractExcelData(); // Creating an object of custom class "ExtractExcelData"
    	 int rowIndex = 2;
    	 
    	 // Using methods of custom class "ExtractExcelData" to retrieve excel data
    	 payload.put("firstName", excelWorkbook.getFirstName(rowIndex));
    	 payload.put("lastName", excelWorkbook.getLastName(rowIndex));
    	 payload.put("sport", null);
    	 payload.put("age", excelWorkbook.getAge(rowIndex));
    	 
    	 // Making a POST request to add new user to the server
    	 given().
    	      contentType(ContentType.JSON).
    	      accept(ContentType.JSON).
    	      body(payload.toJSONString()).
    	 when().
    	      post("/users/").
    	 then().
    	      statusCode(201);
    	 ;
     }
}
