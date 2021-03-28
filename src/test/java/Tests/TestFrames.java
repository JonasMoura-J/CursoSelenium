package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrames {
	public WebDriver wd;
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
	public void deveInteragirComFrame() {
		//trocar o foco para o frame
		wd.switchTo().frame("frame1");
		wd.findElement(By.id("frameButton")).click();
		
		Alert alert = wd.switchTo().alert();
		
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		
		alert.accept();
		
		wd.switchTo().defaultContent();
		wd.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
}
