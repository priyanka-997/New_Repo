package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ListOrdersEndPoints;
import io.restassured.response.Response;

public class ListOrdersTests {
	
	@Test(priority=16)
public static void testListOrders() {
		
		Response response = ListOrdersEndPoints.listOrders();
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
			
}

}
