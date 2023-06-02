package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.NotificationCountEndPoints;
import io.restassured.response.Response;

public class NotificationCountTests {
	

	@Test(priority=26)
	public static void testNotificationCount() {
		
		Response response = NotificationCountEndPoints.notificationCount();
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		System.out.println("count is " +response.jsonPath().getString("notifications_count"));
		
		
	}

}
