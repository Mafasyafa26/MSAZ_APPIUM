package coid.nexsoft.app.utils;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private XSSFWorkbook wBook ;
	private XSSFSheet sheet ;	
	private String values ;
	private DataFormatter dFormatter ;
	private int intRowCount;
	private int intColCount;
	
	public ExcelReader(String excelPath, String sheetName) {
		try {
			wBook = new XSSFWorkbook(excelPath);
			sheet = wBook.getSheet(sheetName);
		} catch (IOException e) {
			System.out.println(""+e.getMessage());
			System.out.println(""+e.getCause());
		}		
	}

	public Iterator<Row> getIter()
	{
		Iterator<Row> r = sheet.iterator();
		return r;
	}
	
	public Object getCellData(int rowNum, int colNum)
	{
		dFormatter = new DataFormatter();
		values = dFormatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

		return values;
	}
	
	public int getRowCount()
	{		
		intRowCount = sheet.getPhysicalNumberOfRows();
//		System.out.println(intRowCount);
		return intRowCount;
	}
	public int getColCount()
	{		
		intColCount = sheet.getRow(0).getPhysicalNumberOfCells();

		return intColCount;
	}
}