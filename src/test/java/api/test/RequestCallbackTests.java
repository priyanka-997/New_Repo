package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.RequestCallbackEndPoints;
import io.restassured.response.Response;

public class RequestCallbackTests {
	
	@Test(priority=27)
	public void testCreateTicket() {
		
		Response response = RequestCallbackEndPoints.requestCallback();
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Ticket created successfully");
		
		System.out.println(response.jsonPath().getString("ticket_id"));
		
	}
	
	@Test(priority=28)
	public void testAlreadyCreated() {
		
		Response response = RequestCallbackEndPoints.requestCallback();
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 400);
		Assert.assertEquals(response.jsonPath().getString("message"), "You already have an open ticket.");
	
		
	}
	
}
