import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
public class JSONSchemaValidator {
     @Test
     public void validateJSONUsingSchema() {
    	 baseURI = "https://reqres.in/";
    	 
    	 // Making a GET request  
    	 given().
    	      get("/api/users?page=2").
    	 then().
    	      assertThat().
    	      body(matchesJsonSchemaInClasspath("json-schema.json")). // Validating a JSON response against JSON schema defined in a json file saved in target > classes directory
    	      statusCode(200);
     }
}
