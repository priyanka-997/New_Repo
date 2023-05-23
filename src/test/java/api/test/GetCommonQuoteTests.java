package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GetCommonQuoteEndPoints;
import api.endpoints.GlobalVariables;
import io.restassured.response.Response;

public class GetCommonQuoteTests {	
	
	
	public static String getCommonQuotePayload() {
		
		
		String quotePayload= "{\n"
		                       +"\"exchange_method\": \"sell\", "
		                 +"\n"
				 		+ " \"variant_id\": \""+GlobalVariables.variant_id+"\", "
				 				+ " \n" 
		                +"\"servicer_id\": \"187\", "
		                + "\n"
				 		+"\"variantSlug\": \""+GlobalVariables.variant_slug+"\", "
				 				+ "\n"
		                +"\"city\":\""+GlobalVariables.city+"\", "
		                		+ "\n"  
		              +"\"answer_sets[box]\":\"Y\","
		              + " \n" 
		              +"\"answer_sets[display_glass_broken]\":\"N\","
		              + " \n" 
		              +"\"answer_sets[touch_issue]\":\"S\","
		              + " \n" 
		              +"\"answer_sets[body_condition]\":\"N\","
		              + " \n" 
		              +"\"answer_sets[front_camera_faulty]\":\"Y\","
		              + " \n"
			         +"\"answer_sets[mobile_number]\":\""+GlobalVariables.mobileNumber+"\","
			         		+ " \n" 
			        +"\"answer_sets[back_camera_faulty]\":\"N\","
			        + " \n" 
			        +"\"answer_sets[ram]\":\"4.0\","
			        + " \n" 
			        +"\"answer_sets[internal_storage]\":\"64\","
			        + " \n" 
			        +"\"answer_sets[fingerprint_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[wifi_faulty]\":\"N\","
			        + " \n" 
			        +"\"answer_sets[bluetooth_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[speaker_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[mic_faulty]\":\"N\","
			        + " \n" 
			        +"\"answer_sets[proximity_sensor_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[charging_jack_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[volume_buttons_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[vibrator_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[cellular_faulty]\":\"N\", "
			        + "\n" 
			        +"\"answer_sets[device_imei_number]\":\"123456789012345\", "
			        + "\n" 
			        +"\"answer_sets[product_model_number]\":\"RMX1971\"}";
		

		
	/*String getCommonQuotePayload= "{\n" +"\"exchange_method\":"
			+"\"sell\", \n"+ "\"variant_id\": "
					+ "\"GlobalVariables.variant_id\",\n"+"\"servicer_id\":"
					+ "\"187\", \n"+"\"variantSlug\":"
		        +"\"GlobalVariables.variant_slug\", \n"+"\"city\":"
					+" \"GlobalVariables.city\", \n" +"\"answer_sets[box]\":"
		        +"\"Y\", \n" +"\"answer_sets[display_glass_broken]\":"				
		        +"\"N\", \n" +"\"answer_sets[touch_issue]\":"
		        +"\"S\", \n" +"\"answer_sets[body_condition]\":"
		        +"\"N\", \n" +"\"answer_sets[front_camera_faulty]\":"
		        +"\"Y\", \n" +"\"answer_sets[mobile_number]\":"
		        +"\"GlobalVariables.mobileNumber\", \n" +"\"answer_sets[back_camera_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[ram]\":"
		        +"\"4.0\", \n" +"\"answer_sets[internal_storage]\":"
		        +"\"64\", \n" +"\"answer_sets[fingerprint_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[wifi_faulty]\":" 
		        +"\"N\", \n" +"\"answer_sets[bluetooth_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[speaker_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[mic_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[proximity_sensor_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[charging_jack_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[volume_buttons_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[vibrator_faulty]\":" 
		        +"\"N\", \n" +"\"answer_sets[cellular_faulty]\":"
		        +"\"N\", \n" +"\"answer_sets[device_imei_number]\":"
		        +"\"123456789012345\", \n" +"\"answer_sets[product_model_number]\":"
		        +"\"RMX1971\"}"; */
			
			return quotePayload;
	}
	
	 

	@Test(priority=7)
	public void testGetCommonQuotes() {
									
		Response response = GetCommonQuoteEndPoints.getCommonQuote(getCommonQuotePayload());
				
				response.then().log().all();
				Assert.assertEquals(response.jsonPath().getString("message"), "Success");
				Assert.assertEquals(response.getStatusCode(), 200);
				
			GlobalVariables.quote_id = 	response.jsonPath().getString("quote_details.quote_id");
			System.out.println("Generated quote id is " +GlobalVariables.quote_id );			
		
		
	}
	
}
	
