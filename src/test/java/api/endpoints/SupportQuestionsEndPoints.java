package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class SupportQuestionsEndPoints {
	
	public static Response supportQuestionsEndPoint() {
		
		Response response = (Response) given()
				
				.headers("Authorization","Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("category", "General")
				
				.when()
				.post(Routes.support_questions_post_url);
		
		return response;	
		
	} 

}
