package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class PlaceOrderEndPoints {
	
	static String date = GlobalVariables.date;	
   static  String pickup_date = "";
	
	public static String reverseDate() {
		
	    String[] date1=date.split("-");  
	     

		for(String d:date1){  
	        StringBuilder date2=new StringBuilder(d);  
	        date2.reverse();  
	        date2.toString();
			pickup_date=String.join(pickup_date, "-");  
	    }
		return pickup_date;
		
	      
	}
	
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
				.formParam("pickup_date", pickup_date)
				.formParam("pickup_timeslot", GlobalVariables.time_slot)
				
						
				
				.when()
		.post(Routes.place_order_post_url);
		
		return response;
		
		
	}

}
