package GenricUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Excelutility {
	@Test
	public String getdatafromexcel(String Sheetname, int rownum ,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/testdata/tek.xlsx");
	Workbook wb = WorkbookFactory.create( fis);
	String data = wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).getStringCellValue() ;
		wb.close();
		return data;
		
	}
	Random ran = new Random();
	int  randomInt=ran.nextInt(1000);
	
	public int getrowcount(String Sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/testdata/tek.xlsx");
		Workbook wb = WorkbookFactory.create( fis);
		int rowcount = wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rowcount;
		}
	
	public void setdataintoexcel(String Sheetname, int rownum ,int cellnum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/testdata/tek.xlsx");
		Workbook wb = WorkbookFactory.create( fis);
		 wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		 
		 FileOutputStream fos =new FileOutputStream("./src/test/resources/testdata/tek.xlsx");
		 wb.write(fos);
		 wb.close();
		 }
	public double getdatafromexcelnumber(String Sheetname, int rownum ,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/testdata/tek.xlsx");
	Workbook wb = WorkbookFactory.create( fis);
	double data = wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue() ;
		wb.close();
		return data;
		
	}
	    

}
