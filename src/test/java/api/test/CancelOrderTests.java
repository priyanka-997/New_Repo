package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.CancelOrderEndPoints;
import io.restassured.response.Response;

public class CancelOrderTests {
	
	@Test(priority=21)
	
	public static void testCancelOrder() {
		
		Response response = CancelOrderEndPoints.cancelOrder();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Order has been cancelled");
		
		
	}

@Test(priority=22)
	
	public static void testCancelSameOrder() {
		
		Response response = CancelOrderEndPoints.cancelOrder();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 400);
		Assert.assertEquals(response.jsonPath().getString("message"), "Order cannot be cancelled now");
		
		
	}
}
