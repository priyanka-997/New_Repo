package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.PincodeServiceablePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PincodeServiceableEndPoints {
	
	
	public static Response pincodeServiceable(PincodeServiceablePojo pincodePayload) {
		
		
		Response response = given()
				
		.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(pincodePayload)
		
		.when()
		.post(Routes.pincode_serviecable_post_url)  ;
		
		return response;
		
	}

}
