package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class basedoncondition {
	@Test
	public void condition() throws EncryptedDocumentException, IOException {

		//to read data in Excel file
				FileInputStream Fis = new FileInputStream("./src/test/resources/testdata/tek.xlsx");
				Workbook wb=WorkbookFactory.create(Fis);
				Sheet sh = wb.getSheet("org");
				int rownum = sh.getLastRowNum();
				String expected="TC_002";
			String data1 = "",data2="",data3="";

				
				for(int i=0;i<=rownum;i++) {
					 String  data = sh.getRow(i).getCell(0).toString();
					if(data.equals(expected)) {
						System.out.println(sh.getRow(i).getCell(1).toString());
						
						 data2=sh.getRow(i).getCell(2).toString();
						 data3=sh.getRow(i).getCell(3).toString();
					}
					
				}
				System.out.println(data2+"\t"+data3);
           wb.close();
	}

}
