import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class HttpRequestsToJsonServer {
	@Test 
	public void getRequest() {
		// Making a GET request to fetch user data from the server
		baseURI = "http://localhost:3000";
		given().
		     get("/users").
		then().
		     statusCode(200).
		     log().all();
	}
	
	@Test
     public void postRequest() {
		 // Creating a JSON object in 'payload' variable
		 JSONObject payload = new JSONObject();
    	 
    	 // Adding items to the 'payload'
    	 payload.put("id", 4);
    	 payload.put("firstName", "John");
    	 payload.put("lastName", "Chaffeur");
    	 payload.put("age", 47);
    	 payload.put("sport", null);
    	 
    	 // Making a POST request to user add data to the server
    	 baseURI = "http://localhost:3000";
         given().
    	      contentType(ContentType.JSON).
    	      accept(ContentType.JSON).
    	      body(payload.toJSONString()). //toJSONString method helps in serialization(convert to string) of the JSON object 
    	 when().
    	      post("/users/").
    	 then().
    	      statusCode(201).
    	      log().all();
     }
	
	@Test
	public void putRequest() {
		// Creating a JSON object in 'payload' variable
		JSONObject payload = new JSONObject();
		
		// Adding key & value pairs to 'payload'
		payload.put("firstName", "Eleanor");
		payload.put("lastName", "Leeroy");
		payload.put("age", 22);
		
		//Making a PUT request to replace the existing user data
		baseURI = "http://localhost:3000";  // Setting the the base URI of the URL
		given().
		     header("Content-Type", "application/json").
		     contentType(ContentType.JSON).
		     accept(ContentType.JSON).
		     body(payload.toJSONString()).
		 when().
		     put("/users/1").
		 then().
		     statusCode(200);
	}
	
	@Test
	public void patchRequest() {
		// Creating a JSON object in 'payload' variable
		JSONObject payload = new JSONObject();
		
		// Adding key & value pairs to 'payload'
		payload.put("sport", "Soccer");
		
		// Making a PATCH request to modify the existing user data
		baseURI = "http://localhost:3000";  // Setting the the base URI of the URL
		given().
		     header("Content-Type", "application/json").
		     contentType(ContentType.JSON).
		     accept(ContentType.JSON).
		     body(payload.toJSONString()).
		 when().
		     patch("/users/1").
		 then().
		     statusCode(200);
	}
	
	@Test
	public void deleteRequest() {
		 // Making a DELETE request to delete user data from the server
		 baseURI = "http://localhost:3000";
		 given().
		     delete("/users/3").
		 then().
		     statusCode(200);
	}
}
