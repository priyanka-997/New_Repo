package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ViewProfileEndPoints {
	
	public static Response viewProfile() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.accept("*/*")
				
				.when()
				.get(Routes.view_profile_get_url);
		
		return response;
		
		
		
	}

}
