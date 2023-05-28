package api.test;

import org.testng.Assert;

import api.endpoints.GlobalVariables;
import api.endpoints.PlaceOrderEndPoints;
import io.restassured.response.Response;

public class PlaceOrderTests {
	
	public void testPlceOrder() {
		
		Response response = PlaceOrderEndPoints.placeOrder();
				
			response.then().log().all();
			
			Assert.assertEquals(response.getStatusCode(), 200);
			
			GlobalVariables.order_id = response.jsonPath().getInt("order_id");
			
			
			
	}

}
