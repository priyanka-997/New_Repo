package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class ApplicablePaymentMethodsEndPoints {
	
	
	public static Response applicablePaymentMathods() {
		
		Response response = given()
				
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("quote_id", GlobalVariables.quote_id)
				
				.when()
				.post(Routes.applicablePaymentMethods_post_url);
		return response;
		
		
		
		
	}

}
