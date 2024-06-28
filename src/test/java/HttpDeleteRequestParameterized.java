import static io.restassured.RestAssured.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HttpDeleteRequestParameterized {
	@Test
	@Parameters("userId") // Parameters annotation is used to pass data to deleteRequest method from testng.xml file
     public void deleteRequest(int userId) {
		
		 // Making a DELETE Request
    	 given().
    	      baseUri("http://localhost:3000").
    	      delete("/jobs/"+ userId).
    	 then().
    	      statusCode(200);
     }
}
