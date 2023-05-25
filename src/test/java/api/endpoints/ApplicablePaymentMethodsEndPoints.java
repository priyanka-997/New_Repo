package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class ApplicablePaymentMethodsEndPoints {
	
	
	public static Response applicablePaymentMathods(String quoteIdPayload) {
		
		Response response = given()
				
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(quoteIdPayload)
				
				.when()
				.post(Routes.applicablePaymentMethods_post_url);
		return response;
		
		
		
		
	}

}
