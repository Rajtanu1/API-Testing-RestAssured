import org.testng.annotations.DataProvider;

public class DataProviderForHttpRequest {
	@DataProvider
     public Object[][] dataForPostRequest() {
    	 return new Object[][] {
    		 {"Jackson", "Luther", 25},
    		 {"King", "James", 22},
    		 {"Daphne", "Armstrong", 26}
    	 };
     }
	
	@DataProvider
    public Object[] dataForDeleteRequest() {
   	 return new Object[] {
   		   4, 5, 6
   	    };
     }
}
