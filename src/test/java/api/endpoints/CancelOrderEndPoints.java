package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CancelOrderEndPoints {
	
	public static Response cancelOrder() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("order_id", GlobalVariables.order_id)
				.formParam("reason", "Test Reason")
				
				.when();
		
		return response;
		
		
		
	}

}
