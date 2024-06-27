import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import io.restassured.http.ContentType;

public class DataDrivenHttpRequests extends DataProviderForHttpRequest {
	 @Test(dataProvider = "dataForPostRequest") // Using dataProvider annotation to get data from 'dataForPostRequest' method located in DataProviderForHttpRequest file.
     public void postRequest(String role, String position, int exp) {
    	 // Creating a JSON object in 'payload' variable
    	 JSONObject payload = new JSONObject();
    	 
    	 // Adding key & value pairs to 'payload'
    	 payload.put("role", role);
    	 payload.put("position", position);
    	 payload.put("experience", exp);
    	 
    	 // Making a POST request
    	 baseURI = "http://localhost:3000";
    	 
    	 given().
    	      header("Content-Type", "application/json").
    	      contentType(ContentType.JSON).
    	      accept(ContentType.JSON).
    	      body(payload.toJSONString()).
    	 when().
    	      post("/jobs").
    	 then().
    	      statusCode(201);
     }
	 
	 @Test(dataProvider = "dataForDeleteRequest") // Using dataProvider annotation to get data from 'dataForDeleteRequest' method located in DataProviderForHttpRequest file.
     public void deleteRequest(int userId) {  	 
    	 // Making a DELETE request
    	 baseURI = "http://localhost:3000";
    	 
    	 given().
    	      delete("/jobs/" + userId).
    	 then().
    	      statusCode(200);
     }
}
