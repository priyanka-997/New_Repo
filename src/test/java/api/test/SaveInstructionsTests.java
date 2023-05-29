package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.SaveInstructionsEndPoints;
import io.restassured.response.Response;

public class SaveInstructionsTests {

	@Test(priority=19)
	public static void testSaveInstructions() {
		
		Response response = SaveInstructionsEndPoints.saveInstructions();
		
		response.then().log().all();
		Assert.assertEquals(response.jsonPath().getString("message"), "Instructions have been saved");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
	}
}
