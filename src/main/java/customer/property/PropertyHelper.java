package customer.property;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyHelper {

    public static String readProperty;
    private static Properties properties;


    synchronized public static Properties loadProperty() throws Exception {

        if (properties == null) {
            properties = new Properties();
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/propertyHelper.properties"));
            return properties;
        }
        return properties;
    }

    public static String readProperty(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream(System.getProperty("user.dir") + "/propertyHelper.properties");
            prop.load(input);

            return prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
