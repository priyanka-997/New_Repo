package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GlobalVariables;
import api.endpoints.OrderAvailableTimeslots;
import io.restassured.response.Response;

public class OrderAvailableTimeslotsTests {
	
	
	@Test(priority=12)
	public void testOrderAvaialbleTimeslots() {
		
		Response response = OrderAvailableTimeslots.availableTimeslots();
		
		response.then().log().all();
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		GlobalVariables.date = response.jsonPath().getString("list[2].date");
		System.out.println("Available date is " +GlobalVariables.date);
		GlobalVariables.time_slot = response.jsonPath().getString("list[2].timeslot");
		System.out.println("Available timeslot is " +GlobalVariables.time_slot);
	}

}
