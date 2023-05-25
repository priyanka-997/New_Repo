package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class LoginEndPoints {
	
	public static Response Login(){
		
		Response response= 	given()
				
				.contentType("application/x-www-form-urlencoded; charset=utf-8")
				.accept("*/*")
				
			.formParam("mobile_number", "7905120105")
			
			.when()
			.post(Routes.login_post_url);
		
		return response;
					
		}
					
		public static Response ResendOtp(){
			
			Response response= 	given()
					
					.contentType("application/x-www-form-urlencoded; charset=utf-8")
					.accept("*/*")
					
				.formParam("mobile_number", "7905120105")
							
				.when()
				.post(Routes.resend_otp_post_url);
			
			return response;	
	}
				
	public static Response verifyOtp(){
		
		Response response= 	given()
				
				.contentType("application/x-www-form-urlencoded; charset=utf-8")
				.accept("*/*")
				
			.formParam("mobile_number", "7905120105")
			.formParam("otp", 1111)
					
					.when()
				    .post(Routes.verify_otp_post_url);				
			
			return response;	
	}

	
	}
		


