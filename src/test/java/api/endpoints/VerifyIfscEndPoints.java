package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class VerifyIfscEndPoints {
	
	public static Response verifyIfsc() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("ifsc", "icic0000876")
				
				
				
				.when()
				.post(Routes.verifyIfsc_post_url);
		
		return response;
	}
	}

