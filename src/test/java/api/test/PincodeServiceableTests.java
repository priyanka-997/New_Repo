package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.GlobalVariables;
import api.endpoints.PincodeServiceableEndPoints;
import api.payload.PincodeServiceablePojo;
import io.restassured.response.Response;

public class PincodeServiceableTests {
	
	PincodeServiceablePojo pincodePayload;
	
	@BeforeClass()
	public void setupData() {
		
		pincodePayload= new PincodeServiceablePojo();
		
		pincodePayload.setPincode(201301);
		pincodePayload.setCategory("mobile");
		pincodePayload.setOrder_type("sell");
		
}

	@Test(priority=4)
	public void pincodeServiceable() {
		Response response= PincodeServiceableEndPoints.pincodeServiceable(pincodePayload);
		
		response.then().log().all();
	
		Assert.assertEquals(response.jsonPath().getString("message" ), "Pincode is serviceable");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		GlobalVariables.city = response.jsonPath().getString("details.pincode_city");
		System.out.println("Pincode city is " +GlobalVariables.city);
		

}}