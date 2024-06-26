package Amazon_project.GTM_projects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Launch_Quit extends Retry_class
{
	ChromeDriver driver;
	@BeforeMethod
	public void login()
	{ 
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration .ofSeconds(10));

	}
	@AfterMethod
	public void logout() throws IOException 
	{
			TakesScreenshot tss=driver;
		File source=tss.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\User\\eclipse-workspace\\GTM_projects\\screenshot\\one."+Math.random()+".png");
		FileHandler.copy(source, destination);
		driver.close();
	}
}
