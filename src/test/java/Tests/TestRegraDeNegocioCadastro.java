package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRegraDeNegocioCadastro {
	private WebDriver wd;
	
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
	public void deveValidarNomeObrigatorio() {		
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	}
	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:sobrenome")).sendKeys("Moura");
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:sobrenome")).sendKeys("Moura");
		wd.findElement(By.id("elementosForm:sexo:0")).click();
		
		wd.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		wd.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:sobrenome")).sendKeys("Moura");
		wd.findElement(By.id("elementosForm:sexo:0")).click();
		wd.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		Select combo = new Select(wd.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("O que eh esporte?");
		
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
	}
}
