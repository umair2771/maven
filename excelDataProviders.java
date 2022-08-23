package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelDataProviders {

	/*
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		testData(projectPath + "\\Excel\\dataProv.xlsx", "Sheet1");
		
	}
	*/
	
	public String baseurl = "https://demoqa.com/automation-practice-form";
	public WebDriver driver;
	public excelUtils pom ;
	
	
	@BeforeTest
	public void GetDriverAdress() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ACER\\Desktop\\CureMD\\QA_Automation\\Java\\chromedriver.exe");
		 //System.setProperty("webdriver.chrome.driver",
		 //"C:\\Users\\4123\\Downloads\\chromedriver.exe");
		
		// Create New WebDriver and maximize it
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseurl);
			String projectPath = System.getProperty("user.dir");
			pom = new excelUtils(projectPath + "\\Excel\\dataProv.xlsx", "Sheet1",driver);
			
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String userName, String password) throws InterruptedException {
		System.out.println(userName + " | " + password);
		
		pom.fNameUser.sendKeys(userName);
		
		pom.lNameUser.sendKeys(password);
		
		Thread.sleep(2000);
	}
	
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		
		String projectPath = System.getProperty("user.dir");
		Object data[][] = testData(projectPath + "\\Excel\\dataProv.xlsx", "Sheet1");
		return data;
	}
	
	public  Object[][] testData(String excelPath, String sheetName) {
		
		excelUtils excel = new excelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++) {	//started with 1 because first is heading
			for(int j=0;j<colCount;j++) {	//started with 0 because first is data
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}
	
}
