package api.test;

//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.SupportQuestionsEndPoints;
import io.restassured.response.Response;

public class SupportQuestionsTests {
	
	@Test(priority=28)
	public void testSupportQuestions() {
		
		
		Response response = SupportQuestionsEndPoints.supportQuestionsEndPoint();
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
                 /* JSONObject obj = new JSONObject(response.asString());
		
		              for(int i =0; i<obj.getJSONArray("answers").length(); i++) {
			 
			 
			 String Date = obj.getJSONArray("list").getJSONObject(i).get("list[0].date").toString();
			String TimeSlot = obj.getJSONArray("list").getJSONObject(i).get("list[0].timeslot").toString();
			
			 	 
			if (Date.equals("03-07-2023")) {
		    	   
				 break;
			 }
		    	if    (TimeSlot.equals("10 AM - 12 PM")) {
			    	   
		    		break;
	}

}*/	
		
		
	}
}
