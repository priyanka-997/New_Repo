package api.test;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.GlobalVariables;
import api.endpoints.OrderAvailableTimeslotsEndPoints;
import io.restassured.response.Response;

public class OrderAvailableTimeslotsTests {
	
	//public static String pickup_date; //= GlobalVariables.pickup_date ;
	//public static String pickup_date ;
	
	public static String pickup_date;
	
	

	@Test(priority=12)
	public void testOrderAvaialbleTimeslots() {
		
		
		Response response = OrderAvailableTimeslotsEndPoints.availableTimeslots();
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		GlobalVariables.date = response.jsonPath().getString("list[5].date");
		System.out.println("Available date is " +GlobalVariables.date);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = GlobalVariables.date;
        
         LocalDate pickup_date = LocalDate.parse(date, formatter);
        System.out.println("Formatted date is " +pickup_date); 
			
			/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        String date = GlobalVariables.date;
		        LocalDate pickup_date = LocalDate.parse(date, formatter);
		        System.out.println("Formatted date is " +pickup_date); */
				
			
			/*LocalDate ld = LocalDate.parse(GlobalVariables.date);
	        pickup_date = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ld);
	        System.out.println("New formatted date is: " +pickup_date); */
		
	        
	     /*   DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive()
	                .append(DateTimeFormatter.ofPattern("y-m-d")).toFormatter();
	        try {
	            LocalDate pickup_date = LocalDate.parse(GlobalVariables.date, f);
	            System.out.println(pickup_date); 
	        } catch (DateTimeParseException e) {
	            
	        }*/
	        
	        
	       /* String date = GlobalVariables.date;
	        
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US);
	        LocalDateTime pickup_date = LocalDateTime.parse(date, dtf);
	       
	        System.out.println(pickup_date);*/
		
		/*static String pickup_date;
		
		public void reverseDate() {
			
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        String date = GlobalVariables.date;
		        LocalDate pickup_date = LocalDate.parse(date, formatter);
		        System.out.println("Formatted value is "+pickup_date);
			}
		*/
		
		
		
		
		GlobalVariables.time_slot = response.jsonPath().getString("list[2].timeslot");
		System.out.println("Available timeslot is " +GlobalVariables.time_slot);
		
		
		
		
		/*JSONObject obj = new JSONObject(response.asString());
		
		for(int i =0; i<obj.getJSONArray("list").length(); i++) {
			 
			 
			 String Date = obj.getJSONArray("list").getJSONObject(i).get("list[0].date").toString();
			String TimeSlot = obj.getJSONArray("list").getJSONObject(i).get("list[0].timeslot").toString();
			
			 	 
			if (Date.equals("03-07-2023")) {
		    	   
				 break;
			 }
		    	if    (TimeSlot.equals("10 AM - 12 PM")) {
			    	   
		    		break;
	}

}*/
}}