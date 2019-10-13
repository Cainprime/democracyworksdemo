package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	static String projectPath;
	static XSSFWorkbook databook;
	static XSSFSheet datasheet;

	public DataProviderUtils(String dataPath, String sheetName) {
		try {
			databook = new XSSFWorkbook(dataPath);
			datasheet = databook.getSheet(sheetName);			
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
	@DataProvider(name = "statedropdownlist1")
	public Object[][] getData1() {
		String projectPath = System.getProperty("user.dir");
		Object data[][] = verifyStateDropdownOptions(projectPath + "/dataproviders/democracyworksstatedropdown.xlsx", "State Dropdown");
		return data;
	}
	
	@DataProvider(name = "statedropdownlist2")
	public Object[][] getData2() {
		String projectPath = System.getProperty("user.dir");
		Object data[][] = verifyStateDropdownOptions(projectPath + "/dataproviders/democracyworksstatedropdown.xlsx", "Address test data");
		return data;
	}
	
	public Object[][] verifyStateDropdownOptions(String dataPath, String sheetName) {
		String projectPath = System.getProperty("user.dir");
		DataProviderUtils stateDropdownOptions = new DataProviderUtils(dataPath, sheetName);
		int rowCount = stateDropdownOptions.getRowCount();
		int colCount = stateDropdownOptions.getColumnCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 0; j < colCount; j++ ) {
				String celldata = stateDropdownOptions.getCellDataString(i, j);
//				System.out.println(celldata + " | ");
				data[i-1][j] = celldata;
			}
			
		}
		return data;
	}

	public static void main(String[] args) {
//				getRowCount();
		//		getCellData("State Dropdown", 1, 0);
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = datasheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows are: " + rowCount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	public static int getColumnCount() {
		int columnCount = 0;
		try {
			columnCount = datasheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns are: " + columnCount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return columnCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = datasheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//			System.out.println(cellData);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;

	}

	public static double getCellDataNumber(int rowNum, int colNum) {
		double cellData = 0;
		try {
			cellData = datasheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
//			System.out.println(cellData);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;

	}

}
