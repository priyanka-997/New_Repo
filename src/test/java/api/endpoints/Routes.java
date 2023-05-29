package api.endpoints;

public class Routes {
	
	public static String base_url = "https://qarapiv2.recycledevice.com";
	
	//Login
	public static String login_post_url= base_url +"/api/login/send-otp";
	public static String resend_otp_post_url= base_url +"/api/login/resend-otp";
	public static String verify_otp_post_url= base_url +"/api/login/verify-otp";
	
	//Pin Code Serviceable
	public static String pincode_serviecable_post_url= base_url +"/api/pincode/check-servicability";
	
	//Detect Device
	public static String detect_device_post_url = base_url +"/api/order-place/detect-device";
	
	//List Variant Questions
	public static String list_variant_questions_post_url = base_url + "/api/order-place/list-variant-questions";
	
	//Get  Common Quote
	public static String get_common_quote_post_url = base_url +"/api/order-place/get-common-quote";
	
	//Get Address
	public static String getAddress_get_url = base_url +"/api/order-place/get-address";
	
	//Add Update Address
	public static String addUpdateAddress_post_url= base_url +"/api/order-place/add-update-address";
	
	//Applicable Payment Methods
	public static String applicablePaymentMethods_post_url =  base_url +"/api/order-place/applicable-payment-methods";
	
	//Verify IFSC
	public static String verifyIfsc_post_url = base_url +"/api/order-place/verify-ifsc";
	
	//Order Available Time slots
	public static String order_availableSlot_get_url = base_url +"/api/order-place/order-available-timeslots"; 
	
	//Apply Coupon
	public static String apply_coupon_post_url = base_url +"/api/order-place/apply-coupon";	
	
	//Place Order
	public static String place_order_post_url = base_url +"/api/order-place/place-order";
	
	//List Order
	public static String list_order_get_url = base_url +"/api/manage-order/list-orders/open";
	
	//Order Details
	public static String order_details_get_url = base_url +"/api/manage-order/orders-details/{order_id}";
	
	//Reschedule Order
	public static String reschedule_order_post_url = base_url +"/api/manage-order/reschedule-order";
	
	//Save Instructions
	public static String save_instructions_post_url = base_url +"/api/manage-order/save-order-instructions";
	
	//Change Order Payment method
	public static String change_payment_method_post_url = base_url +"/api/manage-order/change-order-payment-method";
	
	//Cancel Order
	public static String cancel_order_post_url = base_url +"/api/manage-order/cancel-order";
}
