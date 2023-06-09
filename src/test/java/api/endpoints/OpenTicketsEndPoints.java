package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OpenTicketsEndPoints {

	public static Response openTicket() {
		
		Response response = (Response) given()
				
				.headers("Authoriation","Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
								
				.when()
		        .get(Routes.open_ticket_get_url)  ;
		
		return response;
		
	}
	
}
