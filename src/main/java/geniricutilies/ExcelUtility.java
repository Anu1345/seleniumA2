package geniricutilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This Class Contains all reusable methods to read/write data from/to exel
 * @author admin
 */

public class ExcelUtility{  
	private Workbook wb;
	private  Sheet sh;

	/**
	 * This method
	 * @param ExcelPath
	 * @param sheetName
	 */

	public void excelInit(String ExcelPath,String sheetName) {
	
FileInputStream fis=null;
try {
	 fis=new FileInputStream(ExcelPath);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	
	}try {
		wb=WorkbookFactory.create(fis);
	}catch(EncryptedDocumentException | IOException e) {
		e.printStackTrace();
		
		
	}
	sh =  wb.getS
	}
	public void readFrameExcel() {
		DataFormatter df=new DataFormatter();
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0; i<= sh.getLastRow(); i++) 
		{
			if(df.formatCellValue(sh.getRow(i).getCell(1)).equals(ExceptedTestName)) {
				for(int j=i; j<=sh.getLastRowNum();j++) {
					map.put(df.formateCellValue(sh.getRow(j).getCell(2)), 
							df.formatCellValue(sh.getRow(j).getCell(3)));
					if(df.formatCellValue(sh.get(j).getCell(2)).equals("###"))
						break;
				}
				break;
			}
			}
		return map;
				}
	public void upadateTestStatus(String expectedTestName,String status,String excelPath )  {
		for(int i=0; i<=sh.getRowNum();i++){
					{
				Cell c= sh.getRow(i).createCell(4);
				c.setCellValue(status);
				break;
					}
				
					}
		FileOutPutStream fos= null;
		try {
			fos=new FileOutPutStream(excelPath);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		}catch(IOException e) {
			e.prinStackTrace();
		}
		
		
		}
	
			
	
		
	
	public void closeExcel(){
try {
	wb.close();
}
catch(IOException e) {
e.printStackTrace();

		
	}
}
	public void excelToApp(String readFromProperties) {
		// TODO Auto-generated method stub
		
	}
	public TestScriptjava.Map<String, String> readFromExcel(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public Map<String, String> readFromExcel(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	}