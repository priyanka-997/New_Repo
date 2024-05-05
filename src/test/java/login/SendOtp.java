package login;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import api.services.ApiClient;
import api.services.HttpStatusCode;
import automationUtils.GlobalVariables;
import customer.property.DataProvider;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import loginPayloads.LoginSendOtpPayload;
import utils.BaseUtils;

public class SendOtp extends BaseUtils{
	
	String mobile_number="7905120105";
	
	Map<String, String> genericHeaders = new HashMap<>();
	
	Map<String, String> testValue = getTestData();

	
	@BeforeMethod
    public void before_method()
    {
        
        genericHeaders.put("Content-Type", testValue.get("Content-Type"));
        

    }

	 // Content_Type
    @Test(priority = 1,testName = "Validations for Mandatory Header - Content_Type Missing", enabled= true)
    public void TC_1_headerValidationForContentType_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);
        header.remove("Content-Type");

        try{
        	Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header, mobile_number);
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 2,testName = "Validations for Mandatory Header - Content_Type Invalid", enabled= true)
    public void TC_2_headerValidationForContentType_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);
        header.replace("Content-Type","application");

        try{
            Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header,mobile_number);
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test(priority = 3,testName = "Validations for Mandatory Header - Content_Type Blank/null", enabled= true)
    public void TC_3_headerValidationForContentType_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);
        header.replace("Content-Type","");

       try{
    	   
    	   System.out.println("End point is " + REQUEST_POST_SEND_OTP);
    	   
    	   System.out.println("Headers are " +header);
    	   
    	   System.out.println("Payload is" + mobile_number);
    	   
    	   
            Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header,mobile_number);
            System.out.println("Response is " +clientResponse.asString());
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            
            
          JsonPath js=ApiClient.rawToJson(clientResponse);
             
          Assert.assertEquals(js.getString("message"), "OTP Sent to entered mobile number");
          System.out.println("Response of this test case is " +js.getString("message"));
       }
        catch(Exception e){
           e.printStackTrace();
      }
   }
    
    @Test(priority = 4,testName = "Validations for Mandatory Header - Content_Type Correct", enabled= true)
    public void TC_4_headerValidationForContentType_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);
        

        try{
        	
        	System.out.println("End point is " + REQUEST_POST_SEND_OTP);
     	   
     	   System.out.println("Headers are " +header);
     	   
     	   
            Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header,mobile_number);
            System.out.println("Response is " +clientResponse.asString());
            
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.getString("message"), "OTP Sent to entered mobile number");
            System.out.println("Response of this test case is " +js.getString("message"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @Test(priority = 5,testName = "Validations for Mandatory Request body  -mobile number is Correct", enabled= true)
    public void TC_5_RequestBodyValidationForMobileNumber_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header,mobile_number);
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.getString("message"),"OTP Sent to entered mobile number");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =6 ,testName = "Validations for Mandatory Request body  -mobile number is blank/null", enabled= true)
    public void TC_6_RequestBodyValidationForMobileNumber_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header, "");
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.getString("errors.mobile_number[0]"), "Mobile number is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =7 ,testName = "Validations for Mandatory Request body  -mobile number is invalid", enabled= true)
    public void TC_7_RequestBodyValidationForMobileNumber_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header,"790512");
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.getString("errors.mobile_number[0]"), "Please enter valid mobile number");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 8,testName = "Validations for Mandatory Request body  -mobile number is Missing", enabled= false)
    public void TC_8_RequestBodyValidationForMobileNumber_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postFormDataSendOtp(REQUEST_POST_SEND_OTP,header,mobile_number.replace("\"mobilenumber\": \""+mobile_number+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.getString("errors.mobile_number[0]"), "Mobile number is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
