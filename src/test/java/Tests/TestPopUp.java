package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPopUp {
	
	@Test
	public void deveInteragirComPopUpEasy() {
		WebDriver wd = new ChromeDriver();
		wd.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		wd.findElement(By.id("buttonPopUpEasy")).click();
		
		wd.switchTo().window("Popup");
		
		wd.findElement(By.tagName("textarea")).sendKeys("deu certo?");
		wd.close();
		
		//voltar o foco para a pagina pricncipal
		wd.switchTo().window("");
		wd.findElement(By.tagName("textarea")).sendKeys("deu certo!");
		
		wd.quit();
	}
}
