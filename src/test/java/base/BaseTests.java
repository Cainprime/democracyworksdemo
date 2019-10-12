package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FindMyNextElectionPage;
import utils.EventReporter;

public class BaseTests {

	private static EventFiringWebDriver driver;
	protected FindMyNextElectionPage findMyNextElectionPage;
	public static String browserName = null;

	public BaseTests() {

	}
	@BeforeClass
	public void setUp() {
		
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new EventFiringWebDriver(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new EventFiringWebDriver(new FirefoxDriver());
		}
//		else if(browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EventFiringWebDriver(new EdgeDriver());
//		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new EventFiringWebDriver(new InternetExplorerDriver());
		}
		driver.register(new EventReporter());
		this.gofindMyNextElectionPage();
	}
	@BeforeMethod
	public void gofindMyNextElectionPage() {
		driver.get("http://home.novonon.com:9191");
		this.findMyNextElectionPage = new FindMyNextElectionPage(driver);
	}
	
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		if(2 == result.getStatus()) {
			TakesScreenshot camera = driver;
			File screenshot = (File)camera.getScreenshotAs(OutputType.FILE);

			try {
				Files.move(screenshot, new File("resources/screenshots" + result.getName() + ".png"));
			} catch (IOException var5){
				var5.printStackTrace();
			}
		}
	}
	@AfterClass
	public void tearDown() {driver.quit();}


}