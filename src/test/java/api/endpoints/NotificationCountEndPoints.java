package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class NotificationCountEndPoints {
	
	public static Response notificationCount() {
		
		Response response = (Response) given()
				
			.headers("Authorization", "Bearer " +GlobalVariables.token)
			.accept("*/*")
				
				.when()
				.get(Routes.notification_count_get_url);
		
		return response;
		
		
		
		
	}

}
