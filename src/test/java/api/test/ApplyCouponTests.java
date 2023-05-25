package api.test;

import api.payload.ApplyCouponPojo;

public class ApplyCouponTests {
	
	 ApplyCouponPojo applyCouponPayload;
	
	public void setupData() {
		
		applyCouponPayload = new ApplyCouponPojo();
		
		applyCouponPayload.setAction("Apply");
		
		
	}

}
