package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.AddUpdateAddressEndPoints;
import io.restassured.response.Response;

public class AddUpdateAddressTests {
	
public static String getaddUpdateAddressPayload() {
		
	String addUpdateAddressPayload= "{ \n"  +"\"house_no\":\"A-53\", \n" 
			                  +"\"street_no\":\"25\", \n" 
			                  +"\"locality\":\"Noida City Center\", \n"
			                  +"\"pincode\":\"201301\", \n" 
			                  +"\"city\":\"Noida\", \n" 
			                  +"\"address_type\":\"Home\", \n" 
			                  +"\"state\":\"Uttar Pradesh\"}";		
		
		return addUpdateAddressPayload;
}
			
	@Test(priority=9)
	public static void testAddUpdateAddress() {
		
		Response response = AddUpdateAddressEndPoints.addUpdateAddress(getaddUpdateAddressPayload());
				response.then().log().all();
		
				Assert.assertEquals(response.jsonPath().getString("message"), "Address has been added");
				Assert.assertEquals(response.getStatusCode(), 200);
				Assert.assertEquals(response.jsonPath().getString("address_type"), "Home");
				
		
	
		
	}

}
