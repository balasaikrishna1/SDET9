package ExtentReport;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ExtentReport.ItestListenerIMP.class)
public class Testcase2 {
	@Test
	public void testcase2() {
		System.out.println("testcase 2 got executed");
	}	}