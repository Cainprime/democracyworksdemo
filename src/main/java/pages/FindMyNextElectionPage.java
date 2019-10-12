package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public String getStreet2FieldLabel() {
		WebElement street2Field = driver.findElement(By.xpath("//div[2]/label"));
		String street2FieldLabel = street2Field.getText();
		return street2FieldLabel;
	}
	
	public String getCityFieldLabel() {
		WebElement cityField = driver.findElement(By.xpath("//div[3]/label[1]"));
		String cityFieldLabel = cityField.getText();
		return cityFieldLabel;
	}
	
	public String getStateDropdownLabel() {
		WebElement stateDropdown = driver.findElement(By.xpath("//div[3]/label[2]"));
		String stateDropdownLabel = stateDropdown.getText();
		return stateDropdownLabel;
	}
	
	public String getZipFieldLabel() {
		WebElement zipField = driver.findElement(By.xpath("//div[3]/label[3]"));
		String zipFieldLabel = zipField.getText();
		return zipFieldLabel;
	}
	
	public String getSearchButtonLabel() {
		WebElement searchButton = driver.findElement(By.xpath("//div[4]/button"));
		String searchButtonLabel = searchButton.getText();
		return searchButtonLabel;
	}
}
