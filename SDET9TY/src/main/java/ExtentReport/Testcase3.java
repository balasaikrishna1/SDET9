package ExtentReport;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ExtentReport.ItestListenerIMP.class)
public class Testcase3 {
	@Test
	public void testcase3() {
		System.out.println("testcase 3 got exceuted");
		//Assert.assertTrue(false);
	}
}
