package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.GlobalVariables;
import api.endpoints.OrderAvailableTimeslotsEndPoints;
import io.restassured.response.Response;

public class OrderAvailableTimeslotsTests {
	
	
	
	@Test(priority=12)
	public void testOrderAvaialbleTimeslots() {
		
		Response response = OrderAvailableTimeslotsEndPoints.availableTimeslots();
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		GlobalVariables.date = response.jsonPath().getString("list[2].date");
		System.out.println("Available date is " +GlobalVariables.date);
		
		/*DateTimeFormatter fIn = DateTimeFormatter.ofPattern( "dd/MM/yyyy" , Locale.UK );  
		LocalDate ld = LocalDate.parse( GlobalVariables.date , fIn );
		
		DateTimeFormatter fOut = DateTimeFormatter.ofPattern( "yyyy/MM/dd" , Locale.UK );
		String output = ld.format( fOut );
		
		System.out.println("Available date is " +output);*/
		
		
		GlobalVariables.time_slot = response.jsonPath().getString("list[2].timeslot");
		System.out.println("Available timeslot is " +GlobalVariables.time_slot);
		
		JSONObject obj = new JSONObject(response.asString());
		
		for(int i =0; i<obj.getJSONArray("list").length(); i++) {
			 
			 
			 String Date = obj.getJSONArray("list").getJSONObject(i).get("list[0].date").toString();
			String TimeSlot = obj.getJSONArray("list").getJSONObject(i).get("list[0].timeslot").toString();
			
			 
			 
			if (Date.equals("03-07-2023")) {
		    	   
				 break;
			 }
		    	if    (TimeSlot.equals("10 AM - 12 PM")) {
			    	   
		    		break;
		
	}

}
}}