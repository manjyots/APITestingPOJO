package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties prop = new Properties();

    public PropertiesReader() {
        try {

            String propertiesFilePath = "test.properties";
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);

            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getContentType() {
        String contentType = System.getProperty("contentType");
        if (null == contentType) contentType = "application/json";
        return contentType;

    }

     public String getBaseUrl() {
        return prop.getProperty("base-url");
    }
}

