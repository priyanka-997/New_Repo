package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.github.javafaker.Faker;

public class UpdateProfileEndPoints {
	
	public static Response updateProfile() {
		
	Faker faker= new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("whatsapp_no", faker.phoneNumber().cellPhone());
		data.put("gender", "Male");
		data.put("whatsapp_active", "Y");
	    data.put("name", faker.name().fullName());
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		System.out.println("Data is " +data);
		
		Response response = (Response) given()
				
			
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				.body(data.toString())
				

				.when()
		        .post(Routes.update_profile_post_url);
	
		return response;
			
	}
	
}
