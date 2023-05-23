package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GetAddressEndPoints;
import api.endpoints.GlobalVariables;
import io.restassured.response.Response;

public class GetAddressTests {
	
	@Test(priority=8)
	public void testGetAddress() {
		
		Response response = GetAddressEndPoints.address();
		response.then().log().all();
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		GlobalVariables.homeAddressID =response.jsonPath().getString("addresses[0].party_address_id");
		System.out.println("Home address id is " +GlobalVariables.homeAddressID);
		GlobalVariables.officeAddressID =response.jsonPath().getString("addresses[1].party_address_id");
		System.out.println("Office address id is " +GlobalVariables.officeAddressID);
		
	}

}
