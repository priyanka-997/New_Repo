package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.GlobalVariables;
import api.endpoints.PincodeServiceableEndPoints;
import io.restassured.response.Response;

public class PincodeServiceableTests {


	@Test(priority=4)
	public void pincodeServiceable() {
		Response response= PincodeServiceableEndPoints.pincodeServiceable();
		
		response.then().log().all();
	
		Assert.assertEquals(response.jsonPath().getString("message" ), "Pincode is serviceable");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		GlobalVariables.city = response.jsonPath().getString("details.pincode_city");
		System.out.println("Pincode city is " +GlobalVariables.city);
		

}}