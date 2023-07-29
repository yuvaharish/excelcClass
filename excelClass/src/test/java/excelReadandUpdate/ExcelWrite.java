package excelReadandUpdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public static void write() throws IOException {
		File file = new File("C:\\Users\\jacki\\OneDrive\\Desktop\\Attendance Tracker.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet=wb.getSheet("AiiTE FT Dec Batch 1");
		Row createRow = sheet.createRow(1);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue("Shoban Learning Excel");
		FileOutputStream fo = new FileOutputStream(file);
		wb.write(fo);
		wb.close();
	}
	
	public static void updateCellValue() throws IOException {
		File file = new File("C:\\Users\\jacki\\OneDrive\\Desktop\\Attendance Tracker.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet=wb.getSheet("AiiTE FT Dec Batch 1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String CellValue = cell.getStringCellValue();
		if(CellValue.equals("Shoban Learning Excel")) {
			cell.setCellValue("Yuvaraj Learning");
			FileOutputStream fo = new FileOutputStream(file);
			wb.write(fo);
			wb.close();
		}
	}

	public static void main(String[] args) throws IOException {
		//write();
		updateCellValue();
	}
	
}
