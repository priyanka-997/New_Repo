package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.DetectDeviceEndPoints;
import api.endpoints.GlobalVariables;
import io.restassured.response.Response;

public class DetectDeviceTests {
	
	
	@Test(priority=5)
	public void testDetectDevice() {
		
	Response response = DetectDeviceEndPoints.detectDevice();
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		GlobalVariables.variant_slug= 	response.jsonPath().getString("variant.product_url");
	System.out.println("Variant slug is " +GlobalVariables.variant_slug );
	
	
	}
}
