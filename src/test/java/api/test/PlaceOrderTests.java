package api.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GlobalVariables;
import api.endpoints.PlaceOrderEndPoints;
import io.restassured.response.Response;

public class PlaceOrderTests {
	
	static String pickup_date = GlobalVariables.pickup_date;
	
	public void setupData() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = GlobalVariables.date;
        LocalDate pickup_date = LocalDate.parse(date, formatter);
        System.out.println("Formatted date is " +pickup_date); 
        
		
	}
	

	@Test(priority=15)
	public void testPlaceOrder() {
		
		Response response = PlaceOrderEndPoints.placeOrder();
				
			response.then().log().all();
			
			Assert.assertEquals(response.getStatusCode(), 200);
			Assert.assertEquals(response.jsonPath().getString("message"), "Success");
			
			
			GlobalVariables.order_id = response.jsonPath().getInt("order_id");
					
			
	}

}
