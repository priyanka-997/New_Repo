package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class FaqsEndPoints {
	
	public static Response faq() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token )
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("type", "faqs")
				.formParam("device_type", "android")
				
				.when();
		return response;
		
		
		
	}

}
