package ExtentReport;
import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * 
 * @author baaluu
 *
 */
public class ItestListenerIMP implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		//WebDriver driver = null;
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
//		EventFiringWebDriver event=new EventFiringWebDriver(driver);
//		File src=event.getScreenshotAs(OutputType.FILE);
//		String screenshotPath="./screenshot/"+result.getMethod().getMethodName()+".PNG";
//		File dest=new File(screenshotPath);
//		try {
//			Files.copy(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		test.addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(new File("./ExtentReport.html"));
		htmlReporter.config().setDocumentTitle("Vtiger App");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Smoke test");
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Test url", "http://localhost:8888");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Reporter Name", "M. BALA SAI KRISHNA");
		reports.setSystemInfo("BrowserName", "Chrome");
		reports.setSystemInfo("Browser version", "87");
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

}