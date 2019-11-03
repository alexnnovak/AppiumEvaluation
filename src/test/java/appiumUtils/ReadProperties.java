package appiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {


    public String readProperties(String propName){
        InputStream file = getClass().getClassLoader().getResourceAsStream("capabilities.properties");
        Properties properties = new Properties();
        try {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propName);
    }

}
