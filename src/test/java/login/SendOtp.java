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
import loginPayloads.LoginSendOtp;
import utils.BaseUtils;

public class SendOtp extends BaseUtils{
	
	String mobile_number="7905120105";
	
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
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, LoginSendOtp.getLoginPayload(mobile_number));
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
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,LoginSendOtp.getLoginPayload(mobile_number));
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
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,LoginSendOtp.getLoginPayload(mobile_number));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "OTP Sent to entered mobile number");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority = 4,enabled = false,testName = "Validations for Mandatory Header - Content_Type Correct")
    public void headerValidationForContentType_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,LoginSendOtp.getLoginPayload(mobile_number));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "OTP Sent to entered mobile number");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @Test(priority = 5,testName = "Validations for Mandatory Request body  -mobile number is Correct")
    public void RequestBodyValidationForMobileNumber_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,LoginSendOtp.getLoginPayload(mobile_number));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.getBoolean("message"),"OTP Sent to entered mobile number");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =6 ,testName = "Validations for Mandatory Request body  -mobile number is blank/null")
    public void RequestBodyValidationForMobileNumber_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,LoginSendOtp.getLoginPayload(""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.mobile_number[0]"), "Mobile number is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =7 ,testName = "Validations for Mandatory Request body  -mobile number is invalid")
    public void RequestBodyValidationForMobileNumber_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,LoginSendOtp.getLoginPayload("790512"));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.mobile_number[0]"), "Mobile number is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 8,testName = "Validations for Mandatory Request body  -mobile number is Missing")
    public void RequestBodyValidationForMobileNumber_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,LoginSendOtp.getLoginPayload(mobile_number).replace("\"mobilenumber\": \""+mobile_number+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.mobile_number[0]"), "Mobile number is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
