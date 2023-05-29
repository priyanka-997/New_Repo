package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GlobalVariables;
import api.endpoints.PlaceOrderEndPoints;
import io.restassured.response.Response;

public class PlaceOrderTests {
	
	@Test(priority=15)
	public void testPlceOrder() {
		
		Response response = PlaceOrderEndPoints.placeOrder();
				
			response.then().log().all();
			
			Assert.assertEquals(response.getStatusCode(), 200);
			Assert.assertEquals(response.jsonPath().getString("message"), "Success");
			
			
			GlobalVariables.order_id = response.jsonPath().getInt("order_id");
					
			
	}

}
