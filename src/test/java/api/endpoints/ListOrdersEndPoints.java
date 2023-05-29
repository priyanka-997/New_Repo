package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ListOrdersEndPoints {
	
	
public static Response listOrders() {
	
	Response response = (Response) given()
			
			.headers("Authorization", "Bearer " +GlobalVariables.token)
			.accept("*/*")
					
			.when()
			.get(Routes.list_order_get_url);
	
	return response;
	
	
}

}
