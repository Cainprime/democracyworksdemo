package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindMyNextElectionPage {
	
	private WebDriver driver;
	
	public FindMyNextElectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHeader() {
		WebElement header = driver.findElement(By.xpath("/html/body/section/div/h1"));
		String headerText = header.getText();
		return headerText;
	}
	
	public String getUserMessage() {
		WebElement userMessage = driver.findElement(By.xpath("/html/body/section/div/form/p"));
		String userMessageText = userMessage.getText();
		return userMessageText;
	}
	
	public String getStreetFieldLabel() {
		WebElement streetField = driver.findElement(By.xpath("//div[1]/label"));
		String streetFieldLabel = streetField.getText();
		return streetFieldLabel;
	}	
	
	public void enterTextToStreetField(String text) {
		driver.findElement(By.id("street-field")).sendKeys(text);
	}
	
	
	public String getStreet2FieldLabel() {
		WebElement street2Field = driver.findElement(By.xpath("//div[2]/label"));
		String street2FieldLabel = street2Field.getText();
		return street2FieldLabel;
	}
	
	public void enterTextToStreet2Field(String text) {
		driver.findElement(By.id("street-2-field")).sendKeys(text);
	}
	
	public String getCityFieldLabel() {
		WebElement cityField = driver.findElement(By.xpath("//div[3]/label[1]"));
		String cityFieldLabel = cityField.getText();
		return cityFieldLabel;
	}
	
	public void enterTextToCityField(String text) {
		driver.findElement(By.id("city-field")).sendKeys(text);
	}
	
	public String getStateDropdownLabel() {
		WebElement stateDropdown = driver.findElement(By.xpath("//div[3]/label[2]"));
		String stateDropdownLabel = stateDropdown.getText();
		return stateDropdownLabel;
	}
	
	public void clickStateDropdown() {
		WebElement stateDropdown = driver.findElement(By.id("state-field"));
		stateDropdown.click();
	}
	
	public List<WebElement> getStateDropdownOptions() {
		Select stateDropdownSelect = new Select(driver.findElement(By.id("state-field")));
		List<WebElement> stateDropdownList = stateDropdownSelect.getOptions();
		return stateDropdownList;
	}
	
	public void selectStateDropdownOption(String stateText) {
		Select stateDropdownOption = new Select(driver.findElement(By.id("state-field")));
		stateDropdownOption.selectByVisibleText(stateText);
	}
	
	public String getZipFieldLabel() {
		WebElement zipField = driver.findElement(By.xpath("//div[3]/label[3]"));
		String zipFieldLabel = zipField.getText();
		return zipFieldLabel;
	}
	
	public void enterTextToZipField(String text) {
		driver.findElement(By.id("zip-field")).sendKeys(text);
	}
	
	public String getSearchButtonLabel() {
		WebElement searchButton = driver.findElement(By.xpath("//div[4]/button"));
		String searchButtonLabel = searchButton.getText();
		return searchButtonLabel;
	}
	public void clickSearchButton() {
		driver.findElement(By.xpath("//div[4]/button")).click();
	}
	public String getSearchPageMessage() {
		WebElement searchPageHeader = driver.findElement(By.xpath("//section/h1"));
		String searchPageHeaderLabel = searchPageHeader.getText();
		return searchPageHeaderLabel;
	}
}
