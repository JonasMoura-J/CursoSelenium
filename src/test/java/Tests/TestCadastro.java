package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCadastro {
	
	@Test
	public void deveCadastrarPessoa() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir")
			+ "/src/main/resources/componentes.html");
		
		wd.findElement(By.id("elementosForm:nome")).sendKeys("Jonas");
		wd.findElement(By.id("elementosForm:sobrenome")).sendKeys("Moura");
		
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
		Assert.assertEquals("Sobrenome: Moura", wd.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", wd.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne", wd.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", wd.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: O que eh esporte?", wd.findElement(By.id("descEsportes")).getText());
		
		wd.quit();
	}
}
