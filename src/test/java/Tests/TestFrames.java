package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrames {
	
	@Test
	public void deveInteragirComFrame() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//trocar o foco para o frame
		wd.switchTo().frame("frame1");
		wd.findElement(By.id("frameButton")).click();
		
		Alert alert = wd.switchTo().alert();
		
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		
		alert.accept();
		
		wd.switchTo().defaultContent();
		wd.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
		wd.quit();
	}
}
