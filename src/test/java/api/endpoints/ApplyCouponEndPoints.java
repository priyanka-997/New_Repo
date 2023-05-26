package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class ApplyCouponEndPoints {
	
	public static Response applyCoupon() {
		
		Response response = (Response) given()
				
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.headers("Authorization", "Bearer "+GlobalVariables.token)
				
				.formParam("quote_id", "4682082")
				.formParam("code", "WELCOME5")
				.formParam("action", "apply")
				
				.when()
				.post(Routes.apply_coupon_post_url);
		
		return response;
		
		
		
	}
	
public static Response revokeCoupon() {
		
		Response response = (Response) given()
				
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.headers("Authorization", "Bearer "+GlobalVariables.token)
				
				.formParam("quote_id", "4682082")
				.formParam("code", "WELCOME5")
				.formParam("action", "revoke")
				
				.when()
				.post(Routes.apply_coupon_post_url);
		
		return response;
		
		
		
	}

}
