package api.test;



import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ApplyCouponEndPoints;
import api.payload.ApplyCouponPojo;
import io.restassured.response.Response;

public class ApplyCouponTests {
	
	 ApplyCouponPojo applyCouponPayload;
	
	public void setupData() {
		
		applyCouponPayload = new ApplyCouponPojo();
		
		applyCouponPayload.setAction("Apply");
		applyCouponPayload.setCode("WELCOME5");
		applyCouponPayload.setQuote_id(4682080);
		
		
	}
	@Test(priority=13)
	public void testApplyCoupon() {
		
		Response response = ApplyCouponEndPoints.applyCoupon(applyCouponPayload);
		
	    response.then().log().all();
	    
	    Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.jsonPath().getString("message"), "Coupon Applied");
		Assert.assertEquals(response.jsonPath().getString("coupon_value"), "196");
		
				
				
		
	}
}
