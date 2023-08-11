package loginPayloads;

public class LoginSendOtpPayload {
	
	/*static String mobileNumber;

public LoginSendOtp(String mobile_number) {
	
	setMobileNumber(mobile_number);
	 getMobileNumber();
}*/
	
	public static String getLoginPayload(String mobile_number){
        String SendOtpPayload="{\n" +
                "    \"mobile_number\": \""+mobile_number+"\"\n" +
                "}";
        return SendOtpPayload;
    }

    /*String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }*/





}
