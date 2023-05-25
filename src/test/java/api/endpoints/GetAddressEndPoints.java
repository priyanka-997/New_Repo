package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetAddressEndPoints {
	
	
	public static Response address() {
		
	Response response = (Response) given()
			
			.contentType("application/json")
			.accept("*/*")
			
			.headers("Authorization", "Bearer " +GlobalVariables.token )
						
			.when()
			.get(Routes.getAddress_get_url);
	
		return response;
		
		
		
	}

}
