package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GlobalVariables;
import api.endpoints.OrderDetailsEndPoints;
import io.restassured.response.Response;

public class OrderDetailsTests {
	
	int Order_ID;
	static int order_Id = GlobalVariables.order_id;
	
	
	@Test(priority=17)
	public static void testOrderDetails() {
		
		Response response = OrderDetailsEndPoints.orderDeatails();
		
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("details[0].order_status"), "Order Placed");
		
		int Order_ID = response.jsonPath().getInt("details[0].order_id");
		System.out.println("Order id is " +Order_ID);
		
			/*if (Order_ID= order_Id)
			
			{
				System.out.println("Order_ID");
			} 
			else {
		
				System.out.println("Order ids are not matching");
		}
*/
	}
}