package functionaltests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

import base.BaseTests;
import pages.FindMyNextElectionPage;
import utils.DataProviderUtils;

public class FindMyNextElectionPageEnterAddress extends BaseTests{

	
	static String projectPath;
	static XSSFWorkbook databook;
	static XSSFSheet datasheet;

	public FindMyNextElectionPageEnterAddress() {

	}
//	@Test(dataProvider = "statedropdownlist2")
//	public void fillInAddressWithData(String address1, String address2, String city, String state, String zip) {
//		System.out.println(address1 + " | " + address2 + " | " + city + " | " + state + " | " + zip);
//		this.findMyNextElectionPage.enterTextToStreetField(address1);
//		this.findMyNextElectionPage.enterTextToStreet2Field(address2);
//		this.findMyNextElectionPage.enterTextToCityField(city);
//		this.findMyNextElectionPage.enterTextToZipField(state);
//		this.findMyNextElectionPage.selectStateDropdownOption(zip);
//		this.findMyNextElectionPage.clickSearchButton();
//		Thread.sleep(1000);
//	}
	@Test(dataProvider = "statedropdownlist2")
	public void fillInOnlyStreetField(String address1, String address2, String city, String state, String zip) throws Exception{
		this.findMyNextElectionPage.enterTextToStreetField(address1);
		this.findMyNextElectionPage.clickSearchButton();
		Thread.sleep(3000);
		Assert.assertEquals(findMyNextElectionPage.getSearchPageMessage(), "Sorry, there was an error.");
	}
	@Test(dataProvider = "statedropdownlist2")
	public void fillInOnlyStreet2Field(String address1, String address2, String city, String state, String zip) throws Exception{
		this.findMyNextElectionPage.enterTextToStreet2Field(address2);
		this.findMyNextElectionPage.clickSearchButton();
		Thread.sleep(3000);
		Assert.assertEquals(findMyNextElectionPage.getSearchPageMessage(), "Sorry, there was an error.");
	}
	@Test(dataProvider = "statedropdownlist2")
	public void fillInOnlyCityField(String address1, String address2, String city, String state, String zip) throws Exception{
		this.findMyNextElectionPage.enterTextToCityField(city);
		this.findMyNextElectionPage.clickSearchButton();
		Thread.sleep(3000);
		Assert.assertEquals(findMyNextElectionPage.getSearchPageMessage(), "Sorry, there was an error.");
	}
	@Test(dataProvider = "statedropdownlist2")
	public void fillInOnlyStateField(String address1, String address2, String city, String state, String zip) throws Exception{
		this.findMyNextElectionPage.selectStateDropdownOption(state);
		this.findMyNextElectionPage.clickSearchButton();
		Thread.sleep(3000);
		Assert.assertEquals(findMyNextElectionPage.getSearchPageMessage(), "Sorry, there was an error.");
	}
	@Test(dataProvider = "statedropdownlist2")
	public void fillInOnlyZipField(String address1, String address2, String city, String state, String zip) throws Exception{
		this.findMyNextElectionPage.enterTextToZipField(zip);
		this.findMyNextElectionPage.clickSearchButton();
		Thread.sleep(3000);
		Assert.assertEquals(findMyNextElectionPage.getSearchPageMessage(), "Sorry, there was an error.");
	}
//	@Test
//	public void fillInStreetFieldWithValidData() {
//		this.findMyNextElectionPage.enterTextToStreetField("323 18th Street");
//		this.findMyNextElectionPage.enterTextToStreet2Field(" ");
//		this.findMyNextElectionPage.enterTextToCityField("Brooklyn");
//		this.findMyNextElectionPage.enterTextToZipField("11215-6112");
//		this.findMyNextElectionPage.selectStateDropdownOption("NY");
//		this.findMyNextElectionPage.clickSearchButton();
//	}
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
