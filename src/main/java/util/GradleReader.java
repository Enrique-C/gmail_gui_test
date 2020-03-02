package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GradleReader {

    public static String readBrowser() {
        Properties prop = new Properties();
        InputStream input;

        try {
            input = new FileInputStream("gradle.properties");
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty("browser");
    }
}
