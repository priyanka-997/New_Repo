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
import loginPayloads.DetectDevicePayload;
import utils.BaseUtils;

public class DetectDevice extends BaseUtils {
	
	String model_number= "RMX1971";
	String internal_memory= "4";
	String internal_storage= "64";
	String cpu_model = "Qualcomm Technologies";
	
	
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
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
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
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
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
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "Success");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority = 4,enabled = false,testName = "Validations for Mandatory Header - Content_Type Correct")
    public void headerValidationForContentType_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "Success");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @Test(priority = 5,testName = "Validations for Mandatory Request body  -model number is Correct")
    public void RequestBodyValidationForModelNumber_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "Success");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =6 ,testName = "Validations for Mandatory Request body  -model number is blank/null")
    public void RequestBodyValidationForModelNumber_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header, DetectDevicePayload.getDetectDevicePayload("", internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.model_number[0]"), "Model Number is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =7 ,testName = "Validations for Mandatory Request body  -model number is invalid")
    public void RequestBodyValidationForModelNumber_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload("ABC", internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.BAD_REQUEST);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "No such device found");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 8,testName = "Validations for Mandatory Request body  -model number is Missing")
    public void RequestBodyValidationForModelNumber_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model).replace("\"model_number\": \""+model_number+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.model_number[0]"), "Model Number is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 9,testName = "Validations for Mandatory Request body  -internal memory is Correct")
    public void RequestBodyValidationForInternamMemory_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Success");
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =10 ,testName = "Validations for Mandatory Request body  -internal memory is blank/null")
    public void RequestBodyValidationForInternalMemory_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, "", internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.internal_memory[0]"), "Internal Memory is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =11 ,testName = "Validations for Mandatory Request body  -internal memory is invalid")
    public void RequestBodyValidationForInternalMemory_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, "abc", internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.BAD_REQUEST);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"), "No such device found");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 12,testName = "Validations for Mandatory Request body  -internal memory is Missing")
    public void RequestBodyValidationForInternalMemory_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model).replace("\"internal_memory\": \""+internal_memory+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.internal_memory[0]"), "Internal Memory is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority = 13,testName = "Validations for Mandatory Request body  -Internal storage is Correct")
    public void RequestBodyValidationForInternalStorage_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Success");
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =14 ,testName = "Validations for Mandatory Request body  -internal storage is blank/null")
    public void RequestBodyValidationForInternalStorage_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, "", cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.internal_storage[0]"),"Internal Storage is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =15 ,testName = "Validations for Mandatory Request body  -internal Storage is invalid")
    public void RequestBodyValidationForInternalStorage_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, "abc", cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.BAD_REQUEST);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"No such device found");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 16,testName = "Validations for Mandatory Request body  -internal  storage is Missing")
    public void RequestBodyValidationForInternalStorage_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model).replace("\"internal_storage\": \""+internal_storage+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.UNPROCESSABLE_ENTITY);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("errors.internal_storage[0]"),"Internal Storage is required");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

	
    @Test(priority = 17,testName = "Validations for Mandatory Request body  -cpu model is Correct")
    public void RequestBodyValidationForCpuModel_Is_Correct()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            
            JsonPath js= ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Success");
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority =18 ,testName = "Validations for Mandatory Request body  -cpu model is blank/null")
    public void RequestBodyValidationForCpuModel_Is_Blank()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, ""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Success");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test(priority =19 ,testName = "Validations for Mandatory Request body  -cpu model is invalid")
    public void RequestBodyValidationForCpuModel_Is_Invalid()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, "abc"));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Success");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 20,testName = "Validations for Mandatory Request body  -cpu model is Missing")
    public void RequestBodyValidationForCpuModel_Is_Missing()  {

        Map<String, String> header = new HashMap<>(genericHeaders);

        try{
            Response clientResponse = ApiClient.postRequestWithHeader(REQUEST_POST_SEND_OTP,header,DetectDevicePayload.getDetectDevicePayload(model_number, internal_memory, internal_storage, cpu_model).replace("\"cpu_model\": \""+cpu_model+"\"\n",""));
            ApiClient.validateStatusCode(clientResponse, HttpStatusCode.OK);
            JsonPath js=ApiClient.rawToJson(clientResponse);
            Assert.assertEquals(js.get("message"),"Success");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

	
	
	

}
