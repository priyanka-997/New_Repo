package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.CreateTicketEndPoints;
import io.restassured.response.Response;

public class CreateTicketTests {
	
	@Test(priority=29)	
	public static void testCreateTicket() {
		
		Response response = CreateTicketEndPoints.createTicket();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Ticket created successfully");
		
		String ticketId= response.jsonPath().getString("ticket_id");
		System.out.println("Generated ticket id is " +ticketId);
		
		Assert.assertEquals(response.getStatusCode(), 400);
		Assert.assertEquals(response.jsonPath().getString("message"), "You already have an open ticket.");
		
		
		
		
		
	}

}
