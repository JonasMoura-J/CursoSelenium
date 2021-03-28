package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCadastro {
	private WebDriver wd;
	private DSL dsl;
	
	@Before //antes de cada test, executar o conteúdo deste método. nem precisa fazer a chamada no metodo em cada test
	public void incializa() {
		wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
		+ "/src/main/resources/componentes.html");
	}
	
	@After //após cada execução de teste
	public void finaliza() {
		wd.quit();
	}
	
	@Test
	public void deveCadastrarPessoa() {
		dsl.escreve("elementosForm:nome", "Jonas");
		dsl.escreve("elementosForm:sobrenome", "Moura");
		
		wd.findElement(By.id("elementosForm:sexo:0")).click();
		//boolean isSelecionado = wd.findElement(By.id("elementosForm:sexo:0")).isSelected();
		
		wd.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		//boolean isCheckBoxSelecionado = wd.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected();
		
		WebElement element = wd.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);	
		combo.selectByVisibleText("Superior");
		
		WebElement element2 = wd.findElement(By.id("elementosForm:esportes"));
		Select multiSelect = new Select(element2);
		multiSelect.selectByVisibleText("O que eh esporte?");
		
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		//--------------------------Verificações-------------------------------------
		
		Assert.assertTrue(wd.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(wd.findElement(By.id("descNome")).getText().endsWith("Jonas"));
		Assert.assertEquals("Sobrenome: Moura", dsl.obterValorCampo("descSobrenome"));
		Assert.assertEquals("Sexo: Masculino", dsl.obterValorCampo("descSexo"));
		Assert.assertEquals("Comida: Carne", dsl.obterValorCampo("descComida"));
		Assert.assertEquals("Escolaridade: superior", dsl.obterValorCampo("descEscolaridade"));
		Assert.assertEquals("Esportes: O que eh esporte?", dsl.obterValorCampo("descEsportes"));
	}
}
