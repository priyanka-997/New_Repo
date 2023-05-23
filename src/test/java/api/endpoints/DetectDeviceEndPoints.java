package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.DetectDevicePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DetectDeviceEndPoints {
	
	public static Response detectDevice(DetectDevicePojo detectDevicePayload) {
		
	Response response= 	given()
			
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(detectDevicePayload)
		
		
		.when()
		.post(Routes.detect_device_post_url);
		
	return response;
	
	}

}