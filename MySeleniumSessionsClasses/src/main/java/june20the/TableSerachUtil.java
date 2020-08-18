package june20the;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TableSerachUtil {
	

	static Workbook book;
		static Sheet sheet;
		public static String TESTDATA_SHEET_PATH ="C:\\Users\\Ashish\\Git\\myproject3\\MySeleniumSessionsClasses\\src\\main\\java\\july20th\\Tabletest.xlsx";

		public static Object[][] getTestData(String sheetName) 
		{
			
			FileInputStream file=null;
			try {
				file=new FileInputStream(TESTDATA_SHEET_PATH);	
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			String fileExtensionName = TESTDATA_SHEET_PATH.substring(TESTDATA_SHEET_PATH.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx"))
			 {
			try {
				
					book=WorkbookFactory.create(file);
				} 
				
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			 }
			sheet=book.getSheet(sheetName);
			Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				{
					data[i][k]=sheet.getRow(i + 1).getCell(k).toString();
				}
			}
			 
			return data;
			
			 
			
		
	}


}
