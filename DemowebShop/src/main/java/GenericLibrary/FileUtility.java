package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility implements FrameWorkConstants {

	
	public static String getProperty(String key) {
		
		//step 1: Get the java representation of physical properties file
		  FileInputStream fis=null;
		  try {
			  fis = new FileInputStream(FrameWorkConstants.PROPERTY_FILE_PATH);
		  }catch (FileNotFoundException e) {
			  //TODO: Auto-generation catch block
			  e.printStackTrace();
		  }
		  
		  Properties pro = new Properties();
		  
		  //step 2: Load all the key and value pair to properties object
		  try {
			  pro.load(fis);
		  }	
		 catch (IOException e) {
			// TODO: Auto-generation catch block
			e.printStackTrace();
		}
		  
		 //step 3: Get the value using Key
		 return pro.getProperty(key);

	  }
	 
	 public static String readCellDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	    	
	    	
	    	FileInputStream fis = new FileInputStream(FrameWorkConstants.EXCEL_PATH);
	    	
	    	
	    	//Workbook book = WorkbookFactory.create(fis);
	    	
	        //sheet=book.getSheet("register");
	    	
	        //Row row = sheet.getRow(2);
	        
	        //System.out.println(row.getCell(3));
	        
	       // you can use return means u can change the void to string
	    	//return WorkbookFactory.create(fis).getSheet("register").getRow(3).getCell(0).toString();
	        return WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
	    	
	     }
	 
	 public static String[][] readRowDataFromexcel (String sheetName)throws Exception, IOException {
			
			//step 1: get the java representation of physical file
			FileInputStream fis = new FileInputStream(FrameWorkConstants.PROPERTY_FILE_PATH);
			
			//step 2: get the workbook
			Workbook book= WorkbookFactory.create(fis);
		
			//step 3: get the sheet;
			Sheet sheet=book.getSheet(sheetName);
			
			//step 4: get the count of rows having value
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			
			//step 5: get the count of cell having value
			int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			//step 6: create a 2 dimensional array
			String [][] data = new String[rowCount-1][cellCount];
			
			//step 7: read the data from excel and store inside 2 dimensional array.
				for(int i=1;i<rowCount;i++) {
					for(int j=0;j<cellCount;j++) {
						data[i-1][j]=sheet.getRow(i).getCell(j).toString();
						
					}
				}
			//return 2d array
			return data;
			
		}
	    public static void main(String[] args)throws IOException,Exception {
	    	readRowDataFromexcel("register");
	    }
	     
	}


	   