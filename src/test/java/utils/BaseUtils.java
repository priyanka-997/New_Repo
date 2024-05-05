package utils;


import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import api.services.ApiClient;
import customer.property.DataProvider;
import customer.property.PropertyHelper;


public class BaseUtils {
	
	protected static String REQUEST_POST_SEND_OTP;
	protected static String REQUEST_POST_RESEND_OTP;
	protected static String REQUEST_POST_VERIFY_LOGIN_OTP;
	protected static String REQUEST_POST_PINCODE_SERVICABLE;
	protected static String REQUEST_POST_DETECT_DEVICE;
    
    protected static ApiClient apiClient;
    Map<String, String> testdata;
   

    @BeforeSuite
    public void beforeSuite(ITestContext context) throws Exception {
        
    	testdata = getTestData();
       	
            if (testdata.get("env").equalsIgnoreCase("qa")) {
                String url = testdata.get("baseUrlQa");
               apiClient = new ApiClient(url);
                
        }
            
	
	REQUEST_POST_SEND_OTP = testdata.get("REQUEST_POST_SEND_OTP");
	REQUEST_POST_RESEND_OTP = testdata.get("REQUEST_POST_RESEND_OTP");
	REQUEST_POST_VERIFY_LOGIN_OTP = testdata.get("REQUEST_POST_VERIFY_LOGIN_OTP");
	REQUEST_POST_PINCODE_SERVICABLE= testdata.get("REQUEST_POST_PINCODE_SERVICABLE");
	REQUEST_POST_DETECT_DEVICE= testdata.get("REQUEST_POST_DETECT_DEVICE");
	
	
}
    
    public Map<String, String>  getTestData() {
    	DataProvider data = new DataProvider();
        data.loadDataMap();
        Map<String, String> td = data.getDataMap();
        System.out.println("Value of td is " +td);
        return td;
        
       
    	
    }
}