package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class ClosedTicketsEndPoints {

public static Response closedTickets() {
		
		Response response = (Response) given()
				
				.headers("Authoriation","Bearer " +GlobalVariables.token)
				.contentType("application/x-www-form-urlencoded")
				.accept("*/*")
								
				.when()
		        .get(Routes.closed_tickst_get_url)  ;
		
		return response;
		
	}
	
	
}
