package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class PincodeServiceableEndPoints {
	
	
	public static Response pincodeServiceable() {
		
		
		Response response = given()
				
		.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				.formParam("pincode", "201301")
				.formParam("order_type", "sell")
				.formParam("category", "mobile")
				
				
		
		.when()
		.post(Routes.pincode_serviecable_post_url)  ;
		
		return response;
		
	}

}
