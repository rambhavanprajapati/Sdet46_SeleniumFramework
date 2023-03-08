package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice3 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String sheetName = "User";
		String expTestScriptName = "create package";
		String expKey = "packagename";
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/excel/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
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
		System.out.println(dataList);
	}
}
