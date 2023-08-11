package loginPayloads;

public class LoginResendOtpPayload {
	
	/*static String mobileNumber;

	public LoginResendOtp(String mobile_number) {
		
		setMobileNumber(mobile_number);
		 getMobileNumber();
	}*/
		
		public static String getResendPayload(String mobile_number){
	        String ResendOtpPayload="{\n" +
	                "    \"mobile_number\": \""+mobile_number+"\"\n" +
	                "}";
	        return ResendOtpPayload;
	    }

	  /*  String getMobileNumber() {
	        return mobileNumber;
	    }
	    public void setMobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	    }*/





	}
