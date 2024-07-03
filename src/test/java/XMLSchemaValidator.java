import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidator {
     @Test
     public void postRequest() throws IOException {
    	  baseURI = "https://ecs.syr.edu";
    	  
    	  File file = new File("./src/test/resources/AddNumbers.xml"); // Created a file object referring to AddNumbers.xml file
    	  FileInputStream fileData = new FileInputStream(file); // Storing data of xml file to the fileData variable
    	  
 
    	  String payload = IOUtils.toString(fileData, "UTF-8"); // Converting xml file data to a string 
    	  
    	  // Making a POST request 
    	  given().
    	      contentType("text/xml").
    	      accept(ContentType.XML).
    	      body(payload).
    	  when().
    	      post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx").
    	  then().
    	       statusCode(200).log().all().and().
    	       assertThat().
    	       body(RestAssuredMatchers.matchesXsdInClasspath("xml-schema.xsd")); // Validating the xml response with xml schema defined in xsd file present in  src > test > resources directory	      
     }
}
