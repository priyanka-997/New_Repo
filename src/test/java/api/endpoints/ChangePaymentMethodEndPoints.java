package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ChangePaymentMethodEndPoints {
	
	public static Response changePaymentMethod() {
		
		Response response =  (Response) given()
				
				.headers("Authorization","Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("order_id", GlobalVariables.order_id)
				.formParam("payment_method", "Bank Transfer / IMPS")
				.formParam("account_holder_name", "Test User")
				.formParam("bank_ifsc", "HDFC0005674")
				.formParam("bank_acc_number", "78987879797972")
				.formParam("bank_name", "BHDFC Bank")
				.formParam("branch", "HDFC Sector 48")
				.formParam("upi", "")
				
				
		.when();
		
		return response;		
		
	}

}
