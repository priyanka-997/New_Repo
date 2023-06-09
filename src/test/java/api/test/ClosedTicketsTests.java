package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ClosedTicketsEndPoints;
import io.restassured.response.Response;

public class ClosedTicketsTests {
	
	
@Test(priority=31)
	
	public static void testClosedTickets() {
		
		Response response = ClosedTicketsEndPoints.closedTickets();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.jsonPath().getString("tickets[0].ticket_status"), "Closed");
		Assert.assertEquals(response.jsonPath().getString("tickets[1].awb_number"), "general_7905120105");
	
		
	}

}
