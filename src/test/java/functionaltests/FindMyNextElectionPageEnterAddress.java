package functionaltests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import base.BaseTests;
import pages.FindMyNextElectionPage;
import utils.DataProviderUtils;

public class FindMyNextElectionPageEnterAddress extends BaseTests{
	
	FindMyNextElectionPage streetField;
	static String projectPath;
	static XSSFWorkbook databook;
	static XSSFSheet datasheet;
	
	public FindMyNextElectionPageEnterAddress() {
		
	}
	@Test(dataProvider = "statedropdownlist2")
	public void fillInStreetFieldWithValidData(String address1, String address2, String city, String state, String zip) throws Exception {
		System.out.println(address1 + " | " + address2 + " | " + city + " | " + state + " | " + zip);
		streetField.enterTextToStreetField(address1);
		streetField.enterTextToStreet2Field(address2);
		streetField.enterTextToCityField(city);
		streetField.enterTextToZipField(zip);
		streetField.selectStateDropdownOption(state);
		streetField.clickSearchButton();
		Thread.sleep(5000);
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

}
