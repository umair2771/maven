package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class excelUtils {

	static String projectPath = "user.dir";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	WebDriver driver;
	 
	 @FindBy(xpath="//input[@id='firstName']")
	    WebElement fNameUser;
	 
	 @FindBy(xpath="//input[@id='lastName']")
	    WebElement lNameUser;
	 @FindBy(xpath="//input[@value='Female']//following-sibling::label[text()='Female']")
	    WebElement femaleRadioButton;
	 @FindBy(xpath="//input[@id='userNumber']")
	    WebElement numberUser;
	 @FindBy(xpath="//input[@value='Male']")
	    WebElement maleRadioButton;
	 
	 @FindBy(xpath="//button[@id='submit']")
	    WebElement submitButton;
	 
	 @FindBy(xpath="//button[@id='closeLargeModal']")
	    WebElement closeButton;
	
	public excelUtils(String excelPath, String sheetName, WebDriver driver){
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	 public excelUtils(String excelPath, String sheetName){
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void getExcelSheet() {
		
		try {
			workbook = new XSSFWorkbook(projectPath + "\\Excel\\dataProv.xlsx");
			sheet = workbook.getSheet("Sheet1");
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows are: " + rowCount);
		return rowCount;
	}
	
	public static int getColumnCount() {
		
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of Columns are: " + colCount);
		return colCount;
	}
	
	public static double getCellDataNumeric(int row, int col) {
		
		double cellDataNum = sheet.getRow(row).getCell(col).getNumericCellValue();
		//System.out.println("Number At Given Cell is: " + cellData);
		return cellDataNum;
	}

	public static String getCellDataString(int row, int col) {
		
		String cellDataStr = sheet.getRow(row).getCell(col).getStringCellValue();
		//System.out.println("String At Given Cell is: " + cellData);
		return cellDataStr;
	}
}
