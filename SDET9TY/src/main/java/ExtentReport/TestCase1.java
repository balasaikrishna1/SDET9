package ExtentReport;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ExtentReport.ItestListenerIMP.class)
public class TestCase1 {
	@Test
	public void testcase1() {
		System.out.println("testcase1 exceuted");
	}
}
