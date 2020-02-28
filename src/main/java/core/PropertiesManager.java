package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    // Constant variable of the key imageMagick path.
    private static final String TEST_BROWSER = "browser";

    // Properties type variable.
    private static Properties properties;

    // InputStream type variable.
    private InputStream inputPath;

    // Constant variable to get gradle.properties file.
    private static final String APPLICATION_PROPERTIES = "gradle.properties";

    /**
     * Initializes properties and inputPath. Also load the inputPath in properties.
     */
    public PropertiesManager() {
        properties = new Properties();
        inputPath = PropertiesManager.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES);
        try {
            properties.load(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets Image Magick's path.
     * @return Image Magick's Path.
     */
    public String getBrowser() {
        return properties.getProperty(TEST_BROWSER);
    }
}
