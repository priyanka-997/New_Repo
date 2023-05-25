package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GetCommonQuoteEndPoints;
import api.endpoints.GlobalVariables;
import io.restassured.response.Response;

public class GetCommonQuoteTests {	
	

	@Test(priority=7)
	public void testGetCommonQuotes() {
									
		Response response = GetCommonQuoteEndPoints.getCommonQuote();
				
				response.then().log().all();
				Assert.assertEquals(response.jsonPath().getString("message"), "Success");
				Assert.assertEquals(response.getStatusCode(), 200);
				
			GlobalVariables.quote_id = 	response.jsonPath().getString("quote_details.quote_id");
			System.out.println("Generated quote id is " +GlobalVariables.quote_id );			
		
		
	}
	
}
	
