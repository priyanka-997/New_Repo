package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RequestCallbackEndPoints {
	
	public static Response requestCallback() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("ticket_category", "Contact Issue")
				.formParam("ticket_subcategory", "I am not able to contact account manager")
				.formParam("ticket_problem_statement", "Kindly call back")
				.formParam("tracking_id", "general_7905120105")
				
		
		.when()
		.post(Routes.request_callback_post_url);
		
		return response;
		
	}

}
