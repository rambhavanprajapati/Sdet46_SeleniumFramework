package com.tyss.genericUtility.enums;

public enum ExcelSheet {
	
	ADMIN("admin"), USER("user");
	
	String key;
	
	/**
	 * This method is used to initialize the key
	 * @param key
	 */
	private ExcelSheet(String key)
	{
		this.key=key;
	}
	
	/**
	 * This method is used to get the key
	 * @return
	 */
	public String getSheetName()
	{
		return key;
	}

}
