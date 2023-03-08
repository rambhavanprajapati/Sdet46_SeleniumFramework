package com.tyss.genericUtility.externalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.tyss.genericUtility.enums.PropertyKey;

/**
 * This class contains generic methods related to property file
 * @author Zero Touch
 *
 */
public class PropertyFileUtility {
	
	private FileOutputStream fosProperty;
	private FileInputStream fisProperty;
	private Properties prop;
	  
	/**
	 * This constructor is used to create object for class
	 */
	public PropertyFileUtility()
	{
		
	}
	
	/**
	 * This constructor will initialize the property file
	 * @param filePath
	 */
	public PropertyFileUtility(String filePath)
	{
		initializePropertyFile(filePath);
	}
	
	/**
	 * This method will initialize the path of property file
	 * @param filePath
	 */
	@Deprecated
	public void initializePropertyFile(String filePath)
	{
		try {
			fisProperty = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fisProperty);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fisProperty.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This generic method will read the key from property file and return the value 
	 * @param string
	 * @return
	 */
	public String getPropertyData(PropertyKey key)
	{
		String keyString = key.name().toLowerCase();
		String value = prop.getProperty(keyString,"please give proper key'"+keyString+"'").trim();
		return value;
	}
	
	/**
	 * This method will store the path of property file
	 * @param filePath
	 */
	public void storePropertyFile(String filePath)
	{
		try {
			fosProperty = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.store(fosProperty,"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This generic method will store the key and value into property file
	 * @param key
	 * @param value
	 * @return
	 */
	public String setPropertyData(String key, String value)
	{
		prop.setProperty(key, value);
		return value;
	}

}
