package Com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testdata/testscriptdatas.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	wb.close();
	return data;
}
public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testdata/testscriptdatas.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int rownum=wb.getSheet(sheetname).getLastRowNum();
	wb.close();
	return rownum;
}
public void setDataIntoExcell(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./testdata/testscriptdatas.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	 wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
	FileOutputStream fos=new FileOutputStream("./Testdata/testscriptdatas.xlsx");
	wb.write(fos);
	wb.close();
}
}