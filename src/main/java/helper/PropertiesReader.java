package helper;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties;

    // to load data from .properties files
    public static void propertiesReader() {

        properties = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/testData.properties" );
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){

        if(properties == null)
            propertiesReader();

        return properties.getProperty(key);

    }

}
