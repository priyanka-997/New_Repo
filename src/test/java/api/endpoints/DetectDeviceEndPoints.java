package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class DetectDeviceEndPoints {
	
	public static Response detectDevice() {
		
	Response response= 	given()
			
		.contentType("application/x-www-form-urlencoded")
		.accept("*/*")
		
		.formParam("model_number", "RMX1971")
		.formParam("internal_memory", "4")
		.formParam("internal_storage", "64")
		.formParam("cpu_model", "Qualcomm Technologies")
		
		.when()
		.post(Routes.detect_device_post_url);
		
	return response;
	
	}

}