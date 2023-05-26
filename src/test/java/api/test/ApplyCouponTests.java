package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.ApplyCouponEndPoints;
import io.restassured.response.Response;

public class ApplyCouponTests {
	

	@Test(priority=13)
	public void testApplyCoupon() {
		
		Response response = ApplyCouponEndPoints.applyCoupon();
		
	    response.then().log().all();
	    
	    Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Coupon Applied");
		Assert.assertEquals(response.jsonPath().getString("coupon_value"), "196");
		
				
				
		
	}
	
	@Test(priority=14)
	public void testRevokeCoupon() {
		
		Response response = ApplyCouponEndPoints.revokeCoupon();
		
	    response.then().log().all();
	    
	    Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Coupon Removed Successfully");
		Assert.assertEquals(response.jsonPath().getString("coupon_value"), "0");
		
				
				
		
	}
}
