package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class NotificationListEndPoints {
	
	public static Response notificationList() {
		
		Response response = (Response) given()
				
				.headers("Authorization","Bearer " +GlobalVariables.token)
				.accept("*/*")
				
				.when()
				.get(Routes.notification_list_get_url);
		
		return response;
		
		
		
		
	}

}
