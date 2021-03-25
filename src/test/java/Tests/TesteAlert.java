package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
	
	@Test
	public void deveIntragirComAlertSimples() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		wd.findElement(By.id("alert")).click();
		
		//fazendo com que o selenium altere o foco da página para identificar o alert
		
		Alert alert = wd.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Alert Simples", textoAlert);
		alert.accept();
		
		wd.findElement(By.id("elementosForm:nome")).sendKeys(textoAlert);
		wd.quit();
	}
}
