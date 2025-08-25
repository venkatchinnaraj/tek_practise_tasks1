package DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class writedata {
	@Test
	public void write() throws EncryptedDocumentException, IOException {
		FileInputStream Fis = new FileInputStream("./src/test/resources/testdata/tek.xlsx");
		Workbook wb=WorkbookFactory.create(Fis);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(3);
		//System.out.println(row.getCell(1).toString());
		Cell cel = row.createCell(4);
		cel.setCellType(CellType.STRING);
		cel.setCellValue("PASS");
		
		FileOutputStream fos =new FileOutputStream("./src/test/resources/testdata/tek.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
}
