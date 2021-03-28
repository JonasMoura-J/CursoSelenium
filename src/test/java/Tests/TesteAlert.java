package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
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
	public void deveIntragirComAlertSimples() {
		wd.findElement(By.id("alert")).click();
		
		//fazendo com que o selenium altere o foco da página para identificar o alert
		
		Alert alert = wd.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Alert Simples", textoAlert);
		alert.accept();
		
		wd.findElement(By.id("elementosForm:nome")).sendKeys(textoAlert);
	}
	
	@Test
	public void deveIntragirComAlertConfirm() {
		wd.findElement(By.id("confirm")).click();
		
		//fazendo com que o selenium altere o foco da página para identificar o alert
		
		Alert alert = wd.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Confirm Simples", textoAlert);
		alert.accept();
		
		Assert.assertEquals("Confirm Simples", textoAlert);
		alert.accept();
	}
	
	@Test
	public void deveIntragirComAlertDismiss() {
		wd.findElement(By.id("confirm")).click();
		
		Alert alert = wd.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Confirm Simples", textoAlert);
		alert.dismiss();
		
		Assert.assertEquals("Confirm Simples", textoAlert);
		alert.dismiss();
	}
	
	@Test
	public void deveIntragirComAlertComPrompt() {
		wd.findElement(By.id("prompt")).click();
		
		Alert alert = wd.switchTo().alert();
		String textoAlert = alert.getText();
		
		Assert.assertEquals("Digite um numero", textoAlert);
		alert.sendKeys("123");
		alert.accept();
		Assert.assertEquals("Era 123?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
	}
}
