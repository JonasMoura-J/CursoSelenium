import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
	
	@Test
	public void test() {
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.google.com.br/");
		Assert.assertEquals("Google", wd.getTitle());
	}
}
