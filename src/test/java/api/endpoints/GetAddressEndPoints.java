package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;


public class GetAddressEndPoints {
	
	
	public static Response address() {
		
	Response response = (Response) given()
			
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.headers("Authorization", "Bearer " +GlobalVariables.token )
						
			.when()
			.get(Routes.getAddress_get_url);
		return response;
		
		
		
	}

}
