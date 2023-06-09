package api.test;

//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.GlobalVariables;
import api.endpoints.SupportQuestionsEndPoints;
import io.restassured.response.Response;

public class SupportQuestionsTests {
	
	@Test(priority=28)
	public void testSupportQuestions() {
		
		Response response = SupportQuestionsEndPoints.supportQuestionsEndPoint();
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.jsonPath().getString("message"), "Success");
		
		Assert.assertEquals(response.jsonPath().getString("questions[0].question_description"), "Contact Issue");
		Assert.assertEquals(response.jsonPath().getString("questions[0].answers[0].ques_answer_description[0]"), "I am not able to contact account manager");
		
		GlobalVariables.ticket_category= response.jsonPath().getString("questions[2].question_description");
		GlobalVariables.ticket_subcategory= response.jsonPath().getString("questions[2].answers[0].ques_answer_description[0]");
	}}