import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
	
	@Test
	public void deveInteragirComOSelectTest() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = wd.findElement(By.id("elementosForm:escolaridade"));
		
		Select combo = new Select(element);
		combo.selectByIndex(3);
		
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());	
		wd.quit();
	}
	
	@Test
	public void deveVerificarValoresSelectTest() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = wd.findElement(By.id("elementosForm:escolaridade"));
		
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		assertEquals(8, options.size());
		wd.quit();
	}
	
	@Test
	public void deveVerificarValoresSelectMultiploTest() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = wd.findElement(By.id("elementosForm:esportes"));
		
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		wd.quit();
	}
	
	@Test
	public void deveInteragirComBotoes() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = wd.findElement(By.id("buttonSimple"));
		
		element.click();
		Assert.assertEquals("Obrigado!", element.getAttribute("value"));
		wd.quit();
	}
	
	@Test
	public void deveInteragirComLink() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = wd.findElement(By.linkText("Voltar"));
		
		element.click();
		Assert.assertEquals("Voltou!", wd.findElement(By.id("resultado")).getText());
		wd.quit();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		Assert.assertEquals("Campo de Treinamento", wd.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				wd.findElement(By.className("facilAchar")).getText());
		wd.quit();
	}
}
