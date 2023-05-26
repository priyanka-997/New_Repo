package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PlaceOrderEndPoints {
	
	
	public static Response placeOrder() {
		
		Response response = given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("order_src", "android")
				.formParam("quote_id", GlobalVariables.quote_id)
				.formParam("address_id", GlobalVariables.officeAddressID)
				.formParam("mobile_number", GlobalVariables.mobileNumber)
				.formParam("payment_method", GlobalVariables.payment_method)
				.formParam("voucher_id", GlobalVariables.voucher_id)
				.formParam("paytm_no", "")
				.formParam("upi", "")
				.formParam("bank_acc_name", "")
				.formParam("bank_ifsc", "")
				.formParam("bank_acc_no", "")
				.formParam("pickup_date", GlobalVariables.date)
				.formParam("pickup_timeslot", GlobalVariables.time_slot)
						
				
				.when()
		.post(Routes.place_order_post_url);
		
		return response;
		
		
	}

}
