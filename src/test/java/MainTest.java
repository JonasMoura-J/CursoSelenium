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
	
	@Test
	public void radioButtonTest() {
		WebDriver wd = new ChromeDriver();
		wd.get("https://github.com/JonasMoura-J");
		wd.findElement(By.cssSelector("#js-pjax-container > div.mt-4.position-sticky.top-0.d-none.d-md-block.color-bg-primary.width-full.border-bottom.color-border-secondary > div > div > div.flex-shrink-0.col-12.col-md-9.mb-4.mb-md-0 > div > div > span")).click();
		
		//testando se obteve sucesso
		boolean isSelecionado = wd.findElement(By.cssSelector("#js-pjax-container > div.mt-4.position-sticky.top-0.d-none.d-md-block.color-bg-primary.width-full.border-bottom.color-border-secondary > div > div > div.flex-shrink-0.col-12.col-md-9.mb-4.mb-md-0 > div > div > span")).isSelected();
		Assert.assertTrue(isSelecionado);
		
		wd.quit();
	}
}
