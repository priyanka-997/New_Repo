package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ViewProfileEndPoints;
import io.restassured.response.Response;

public class ViewProfileTests {
	
	@Test(priority=23)
	public static void testViewProfile() {
		
		
		Response response = ViewProfileEndPoints.viewProfile();
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.jsonPath().getString("details.fullname"), "Priyanka Sharma");
		Assert.assertEquals(response.jsonPath().getString("details.mobile"), "7905120105");
		
	}

}
