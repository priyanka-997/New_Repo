package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ApplicablePaymentMethodsEndPoints;
import io.restassured.response.Response;

public class ApplicablePaymentMethodsTests {
	
	@Test(priority=10)
	public static void testApplicablePaymentMethods() {
		
		Response response=  ApplicablePaymentMethodsEndPoints.applicablePaymentMathods();
		
		response.then().log().all();
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("Payment method one is : " +response.jsonPath().getString("payment_methods[0].method_name")+ "Payment method two is " +response.jsonPath().getString("payment_methods[1].method_name")+ 
				"Payment method three is " +response.jsonPath().getString("payment_methods[2].method_name" ));
		
	}

}
