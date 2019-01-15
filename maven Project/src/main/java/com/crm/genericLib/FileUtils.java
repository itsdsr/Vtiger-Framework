package com.crm.genericLib;
/**
 * @author Puja
 *
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils {
	String filePath="./src/test/resources/commonData.properties";
	String excelPath="./src/test/resources/testData.xlsx";
	public Properties getPropertyfileOblect() throws IOException {
		FileInputStream fis=new FileInputStream(filePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj;
	}
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable  {
		FileInputStream fIs=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fIs);
		Sheet sh=wb.getSheet(sheetName);
		String data=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	public int getIntExcelData(String sheetName,int rowNum,int cellNum) throws Throwable  {
		FileInputStream fIs=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fIs);
		Sheet sh=wb.getSheet(sheetName);
		int data=(int) sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return data;
	}
	
	public void setExcelData(String sheetName,int rowNum, int colNum,String data) throws Throwable {
		FileInputStream fIs=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fIs);
		Sheet sh=wb.getSheet(sheetName);
		sh.getRow(rowNum).createCell(colNum).setCellValue(data);
		
		FileOutputStream fOs=new FileOutputStream(excelPath);
		wb.write(fOs);
		wb.close();
	}
}
