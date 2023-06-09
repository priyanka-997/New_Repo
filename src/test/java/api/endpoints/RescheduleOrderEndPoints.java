package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RescheduleOrderEndPoints {

	public static Response rescheduleOrder() {
		
		Response response =  (Response) given()
				
				.headers("Authorization","Bearer " +GlobalVariables.token)
				
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("order_id", GlobalVariables.order_id)
				.formParam("reason", "Changed My Mind")
				.formParam("date", GlobalVariables.pickup_date)
				.formParam("time", GlobalVariables.time_slot)
				
				.when()
				.post(Routes.reschedule_order_post_url);
		
		return response;
				
		
	}
}
