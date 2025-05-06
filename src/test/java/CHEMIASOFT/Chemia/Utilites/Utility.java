package CHEMIASOFT.Chemia.Utilites;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// This Class is responsible for storing all the file's paths & to return
// To read Data from properties file
// To read & write on the excel files
public class Utility {

	public FileInputStream input;
	public XSSFWorkbook WB;

	// Path Of Excel file

	// Path is an interface, Paths is one of the class on interface path,
	// get("Path of the file on the eclipse") will get the path on eclipse
	// .toAbsolutePath will get the absolute path means full path of the file on the
	// system
	// .toString will convert the all the absolute to string format
	// By using the paths class from path interface we will get the path of the file
	// then we will convert the path to the absolute path & convert the path to
	// string
	// then we return the string for further use

	// Test cases XL file Path
	public  String TestCaseXLPath() {

		Path path = Paths.get("Excel_data/TestCases.xlsx");
		return path.toAbsolutePath().toString();

	}

	// Data XL file path
	public  String DataXLpath() {

		Path path = Paths.get("Excel_data/Data.xlsx");
		return path.toAbsolutePath().toString();

	}
	public  String ARDDataXLpath() {

		Path path = Paths.get("Excel_data/ARDTestData.xlsx");
		return path.toAbsolutePath().toString();

	}
	public  String TemplateDataXLpath() {

		Path path = Paths.get("Excel_data/Data.xlsx");
		return path.toAbsolutePath().toString();

	}
	public  String downloads_path() {

		Path path = Paths.get("Downloads");
		return path.toAbsolutePath().toString();

	}
	public  String ProjectDataXLpath() {

		Path path = Paths.get("Excel_data/Data.xlsx");
		return path.toAbsolutePath().toString();

	}
	
	
	// Properties File path
	public static String PathOfPropertiesFile() {

		Path path = Paths.get("Proparties/MyPropartiesFile.properties");
		return path.toAbsolutePath().toString();

	}

	// Report path
	public String PathOfReport() {

		Path path = Paths.get("Reports");
		return path.toAbsolutePath().toString();

	}

	public String DocumentPath() {

		Path path = Paths.get("Documents/Chemia Document.doc");
		return path.toAbsolutePath().toString();

	}
	public String xlsxPath() {

		Path path = Paths.get("Documents/Chemia Excel.xlsx");
		return path.toAbsolutePath().toString();

	}
	public String JPGPath() {

		Path path = Paths.get("Documents/Chemia Jpg.jpg");
		return path.toAbsolutePath().toString();

	}
	public String PDFPath() {

		Path path = Paths.get("Documents/Chemia PDF.pdf");
		return path.toAbsolutePath().toString();

	}
	public String SVG_FILEPath() {

		Path path = Paths.get("Documents/scheme.svg");
		return path.toAbsolutePath().toString();

	}
	public String updateSVG_FILEPath() {

		Path path = Paths.get("Documents/scheme-7 1 6.svg");
		return path.toAbsolutePath().toString();

	}
	public String uploadRTF2_FILEPath() {

		Path path = Paths.get("Documents/Procedures 2.rtf");
		return path.toAbsolutePath().toString();

	}
	public String uploadRTF1_FILEPath() {

		Path path = Paths.get("Documents/Procedures 1.rtf");
		return path.toAbsolutePath().toString();

	}
	public String uploadTLC_FilePath() {

		Path path = Paths.get("Documents/tlc 1.svg");
		return path.toAbsolutePath().toString();

	}
	public String uploadAddexcelInSectionsPath() {

		Path path = Paths.get("Documents/JS Spread Sheet 1.xlsx");
		return path.toAbsolutePath().toString();

	}
	
	// Screen short path
	public static String PathOfScreenShort() {

		Path path = Paths.get("Screen shorts");
		return path.toAbsolutePath().toString();

	}

	// To get data from properties file
	public String getDataFromProparties(String Key) throws Exception {

		// FileInputStreem is responsible for get the file path
		// Properties is class , we load the file by using the properties class
		// then we get the key value by using getProparty

		FileInputStream input = new FileInputStream(PathOfPropertiesFile());
		Properties pro = new Properties();
		pro.load(input);
		return pro.getProperty(Key);

	}

	// To create the work book
	public String LoadXLfile(int SheetNumber, int RowNumber, int columnNumber) throws Exception {

		input = new FileInputStream(DataXLpath());
		WB = new XSSFWorkbook(input);
		return WB.getSheetAt(SheetNumber).getRow(RowNumber).getCell(columnNumber).getStringCellValue();

	}

	
	
	public String getDataFromXl(int SheetNumber, int RowNumber, int columnNumber) {

		return WB.getSheetAt(SheetNumber).getRow(RowNumber).getCell(columnNumber).getStringCellValue();
	}
	
	// To get numeric type data from the cell from Data XL
	public int getDataFromXl2(int SheetNumber, int RowNumber, int columnNumber) {

		return (int) WB.getSheetAt(0).getRow(0).getCell(0).getNumericCellValue();
	}

	// To write Data on XL file
	public void writeOnFTSexcelFile(String File_path, int SheetNumber, int RowNumber, int ColumnNumber, String Data)
			throws Exception {

		// Will get the path of the XL file
		FileInputStream file = new FileInputStream(File_path);

		// Opens the excel work book
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get the sheet form the workbook as per the sheet index
		XSSFSheet sheet = workbook.getSheetAt(SheetNumber);

		// Get the row form the sheet
		Row row = sheet.getRow(RowNumber);
		if (row == null) {
			System.out.println("Row " + RowNumber + " does not exist. Creating new row.");
			row = sheet.createRow(RowNumber);
		}

		// Get the cell from the row & set the data in the cell
		Cell cell = row.getCell(ColumnNumber);
		if (cell == null) {
			System.out.println("Cell " + ColumnNumber + " in row " + RowNumber + " does not exist. Creating new cell.");
			cell = row.createCell(ColumnNumber);
		}
		// Set the cell value
		cell.setCellValue(Data);

		// To save the excel file
		// get the path of the excel file
		FileOutputStream fileout = new FileOutputStream(File_path);

		// save the work book
		workbook.write(fileout);

		// close the file
		fileout.close();

		// Close the work book
		workbook.close();

	}

	public void Uploadfile(String File_Path) throws Exception {

		Robot rb = new Robot();
		//Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection(File_Path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);


		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);



		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public String TemplateDataXLpath(int sheetNumber, int rowNumber, int columnNumber) {
		// TODO Auto-generated method stub
		return WB.getSheetAt(sheetNumber).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
			};
	
			public String ProjectDataXLpath(int sheetNumber, int rowNumber, int columnNumber) {
				// TODO Auto-generated method stub
				return WB.getSheetAt(sheetNumber).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
			};
			
		    public int getRowNumberByCellValue(String filePath, int SheetNumber, String searchValue, int columnIndex) throws IOException {
		        // Load the Excel file
//		         input = new FileInputStream(filePath);
//		         XSSFWorkbook workbook = new XSSFWorkbook(input);
//		        XSSFSheet sheet = workbook.getSheet(sheetName);
		    	// Will get the path of the XL file
				FileInputStream file = new FileInputStream(filePath);

				// Opens the excel work book
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get the sheet form the workbook as per the sheet index
				XSSFSheet sheet = workbook.getSheetAt(SheetNumber);
		        // Iterate over rows in the sheet
		        for (Row row : sheet) {
		            // Get the cell in the specified column
		            Cell cell = row.getCell(columnIndex);
					System.out.println("cell value"+cell);

		            // Check if the cell value matches the search value
		            if (cell != null && cell.toString().equals(searchValue)) {
		                // Return the row number (Note: row index starts from 0, so +1 to get the actual row number)
		                return row.getRowNum();
		            }
		        }

		        // Return -1 if no matching value was found
		        return -1;
		    }

			public int getARDSheetNumber(String sheetName) throws IOException {
				input = new FileInputStream(ARDDataXLpath());
				WB = new XSSFWorkbook(input);
				 int numberOfSheets = WB.getNumberOfSheets();
		         System.out.println("numberOfSheets"+numberOfSheets);
		         // Loop through sheets to find the index of the sheet with the specified name
		         int sheetIndex=0;
		         for (int i = 0; i <= numberOfSheets; i++) {
		             XSSFSheet sheet = WB.getSheetAt(i);
		             System.out.println("Sheet Name=: "+sheet.getSheetName());
		             if (sheet.getSheetName().equalsIgnoreCase(sheetName)) {
		                 sheetIndex = i;
		                 break;
		             }
		                     }
		         System.out.print(sheetName+" Sheet Number is: "+sheetIndex);
		   		return sheetIndex;

			}

			public int getRowCountARD(int sheetNumber) throws IOException {
				input = new FileInputStream(ARDDataXLpath());
				WB = new XSSFWorkbook(input);
				
				int rowcount=WB.getSheetAt(sheetNumber).getLastRowNum();
		        System.out.println("rowcount"+rowcount);

				return rowcount;
			}
					
			public int getSheetNumber(String sheetName) throws IOException {
				input = new FileInputStream(DataXLpath());
				WB = new XSSFWorkbook(input);
				 int numberOfSheets = WB.getNumberOfSheets();
		         System.out.println("numberOfSheets"+numberOfSheets);
		         // Loop through sheets to find the index of the sheet with the specified name
		         int sheetIndex=0;
		         for (int i = 0; i <= numberOfSheets; i++) {
		             XSSFSheet sheet = WB.getSheetAt(i);
		             System.out.println("Sheet Name=: "+sheet.getSheetName());
		             if (sheet.getSheetName().equalsIgnoreCase(sheetName)) {
		                 sheetIndex = i;
		                 break;
		             }
		                     }
		         System.out.print(sheetName+" Sheet Number is: "+sheetIndex);
		   		return sheetIndex;

			}

			public int getRowCount(int sheetNumber) throws IOException {
				input = new FileInputStream(DataXLpath());
				WB = new XSSFWorkbook(input);
				
				int rowcount=WB.getSheetAt(sheetNumber).getLastRowNum();
		        System.out.println("rowcount"+rowcount);

				return rowcount;
			}
			
			public  Map<String, Object> prepareRowData(int rowIndex, int sheetNumber){
				 XSSFSheet sheet = WB.getSheetAt(sheetNumber); // Get the first sheet

		         // Read header row
		         Row headerRow = sheet.getRow(0);
		         if (headerRow == null) {
		             throw new IllegalStateException("Header row is missing in the sheet.");
		         }

		         // Create a map for headers and their respective values
		         Map<String, Object> rowDataMap = new HashMap<>();

		         // Extract header values
		         String[] headers = new String[headerRow.getLastCellNum()];
		         for (int i = 0; i < headerRow.getLastCellNum(); i++) {
		             Cell headerCell = headerRow.getCell(i);
		             
		             headers[i] = headerCell.getStringCellValue();
		         }

		         // Retrieve the specified row
		         Row dataRow = sheet.getRow(rowIndex);
		         if (dataRow == null) {
		             throw new IllegalStateException("Row at index " + rowIndex + " is missing in the sheet.");
		         }

		         // Map the row data to the headers
		         for (int i = 0; i < headers.length; i++) {
		             Cell cell = dataRow.getCell(i);
		             Object value = getCellValue(cell);
		             rowDataMap.put(headers[i], value);
		         }

		         // Print or use the map as needed
		         System.out.println("Row data map: " + rowDataMap);
				return rowDataMap;
			}

			private Object getCellValue(Cell cell) {
				if (cell == null) {
		            return null; // Return null if the cell itself is null
		        }

		        switch (cell.getCellType()) {
		            case STRING:
		                return cell.getStringCellValue().isEmpty() ? null : cell.getStringCellValue();
		            case NUMERIC:
		            	
		        		String data1 = String.valueOf(cell.getNumericCellValue());
		        		//return WB.getSheetAt(SheetNumber).getRow(RowNumber).getCell(columnNumber).getStringCellValue();
		        		return data1.subSequence(0, data1.length()-2);
		            case BOOLEAN:
		                return cell.getBooleanCellValue();
		            case FORMULA:
		                // Evaluate the formula if needed
		                return cell.getCellFormula(); // or cell.getStringCellValue() if you want the evaluated result
		            default:
		                return null; // Default case for unknown cell types
		        }
		    }		
			 
	
	

}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * *****/
