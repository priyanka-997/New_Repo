package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrderAvailableTimeslotsEndPoints {
	
	
	public static Response availableTimeslots() {
		
	Response response = (Response) given()
			
			.headers("Authorization", "Bearer " +GlobalVariables.token)
			
			.contentType("application/x-www-form-urlencoded")
			.accept("*/*")
		
		.when()
		.get(Routes.order_availableSlot_get_url)   ;
	
	return response;
		
	}

}
