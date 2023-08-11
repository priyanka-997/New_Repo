package loginPayloads;

public class DetectDevicePayload {
	
	
public static String getDetectDevicePayload(String model_number, String internal_memory, String internal_storage, String cpu_model ) {
		
        String detectDevicePayload =  "{\n" +
        "\"model_number\":\"model_number\",\n" +
        "\"internal_memory\": \"internal_memory\",\n" +
        "\"internal_storage\": \"internal_storage\",\n" +
        "\"cpu_model\": \"cpu_model\",\n" +
        "    }\n" +
       "}";
        
        return detectDevicePayload;
    }

}
