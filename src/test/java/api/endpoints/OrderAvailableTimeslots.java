package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class OrderAvailableTimeslots {
	
	
	public static Response availableTimeslots() {
		
	Response response = (Response) given()
			
			.headers("Authorization", "Bearer " +GlobalVariables.token)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		
		.when()
		.get(Routes.order_availableSlot_get_url)   ;
	return response;
		
	}

}
