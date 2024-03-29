package api.services;

import static io.restassured.RestAssured.given;


import java.util.Map;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiClient {
	
    public static String baseURL = "";
	
	 public ApiClient(String URI) {
	        RestAssured.baseURI = URI;
	        baseURL = URI.toString();
	    }
	 
	 /*public static  JsonPath rawToJson(io.restassured.response.Response r) {
	        String respon = r.asString();
	        JsonPath js = new JsonPath(respon);
	        return js;
	        
	 }*/
	 
	 public static void validateStatusCode(Response response, HttpStatusCode httpStatusCode) {
	        int statusCode = response.then().extract().statusCode();
	        Assert.assertEquals(statusCode, httpStatusCode.getCode(), "Verify Http Status Code::");
	    }

	 public static Response postRequestWithHeader(String param, Map<String, String> map, String body) {
	        
	        try {
	            Response resp = given()
	                    .log().all().with().contentType(ContentType.URLENC).headers(map).body(body).when().post(param).then()
	                    .log().all().extract().response();
	            
	            return resp;
	        } catch (Exception e) {
	            return given().log().all().with().contentType(ContentType.URLENC).headers(map)
	                    .body(body).when().post(param).then().log().all().extract().response();
	        }
	        
	        
	        

	    }	 
	 
}
