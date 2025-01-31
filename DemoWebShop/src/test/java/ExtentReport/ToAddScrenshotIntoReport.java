package ExtentReport;

import java.time.Duration;
//import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToAddScrenshotIntoReport {
	
	@Test
	public void addScreenshot() {
				

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		ExtentSparkReporter spark =new  ExtentSparkReporter("./HTML_reports/ExtentReportScreen.html");
		
		
		ExtentReports extReport1=new ExtentReports();
		
				extReport1.attachReporter(spark);
		
		ExtentTest test = extReport1.createTest("addScreenshot");
		
		test.log(Status.PASS, "Screenshot adding into report");
		
		test.addScreenCaptureFromBase64String(screenshot);
		
		extReport1.flush();
		
		}
}
