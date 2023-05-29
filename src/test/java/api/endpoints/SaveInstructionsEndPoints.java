package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class SaveInstructionsEndPoints {

	public static Response saveInstructions() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("order_id", GlobalVariables.order_id)
				.formParam("instructions", "Please try to pick as soon as possible")
				
				.when()
		        .post(Routes.save_instructions_post_url);
		
		return response;
	}
}
