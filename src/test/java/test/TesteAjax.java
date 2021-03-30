package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.pages.CampoTreinamentoPage;

public class TesteAjax {
	
	private WebDriver wd;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before //antes de cada test, executar o conteúdo deste método. nem precisa fazer a chamada no metodo em cada test
	public void incializa() {
		wd = new ChromeDriver();
		wd.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=aa4b7");
		dsl = new DSL(wd);
	}
	
	@After //após cada execução de teste
	public void finaliza() {
		wd.quit();
	}
	
	@Test
	public void testAjax() {
		dsl.escrever("j_idt302:name", "Teste");
		dsl.clicarBotao("j_idt302:j_idt306");
		WebDriverWait wait = new WebDriverWait(wd, 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt302:display"), "Teste"));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt302:display"));
	}
}
