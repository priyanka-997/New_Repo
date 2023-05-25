package api.endpoints;


import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class ListVariantsEndPoints {
	
	public static Response listVariantsQuestions() {
		
		String bearerToken = GlobalVariables.token;	
		
	Response response =	given()
			
			.headers("Authorization", "Bearer " +bearerToken)
			
		.contentType("application/x-www-form-urlencoded")
		.accept("*/*")
		
		.formParam("exchange_method", "sell")
		.formParam("city", GlobalVariables.city)
		.formParam("variant_slug", GlobalVariables.variant_slug)
		
		.when()
		.post(Routes.list_variant_questions_post_url);
		
		return response;
	}

}
