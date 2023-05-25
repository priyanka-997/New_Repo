package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.ApplyCouponPojo;
import io.restassured.http.ContentType;

public class ApplyCouponEndPoints {
	
	public static Response applyCoupon(ApplyCouponPojo applyCouponPayload) {
		
		Response response = (Response) given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.headers("Authorization", "Bearer "+GlobalVariables.token)
				.body(applyCouponPayload)
				
				.when();
		
		return response;
		
		
		
	}

}
