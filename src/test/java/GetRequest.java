import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {
	
	@Test
    public void getRequest() {
		// Storing the response of a get request 
    	Response response = RestAssured.get("https://reqres.in/api/users?page=2");
    	
    	// Storing the status-code of the response
    	int statusCode = response.getStatusCode();
    	
    	// Storing the content format of the response data
    	String contentFormat = response.header("content-type");
    	
    	// Printing both status-code & content format
    	System.out.println(statusCode);
    	System.out.println(contentFormat);  	
    }
}
