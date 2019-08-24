package come.actitime.genric;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author vinod
 */

public class ExcelUtils {
	static final String filepath=".\\testData\\testData.xlsx.xlsx";


	/**
	 * @description to read data from testData.xlsx
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	
	
	
	
	public static String readData(String sheetName, int rowNum, int cellNum)  {
		
		String value=null;
		try{
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filepath)));
	value=	wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		}
	catch(EncryptedDocumentException e){
		
		e.printStackTrace();
	}
	
	
	catch(InvalidFormatException e){
		e.printStackTrace();
	}
	
	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	
	
	catch(IOException e){
		e.printStackTrace();
	}
	
	
	
	
	return value;
	}
}
