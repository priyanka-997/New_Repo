package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class AddUpdateAddressEndPoints {
	
	public static Response addUpdateAddress(String addUpdateAddressPayload) {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(addUpdateAddressPayload)
				
				.when()
				.post(Routes.addUpdateAddress_post_url);
		return response;
		
		
	}

}
