package Utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.util.Properties;

public class ConfigRead {

	Properties prop;

	public ConfigRead() throws Exception {

		FileInputStream fis = new FileInputStream("./testData/config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getAmazonApp() {

		return prop.getProperty("appURL_Amazon");

	}

	public String getBrowser() {

		return prop.getProperty("browser");
		

	}
	
	public String getBrowserforsomeotherbrowser() {

		return prop.getProperty("browsername");

}
	
}
