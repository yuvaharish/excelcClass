package excelReadandUpdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
	public static void readExcel() throws IOException {
		File file = new File("C:\\Users\\jacki\\OneDrive\\Desktop\\Attendance Tracker.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet=wb.getSheet("AiiTE FT Dec Batch 1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		System.out.println(cell);
		
	}
	
	public static void readAllData() throws IOException {
		File file = new File("C:\\Users\\jacki\\OneDrive\\Desktop\\Attendance Tracker.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet=wb.getSheet("AiiTE FT Dec Batch 1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		//Excel looping
		for (int i = 0; i <rowCount; i++) {
			Row row = sheet.getRow(i);
			int cellCount = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellCount; j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if(cellType==1) {
					String value=cell.getStringCellValue();
					System.out.println(value);
				}else if(cellType==0) {
				if(DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sd = new SimpleDateFormat("MMMM/dd/YYY");
					String value = sd.format(dateCellValue);
					System.out.println(value);
				}else {
					double numericCellValue = cell.getNumericCellValue();
					long lon=(long)numericCellValue;
					String value = String.valueOf(lon);
					System.out.println(value);
				}
				}
			}
		}
		
	}
	
	
	public static void readandPassData(int rowValue,int cell1Value) throws IOException {
		File file = new File("C:\\Users\\jacki\\OneDrive\\Desktop\\Attendance Tracker.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet=wb.getSheet("AiiTE FT Dec Batch 1");
			Row row = sheet.getRow(rowValue);
				Cell cell = row.getCell(cell1Value);
				int cellType = cell.getCellType();
				if(cellType==1) {
					String value=cell.getStringCellValue();
					System.out.println(value);
				}else if(cellType==0) {
				if(DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sd = new SimpleDateFormat("MMMM/dd/YYY");
					String value = sd.format(dateCellValue);
					System.out.println(value);
				}else {
					double numericCellValue = cell.getNumericCellValue();
					long lon=(long)numericCellValue;
					String value = String.valueOf(lon);
					System.out.println(value);
				}
				}
			}
		
		
	
	
	public static void main(String[] args) throws IOException {
		//readExcel();
		//readAllData();
		readandPassData(0,1);
	}

}
