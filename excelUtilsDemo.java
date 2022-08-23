package utils;

public class excelUtilsDemo {

	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		
		excelUtils excel = new excelUtils(projectPath + "\\Excel\\dataProv.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getCellDataNumeric(4,2);
		excel.getCellDataString(2,2);
		
	}
	
}
