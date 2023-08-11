package loginPayloads;

public class PincodeServicablePayload {
	
public static String getPincodeServicablePayload(String pincode, String order_type, String category ) {
		
        String pincodeServicablePayload =  "{\n" +
        "\"pincode\":\"pincode\",\n" +
        "\"order_type\": \"order_type\",\n" +
        "\"category\": \"category\",\n" +
        "    }\n" +
       "}";
        
        return pincodeServicablePayload;
    }

}
