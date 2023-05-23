package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class GetCommonQuoteEndPoints {

public static Response getCommonQuote(String getCommonQuotePayload) {
		
	Response response= 	(Response) given()
			
			.headers("Authorization", "Bearer " +GlobalVariables.token )
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(getCommonQuotePayload)
			
	
	
	.when()
	.post(Routes.get_common_quote_post_url);
	
	return response;

}

 
}
