package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TestRegraDeNegocioCadastro {
	
	@Test
	public void deveValidarNomeObrigatorio() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
			+ "/src/main/resources/componentes.html");
		
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		
		wd.quit();
	}
	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
			+ "/src/main/resources/componentes.html");
		
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		
		wd.quit();
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
			+ "/src/main/resources/componentes.html");
		
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:sobrenome")).sendKeys("Moura");
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		
		wd.quit();
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
			+ "/src/main/resources/componentes.html");
		
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:sobrenome")).sendKeys("Moura");
		wd.findElement(By.id("elementosForm:sexo:0")).click();
		
		wd.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		wd.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		wd.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = wd.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		
		wd.quit();
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
			+ "/src/main/resources/componentes.html");
		
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
		
		wd.quit();
	}
}
