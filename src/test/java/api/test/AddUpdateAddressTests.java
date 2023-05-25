package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.AddUpdateAddressEndPoints;
import io.restassured.response.Response;

public class AddUpdateAddressTests {
	
			
	@Test(priority=9)
	public static void testAddUpdateAddress() {
		
		Response response = AddUpdateAddressEndPoints.addUpdateAddress();
				response.then().log().all();
		
				Assert.assertEquals(response.jsonPath().getString("message"), "Address has been added");
				Assert.assertEquals(response.getStatusCode(), 200);
				Assert.assertEquals(response.jsonPath().getString("address_type"), "Home");
				
		
	
		
	}

}
