import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class HttpRequests {
	
	@Test
    public void postRequest() {
		// Creating a HashMap object named "hashMap"
    	Map<String, Object> hashMap = new HashMap<String, Object>();
    	
    	// Adding key & value pairs to the newly created hashMap object
    	hashMap.put("first_name", "Rajtanu");
    	hashMap.put("age", "27");
    	hashMap.put("last_name", "Chakravarty");
    	
    	// Converting hashMap object into a JSON object using json-simple library 
    	JSONObject jsonPayload = new JSONObject(hashMap);
    	
        // Making a post request
    	given().
    	     body(jsonPayload.toJSONString()). // 'toJSONString' method helps in serialization(convert to string) of the JSON object
    	when().
    	     post("https://reqres.in/api/users?page=2").
    	then().
    	     statusCode(201); // Performing assertion on the status code
    }
	
	@Test
	public void putRequest() {
		//Creating a JSON object
		JSONObject payload = new JSONObject();
		
		// Adding key & value pairs to the object
		payload.put("first_name", "John");
		payload.put("last_name", "Doe");
		payload.put("age", 25);
		payload.put("designation", "Manager");
		
		// Making a put request
		given().
		     header("Content-Type", "application/json").
		     body(payload.toJSONString()). //toJSONString method helps in serialization(convert to string) of the JSON object
		when().
		     put("https://reqres.in/api/users/2").
		then().
		     log().all();
	}
	
	@Test
	public void patchRequest() {
		// Creating JSON object 
		JSONObject payload = new JSONObject();
		
		// Adding key & value pairs to the object
		payload.put("first_name", "Michael");
		payload.put("last_name", "Zander");
		payload.put("designation", "Solutions Architect");
		payload.put("age", 30);
		
		given().
		     header("Content-Type", "application/json").
		     body(payload.toString()). //toJSONString method helps in serialization(convert to string) of the JSON object
		when().
		     put("https://reqres.in/api/users/2").
		then().
		      statusCode(200).
		      log().all();
	}
	
	@Test
	public void deleteRequest() {
		// Making a delete request
		when().
		     delete("https://reqres.in/api/users/2").
		then().
		      statusCode(204).
		      log().all();
	}
}
