package api.test;

import org.testng.Assert;

import api.endpoints.NotificationListEndPoints;
import io.restassured.response.Response;

public class NotificationListTests {
	
	
public static void testNotificationList() {
	
	Response response = NotificationListEndPoints.notificationList();
	
	response.then().log().all();
	Assert.assertEquals(response.jsonPath().getString("message"), "Success");
	Assert.assertEquals(response.getStatusCode(), 200);
	
}

}
