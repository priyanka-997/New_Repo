package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ChangePaymentMethodEndPoints;
import io.restassured.response.Response;

public class ChangePaymentMethodTests {
	
	@Test(priority=20)
	public static void testChangePaymentMethod() {
		
		Response response = ChangePaymentMethodEndPoints.changePaymentMethod();
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Payment method has been changed");
	}

}
