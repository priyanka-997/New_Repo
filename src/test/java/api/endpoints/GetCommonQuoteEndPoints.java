package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetCommonQuoteEndPoints {

public static Response getCommonQuote() {
		
	Response response= 	(Response) given()
			
			.headers("Authorization", "Bearer " +GlobalVariables.token )
			
			.contentType("application/x-www-form-urlencoded; charset=utf-8")
			.accept("*/*")
		
			.formParam("exchange_method","sell")
			.formParam("variant_id", GlobalVariables.variant_id)
			.formParam("servicer_id", "187")
			.formParam("variant_slug", GlobalVariables.variant_slug)
			.formParam("city", GlobalVariables.city)
			.formParam("answer_sets[box]", "Y")
			.formParam("answer_sets[display_glass_broken]", "N")
			.formParam("answer_sets[touch_issue]", "S")
			.formParam("answer_sets[body_condition]", "N")
			.formParam("answer_sets[front_camera_faulty]", "Y")
			.formParam("answer_sets[mobile_number]", GlobalVariables.mobileNumber)
			.formParam("answer_sets[back_camera_faulty]", "N")
			.formParam("answer_sets[ram]", "4.0")
			.formParam("answer_sets[product_model_number]", "RMX1971")
			.formParam("answer_sets[internal_storage]", "64")
			.formParam("answer_sets[fingerprint_faulty]", "N")
			.formParam("answer_sets[wifi_faulty]", "N")
			.formParam("answer_sets[bluetooth_faulty]", "N")
			.formParam("answer_sets[speaker_faulty]", "N")
			.formParam("answer_sets[mic_faulty]", "N")
			.formParam("answer_sets[proximity_sensor_faulty]", "N")
			.formParam("answer_sets[charging_jack_faulty]", "N")
			.formParam("answer_sets[volume_buttons_faulty]]", "N")
			.formParam("answer_sets[vibrator_faulty]", "N")
			.formParam("answer_sets[cellular_faulty]", "N")
			.formParam("answer_sets[device_imei_number]", "N")

			.when()
			.post(Routes.get_common_quote_post_url);
	
	return response;

}
			
	
	
	

 
}
