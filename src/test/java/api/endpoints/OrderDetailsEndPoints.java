package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrderDetailsEndPoints {
	
	public static Response orderDeatails() {
		
		Response response = (Response) given()
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.accept("*/*")
				.pathParam("order_id", GlobalVariables.order_id)
		
		.when();
		
		return response;
		
		
	}

}
