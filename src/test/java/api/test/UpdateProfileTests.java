package api.test;

import org.testng.Assert;

import api.endpoints.UpdateProfileEndPoints;
import io.restassured.response.Response;

public class UpdateProfileTests {
	
	public static void testUpdateProfile() {
		
		Response response = UpdateProfileEndPoints.updateProfile();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getShort("message"), "Profile has been updated");
		
	}

}