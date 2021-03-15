import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest extends Main{
	
	@Test
	public void acessoTest() {
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.google.com.br/");
		Assert.assertEquals("Google", wd.getTitle());
		wd.quit();
	}
	
	@Test
	public void textFieldTest() {
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.google.com.br/");
		wd.findElement(By.name("q")).sendKeys("Teste escrita");
		
		//testando se obteve sucesso
		String valorInput = wd.findElement(By.name("q")).getAttribute("value");
		Assert.assertEquals("Teste escrita", valorInput);
		
		wd.quit();
	}
}
