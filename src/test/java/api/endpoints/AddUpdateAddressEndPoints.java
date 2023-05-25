package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AddUpdateAddressEndPoints {
	
	public static Response addUpdateAddress() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("house_no", "A-54")
				.formParam("street_no", "26")
				.formParam("locality", "Noida")
				.formParam("pincode", "201303")
				.formParam("city", "Noida")
				.formParam("address_type", "Home")
				.formParam("state", "Uttar Pradesh")
				
				
				.when()
				.post(Routes.addUpdateAddress_post_url);
		return response;
		
		
	}

}
