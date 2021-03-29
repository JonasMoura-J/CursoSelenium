package test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainTest{
	private WebDriver wd;
	private DSL dsl;
	
	@Before //antes de cada test, executar o conteúdo deste método. nem precisa fazer a chamada no metodo em cada test
	public void incializa() {
		wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
		+ "/src/main/resources/componentes.html");
		dsl = new DSL(wd);
	}
	
//	@After //após cada execução de teste
//	public void finaliza() {
//		wd.quit();
//	}
	
	@Test
	public void acessoTest() {
		Assert.assertEquals("Google", wd.getTitle());
	}
	
	@Test
	public void textFieldTest() {
		dsl.escrever("elementosForm:nome", "Teste escrita");
		Assert.assertEquals("Teste escrita", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void radioButtonTest() {
		wd.findElement(By.cssSelector("#js-pjax-container > div.mt-4.position-sticky.top-0.d-none.d-md-block.color-bg-primary.width-full.border-bottom.color-border-secondary > div > div > div.flex-shrink-0.col-12.col-md-9.mb-4.mb-md-0 > div > div > span")).click();
		
		//testando se obteve sucesso
		boolean isSelecionado = wd.findElement(By.cssSelector("#js-pjax-container > div.mt-4.position-sticky.top-0.d-none.d-md-block.color-bg-primary.width-full.border-bottom.color-border-secondary > div > div > div.flex-shrink-0.col-12.col-md-9.mb-4.mb-md-0 > div > div > span")).isSelected();
		Assert.assertTrue(isSelecionado);
	}
	
	@Test
	public void deveInteragirComOSelectTest() {
		WebElement element = wd.findElement(By.id("elementosForm:escolaridade"));
		
		Select combo = new Select(element);
		combo.selectByIndex(3);
		
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());	
	}
	
	@Test
	public void deveVerificarValoresSelectTest() {
		WebElement element = wd.findElement(By.id("elementosForm:escolaridade"));
		
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		assertEquals(8, options.size());
	}
	
	@Test
	public void deveVerificarValoresSelectMultiploTest() {
		WebElement element = wd.findElement(By.id("elementosForm:esportes"));
		
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
	}
	
	@Test
	public void deveInteragirComBotoes() {
		WebElement element = wd.findElement(By.id("buttonSimple"));
		
		element.click();
		Assert.assertEquals("Obrigado!", element.getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComLink() {
		WebElement element = wd.findElement(By.linkText("Voltar"));
		
		element.click();
		Assert.assertEquals("Voltou!", wd.findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		Assert.assertEquals("Campo de Treinamento", wd.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				wd.findElement(By.className("facilAchar")).getText());
	}
	
	@Test
	public void testJavaScript() {
		WebElement element = wd.findElement(By.id("elementosForm:nome"));
		dsl.executarJS("arguments[0].style.border = arguments[1]", element, "solid 4px red");
		//js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via JS'");
	}
}
