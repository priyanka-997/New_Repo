package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.RescheduleOrderEndPoints;
import io.restassured.response.Response;

public class RescheduleOrderTests {
	
	@Test(priority=18)
	public static void testRescheduleOrder() {
		
	Response response = RescheduleOrderEndPoints.rescheduleOrder();
	
	response.then().log().all();
	Assert.assertEquals(response.jsonPath().getString("message"), "Order has been rescheduled");
	Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
