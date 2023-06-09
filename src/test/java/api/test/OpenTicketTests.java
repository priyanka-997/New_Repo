package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.OpenTicketsEndPoints;
import io.restassured.response.Response;

public class OpenTicketTests {
	
	@Test(priority=30)
	
	public static void testOpenTickets() {
		
		Response response = OpenTicketsEndPoints.openTicket();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("tickets[0].ticket_status"), "Open");
		Assert.assertEquals(response.jsonPath().getString("tickets[0].awb_number"), "general_7905120105");
		
		
		
		
		
	}
	

}
