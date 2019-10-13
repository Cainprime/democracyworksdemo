package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		DataProviderUtils stateDropdownOptions = new DataProviderUtils(projectPath + "/dataproviders/democracyworksstatedropdown.xlsx", "State Dropdown");
		DataProviderUtils addressData = new DataProviderUtils(projectPath + "/dataproviders/democracyworksstatedropdown.xlsx", "Address test data");
		
		stateDropdownOptions.getRowCount();
		stateDropdownOptions.getColumnCount();
		addressData.getCellDataString(1, 4);
	}

}
