package login;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.services.ApiClient;
import api.services.HttpStatusCode;
import automationUtils.GlobalVariables;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import loginPayloads.PincodeServicablePayload;
import utils.BaseUtils;

public class PincodeServicable extends BaseUtils{

	String pincode= "201301";
	String order_type= "sell";
	String category= "mobile";
	
	
	Map<String, String> genericHeaders = new HashMap<>();
	
	@BeforeMethod
    public void before_method()
    {
         genericHeaders.put("Content_Type", GlobalVariables.Content_Type);

    }
	
	// Content_Type
    @Test(priority = 1,testName = "Validations for Mandatory Header - Content_Type Missing")
    public void headerValidationForContentType_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);
        header.remove("Content_Type");

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


	@Test(priority = 2,testName = "Validations for Mandatory Header - Content_Type Invalid")
    public void headerValidationForContentType_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);
        header.replace("Content_Type","application");

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test(priority = 3,enabled = false,testName = "Validations for Mandatory Header - Content_Type Blank/null")
    public void headerValidationForContentType_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);
        header.replace("Content_Type","");

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "Pincode is serviceable");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority = 4,enabled = false,testName = "Validations for Mandatory Header - Content_Type Correct")
    public void headerValidationForContentType_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "Pincode is serviceable");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @Test(priority = 5,testName = "Validations for Mandatory Request body  -pincode is Correct")
    public void RequestBodyValidationForPinCode_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Pincode is serviceable");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =6 ,testName = "Validations for Mandatory Request body  -pincode is blank/null")
    public void RequestBodyValidationForPinCode_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, PincodeServicablePayload.getPincodeServicablePayload("", order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.pincode[0]"), "The pincode field is required.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =7 ,testName = "Validations for Mandatory Request body  -pincode is invalid")
    public void RequestBodyValidationForPinCode_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload("2013", order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "Pincode is not serviceable");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 8,testName = "Validations for Mandatory Request body  -pincode is Missing")
    public void RequestBodyValidationForPinCode_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category).replace("\"pincode\": \""+pincode+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.pincode[0]"), "The pincode field is required.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 9,testName = "Validations for Mandatory Request body  -order type is Correct")
    public void RequestBodyValidationForOrderType_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Pincode is serviceable");
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =10 ,testName = "Validations for Mandatory Request body  -order type is blank/null")
    public void RequestBodyValidationForOrderType_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, "", category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.order_type[0]"), "The order type field is required.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =11 ,testName = "Validations for Mandatory Request body  -order type is invalid")
    public void RequestBodyValidationForOrderType_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, "465", category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.order_type[0]"), "The selected order type is invalid.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 12,testName = "Validations for Mandatory Request body  -order type is Missing")
    public void RequestBodyValidationForOrderType_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category).replace("\"order_type\": \""+order_type+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.order_type[0]"), "The order type field is required.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority = 13,testName = "Validations for Mandatory Request body  -Category is Correct")
    public void RequestBodyValidationForCategory_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Pincode is serviceable");
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =14 ,testName = "Validations for Mandatory Request body  -Category is blank/null")
    public void RequestBodyValidationForCategory_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, ""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Pincode is serviceable");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =15 ,testName = "Validations for Mandatory Request body  -Category is invalid")
    public void RequestBodyValidationForCategory_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, "425"));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Pincode is not serviceable");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 16,testName = "Validations for Mandatory Request body  -Category is Missing")
    public void RequestBodyValidationForCategory_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,PincodeServicablePayload.getPincodeServicablePayload(pincode, order_type, category).replace("\"category\": \""+category+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Pincode is serviceable");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}


