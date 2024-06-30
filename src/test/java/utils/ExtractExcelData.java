package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractExcelData {
    
    static public String getFirstName(int rowIndex) throws IOException {
    	// Path of "TestData" excel file
    	XSSFWorkbook excelWorkbook = new XSSFWorkbook("./src/test/resources/TestData.xlsx");
    	
    	// Reference to excel sheet "Sheet1" 
    	XSSFSheet excelSheet = excelWorkbook.getSheet("Sheet1");
    	
        Object firstName = excelSheet.getRow(rowIndex).getCell(0); // Holds value of firstName column of a selected row in excel sheet
        
        return firstName.toString(); // Converting object type to string
    }
    
    static public String getLastName(int rowIndex) throws IOException {
        XSSFWorkbook excelWorkbook = new XSSFWorkbook("./src/test/resources/TestData.xlsx");
    	XSSFSheet excelSheet = excelWorkbook.getSheet("Sheet1");
    	
        Object lastName = excelSheet.getRow(rowIndex).getCell(1); // Holds value of lastName column of a selected row in excel sheet
        
        return lastName.toString(); 
    }
    
    static public Object getAge(int rowIndex) throws IOException {
    	XSSFWorkbook excelWorkbook = new XSSFWorkbook("./src/test/resources/TestData.xlsx");
    	XSSFSheet excelSheet = excelWorkbook.getSheet("Sheet1");
    	
    	DataFormatter formatter = new DataFormatter(); // To retain data format as displayed in excel sheet
        Object age = formatter.formatCellValue(excelSheet.getRow(rowIndex).getCell(2)); // Holds value of age column of a selected row in excel sheet
        
        return age;		
    }
    
}
