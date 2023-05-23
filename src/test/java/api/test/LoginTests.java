package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.GlobalVariables;
import api.endpoints.LoginEndPoints;
import api.payload.LoginPojo;
import io.restassured.response.Response;

public class LoginTests {
	
	
		LoginPojo userPayload;
		
		@BeforeClass()
		public void setupData() {
			
			userPayload= new LoginPojo();
			
			userPayload.setMobile_number("7905120105");
			
		}
		
		@Test(priority=1)
		public void testLogin() {
			
		Response response= LoginEndPoints.Login(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
			
			
		}
				
		@Test(priority=2)
		public void testResendOtp() {
			
			Response response= LoginEndPoints.ResendOtp(userPayload);
			response.then().log().all();
			
			Assert.assertEquals(response.jsonPath().getString("message" ), "OTP Sent to entered mobile number");
			
			Assert.assertEquals(response.getStatusCode(), 200);
		
				
			}
		
		@Test(priority=3)
		public void testVerifyOtp() {
			
			userPayload.setOtp(1111);
			
			
			Response response= LoginEndPoints.verifyOtp(userPayload);
			response.then().log().all();
			
			Assert.assertEquals(response.getStatusCode(), 200);
			
			
		GlobalVariables.token = response.jsonPath().getString("tokens.token") ;
		System.out.println("Generated token is " +GlobalVariables.token);
		
		
		GlobalVariables.mobileNumber = response.jsonPath().getString("profile.mobile");
		System.out.println("Mobile number is " +GlobalVariables.mobileNumber);
		
				
		}
		
		
}

