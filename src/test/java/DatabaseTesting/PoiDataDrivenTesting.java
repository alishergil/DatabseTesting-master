package DatabaseTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

// Getting the Data from Excel Sheet

public class PoiDataDrivenTesting {

    public static void main(String[] args) {
        XSSFWorkbook ExcelBook;   // create the variable
        XSSFSheet ExcelSheet;     // imports the XSSFSheet
        XSSFRow ExcelRow;         // imports the Row
        XSSFCell ExcelCell;       // imports the Cell
        //Location of Excel file is
        String path = "C:\\Users\\Administrator\\Desktop\\Book1.xlsx"; //right click in book1 which is on Desktop and get a path
        String sheetName = "Sheet1"; // create a variable in string
        try {            //  create a try and catch block
            FileInputStream ExcelFile = new FileInputStream(path);
            ExcelBook = new XSSFWorkbook(ExcelFile);
            ExcelSheet = ExcelBook.getSheet(sheetName);
            ExcelCell = ExcelSheet.getRow( 2).getCell(2);
            String CellData = ExcelCell.getStringCellValue();
            System.out.println("Cell Data is: " + CellData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
