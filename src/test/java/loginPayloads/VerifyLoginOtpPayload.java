package loginPayloads;


public class VerifyLoginOtpPayload {

	
	public static String getVerifyLoginOtpPayload(String mobile_number, String Otp) {
		
        String verifyLoginOtpPayload =  "{\n" +
        "\"mobile_number\":\"mobile_number\",\n" +
        "\"Otp\": \"Otp\",\n" +
        "    }\n" +
       "}";
        
        return verifyLoginOtpPayload;
    }

}

