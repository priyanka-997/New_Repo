package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.VerifyIfscEndPoints;
import io.restassured.response.Response;

public class VerifyIfscTests {
	
	public static String ifscPayload() {
		
		String ifscPayload = "{\n"
                +"\"ifsc\": \"icic0000876\"}";
						
		return ifscPayload;
		
	}	
	
	@Test(priority=11)
	public static void testVerifyIfsc() {
		
		Response response =  VerifyIfscEndPoints.verifyIfsc(ifscPayload());
		
		response.then().log().all();
		Assert.assertEquals(response.jsonPath().getString("message"), "success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("Bank address is " +response.jsonPath().getString("data.ADDRESS"));
		
		
	}

}
