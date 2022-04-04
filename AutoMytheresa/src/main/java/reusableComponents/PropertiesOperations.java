package reusableComponents;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {

	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) throws Exception {
		String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);
		String env = prop.get(key).toString();
		if (StringUtils.isEmpty(env)) {
			throw new Exception("No value Specified for the key: " + key + " in properties file");
		}
		return env;
	}
}
