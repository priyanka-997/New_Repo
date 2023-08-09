package utils;

import java.io.File;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import api.services.ApiClient;
import automationUtils.GlobalVariables;
import customer.property.DataProvider;
import customer.property.PropertyHelper;


public class BaseUtils {
	
	protected static String REQUEST_POST_SEND_OTP;
	protected static String REQUEST_POST_RESEND_OTP;
	protected static String REQUEST_POST_VERIFY_LOGIN_OTP;
    
    protected static ApiClient apiClient;
   

    @BeforeSuite
    public void beforeSuite(ITestContext context) throws Exception {
        
        DataProvider data = new DataProvider();
        data.loadDataMap();
        Map<String, String> testdata = data.getDataMap();
        
       	
            if (PropertyHelper.readProperty("env").equalsIgnoreCase("qa")) {
                String url = "";
                if (System.getProperty("baseUrl") != null)
                    url = System.getProperty("baseUrl");
                else
                    url = testdata.get("baseUrl");
               // apiClient = new ApiClient(url);
              //  GlobalVariables.APIbaseURL = url;
              //  GlobalVariables.apiKey = testdata.get("apiKey");

                
        }
	
	
	
	REQUEST_POST_SEND_OTP = PropertyHelper.readProperty("REQUEST_POST_SEND_OTP");
	REQUEST_POST_RESEND_OTP = PropertyHelper.readProperty("REQUEST_POST_RESEND_OTP");
	REQUEST_POST_VERIFY_LOGIN_OTP = PropertyHelper.readProperty("REQUEST_POST_VERIFY_LOGIN_OTP");

}
}