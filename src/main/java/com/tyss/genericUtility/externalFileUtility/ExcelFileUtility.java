package com.tyss.genericUtility.externalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to excel sheet
 * @author Zero Touch
 *
 */
public class ExcelFileUtility {
	FileInputStream fisExcel;
	FileOutputStream fosExcel;
	Workbook wb;
	DataFormatter df = new DataFormatter();

	/**
	 * This is the default constructor
	 */
	public ExcelFileUtility()
	{
		
	}
	
	/**
	 * This constructor used to initialize the path of excel sheet
	 * @param fileNme
	 */
	public ExcelFileUtility(String filePath)
	{
		intializeExcelFile(filePath);
	}
	
	/**
	 * This method will initialize the path of excel file
	 */
	@Deprecated
	public void intializeExcelFile(String filePath)
	{
		try {
			fisExcel = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will take the value from excel sheet for respective sheet name
	 * row number and cell number and return value
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String fetchDataFromExcelUsingIndex(String sheetName, int rowNum, int cellNum)
	{
		Sheet sheet = wb.getSheet(sheetName);
		String value = df.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		return value;
	}

	/**
	 * This method will take sheet name and print all value
	 * @param sheetName
	 * @return 
	 * @return 
	 */
	public String fetchDataFromExcelUsingLoop(String sheetName)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();// index
		String value = "";
		for (int i = 1; i <= rowCount; i++) {
			short cellCount = sheet.getRow(i).getLastCellNum(); // count
			for (int j = 0; j < cellCount; j++) {
				value = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return value;
	}

	/**
	 * This method will take sheet name and expTestScriptName and expKey then return value
	 * @param sheetName
	 * @param expTestScriptName
	 * @param expKey
	 * @return
	 */
	public String fetchSingleDataFromExcel(String sheetName, String expTestScriptName, String expKey)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();// index
		String value = "";
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(expTestScriptName))
			{
				short cellCount = sheet.getRow(i).getLastCellNum(); // count
				for (int j = 0; j < cellCount; j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expKey))
					{
						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;
			}
		}
		return value;
	}

	/**
	 * This method will take sheet name and expTestScriptName and expKey then return multiple value
	 * @param sheetName
	 * @param expTestScriptName
	 * @param expKey
	 * @return
	 */
	public List<String> fetchMultipleDataFromExcel(String sheetName, String expTestScriptName, String expKey)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();// index
		List<String> dataList = new ArrayList<>();
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(expTestScriptName))
			{
				short cellCount = sheet.getRow(i).getLastCellNum();  // count
				for (int j = 0; j < cellCount; j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expKey))
					{
						for(int k = i+1; ; k++) {
							String data = df.formatCellValue(sheet.getRow(k).getCell(j));
							if(data.equals("")) {
								break;
							}
							else {
								dataList.add(data);
							}
						}
						break;	
					}
				}
				break;
			}	
		}
		return dataList;
	}
	
	/**
	 * This method will take sheet name and expTestScriptName then return value of particular key
	 * @param sheetName
	 * @param expTestScriptName
	 * @return
	 */
	public String fetchDataFromExcelUsingMap(String sheetName, String expTestScriptName, String expKey)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();// index
		Map<String, String> map = new HashedMap<>();
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(expTestScriptName))
			{
				short cellCount = sheet.getRow(i).getLastCellNum(); // count
				for (int j = 1; j < cellCount; j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		return map.get(expKey);
	}
	
	/**
	 * This method is used to fetch the data from excel sheet using map concept
	 * @param sheetName
	 * @param expTestCaseName
	 * @return
	 */
	public Map<String, String> getData(String sheetName, String expTestCaseName)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();// index
		Map<String, String> map = new HashedMap<>();
		for (int i = 1; i <= rowCount; i++) 
		{
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(expTestCaseName))
			{
				short cellCount = sheet.getRow(i).getLastCellNum(); // count  
				for (int j = 1; j < cellCount; j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		return map;
	}
	
	/**
	 * This method is used to fetch multiple data from excel sheet
	 * @param sheetName
	 * @return
	 */
	public String[][] getData(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		short cellCount = sheet.getRow(0).getLastCellNum();
		String[][] arr = new String[rowCount][cellCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				arr[i-1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return arr;
	}
	
	/**
	 * This method will give the total row count in the sheet 
	 * @param sheetName
	 * @return
	 */
	public int getRowCount(String sheetName)
	{
		Sheet sheet=wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * This method will give the total cell count in the sheet
	 * @param sheetName
	 * @return
	 */
	public short getCellCount(String sheetName)
	{
		Sheet sheet=wb.getSheet(sheetName);
		short cellCount = sheet.getRow(0).getLastCellNum();
		return cellCount;
	}
	
	/**
	 * This method will take sheet name, row number and cell number
	 * Then it will set the data into the sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 */
	public void setData(String sheetName, int rowNum, int cellNum, String data)
	{
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
	}
	
	/**
	 * This method will save the data 
	 * @param fileOutputPath
	 */
	public void saveData(String fileOutputPath)
	{
		try {
			wb.write(new FileOutputStream(fileOutputPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close the WorkBook
	 */
	public void close()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
