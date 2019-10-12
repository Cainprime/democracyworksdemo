package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindMyNextElectionPage {
	
	private WebDriver driver;
	
	public FindMyNextElectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void checkHeader(String headertext) {
		this.driver.findElement(By.className(".address-form"));
	}
	
}
