package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.DetectDeviceEndPoints;
import api.endpoints.GlobalVariables;
import api.payload.DetectDevicePojo;
import io.restassured.response.Response;

public class DetectDeviceTests {
	
	DetectDevicePojo detectDevicePayload;
	
	@BeforeClass()
	
	public void setupData() {
		
		 detectDevicePayload = new DetectDevicePojo();
		
		detectDevicePayload.setCpu_model("Qualcomm Technologies");
		detectDevicePayload.setInternal_memory(4);
		detectDevicePayload.setInternal_storage(64);
		detectDevicePayload.setModel_number("RMX1971");
	}
	
	@Test(priority=5)
	public void testDetectDevice() {
		
	Response response = DetectDeviceEndPoints.detectDevice(detectDevicePayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	GlobalVariables.variant_slug= 	response.jsonPath().getString("variant.product_url");
	System.out.println("Variant slug is " +GlobalVariables.variant_slug );
	
	
	}
}
