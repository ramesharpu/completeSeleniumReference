package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadPropertiesFile {
	Logger logger = Logger.getLogger(Base.class.getName());

	public Properties getAllProperties(String fileName){
		Properties prop = new Properties();
		InputStream file = null;
		try {
			file = new FileInputStream(getClass().getClassLoader().getResource(fileName).getPath());
			prop.load(file);
		}
		catch (FileNotFoundException e) {
			logger.error(e);
		}
		catch (IOException e) {
			logger.error(e);
		}
		return prop;
	}

	public String getSingleProperty(String fileName, String property){
		ReadPropertiesFile prop = new ReadPropertiesFile();
		return prop.getAllProperties(fileName).getProperty(property);
	}

}
