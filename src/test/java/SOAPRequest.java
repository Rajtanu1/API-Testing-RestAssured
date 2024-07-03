import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;;

public class SOAPRequest {
	@Test
     public void postRequest() throws IOException {
          baseURI = "https://ecs.syr.edu";
          
          File file = new File("./src/test/resources/AddNumbers.xml"); // Created a file object referring to AddNumbers.xml file 
          FileInputStream fileData = new FileInputStream(file); // Storing data of xml file to the fileData variable
          
          String payload = IOUtils.toString(fileData, "UTF-8"); // Converting xml file data to a string 
          
          given().
               contentType("text/xml").
               accept(ContentType.XML).
               body(payload).
          when().
               post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx").
          then().
               statusCode(200).
               body("//AddResult.text()", equalTo("45")); // Validating AddResult element value in the xml body with equalto assertion method  	 
     }
}
