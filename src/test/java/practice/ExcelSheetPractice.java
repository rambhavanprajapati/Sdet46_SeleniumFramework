package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/excel/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Admin");
		int rowCount = sheet.getLastRowNum();// index
		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++) {
			short cellCount = sheet.getRow(i).getLastCellNum(); // count
			System.out.println(cellCount);
			for (int j = 0; j < cellCount; j++) {
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
			}
		}
	}
}
