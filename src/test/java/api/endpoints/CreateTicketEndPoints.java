package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateTicketEndPoints {

	public static Response createTicket() {
		
		Response response = (Response) given()
				
				.headers("Authorization", "Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
				
				.formParam("ticket_category", GlobalVariables.ticket_category)
				.formParam("ticket_subcategory", GlobalVariables.ticket_subcategory)
				.formParam("ticket_category", "testing")
				.formParam("ticket_category", "general_7905120105")
				
				.when()
				
				.post(Routes.create_ticket_post_url);
		
		return response;
		
		
	}
	
}
