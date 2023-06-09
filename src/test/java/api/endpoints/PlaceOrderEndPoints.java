package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;




public class PlaceOrderEndPoints {

	
	/*	static String date = GlobalVariables.date;	
   static  StringBuilder pickup_date ;
	
    public static StringBuilder reverseDate() {
		
	   /* String[] date1=date.split("-");  
	     

		for(String d:date1){  
	        StringBuilder date2=new StringBuilder(d);  
	        date2.reverse();  
	        //date2.toString();
			//pickup_date=String.join(pickup_date, "-");  
	        
	        pickup_date= date2.append("-");  
	    }
		return pickup_date;   */
	
	/*static String pickup_date;
	
	public static void reverseDate() {
		
		DateTimeFormatter fIn = DateTimeFormatter.ofPattern( "dd-mm-yyyy" , Locale.UK );  
		LocalDate ld = LocalDate.parse( GlobalVariables.date , fIn );
		
		DateTimeFormatter fOut = DateTimeFormatter.ofPattern( "yyyy-mm-dd" , Locale.UK );
		pickup_date = ld.format( fOut );
		
		System.out.println("Available formatted date is " +pickup_date);
		
	}*/
	/*static String pickup_date;
	
	public void reverseDate() {
		
		
		
		LocalDate ld = LocalDate.parse(GlobalVariables.date);
        pickup_date = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
                                  .format(ld);
        System.out.println("New formatted date is: " +pickup_date);
	}
	*/
	/*public void reverseDate() {
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String date = GlobalVariables.date;
	        LocalDate pickup_date = LocalDate.parse(date, formatter);
	        System.out.println("Formatted date is " +pickup_date);
		}*/
	
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
				.formParam("pickup_date", GlobalVariables.pickup_date)
				.formParam("pickup_timeslot", GlobalVariables.time_slot)
				
						
				
				.when()
		.post(Routes.place_order_post_url);
		
		return response;
		
		
	}

}
