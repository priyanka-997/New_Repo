package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.GlobalVariables;
import api.endpoints.LoginEndPoints;
import io.restassured.response.Response;

public class LoginTests {
	
		@Test(priority=1)
		public void testLogin() {
			
		Response response= LoginEndPoints.Login();
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message" ), "OTP Sent to entered mobile number");
		Assert.assertEquals(response.getStatusCode(), 200);
			
			
		}
				
		@Test(priority=2)
		public void testResendOtp() {
			
			Response response= LoginEndPoints.ResendOtp();
			response.then().log().all();
			
			Assert.assertEquals(response.jsonPath().getString("message" ), "OTP Sent to entered mobile number");
			
			Assert.assertEquals(response.getStatusCode(), 200);
		
				
			}
		
		@Test(priority=3)
		public void testVerifyOtp() {
			
			Response response= LoginEndPoints.verifyOtp();
			response.then().log().all();
			
			Assert.assertEquals(response.getStatusCode(), 200);
			Assert.assertEquals(response.jsonPath().getString("profile.mobile"), "7905120105");
			
			
			GlobalVariables.token = response.jsonPath().getString("tokens.token") ;
		System.out.println("Generated token is " +GlobalVariables.token);
		
		
		GlobalVariables.mobileNumber = response.jsonPath().getString("profile.mobile");
		System.out.println("Mobile number is " +GlobalVariables.mobileNumber);
		
				
		}
		
		
}

