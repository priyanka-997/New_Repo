package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.FaqsEndPoints;
import io.restassured.response.Response;


@Test(priority=32)
public class FaqsTests {
	
	
	public static void testFaqs() {
		
		Response response =  FaqsEndPoints.faq();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		
		
	}

}
