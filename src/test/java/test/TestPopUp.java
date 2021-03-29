package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPopUp {
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
	public void deveInteragirComPopUpEasy() {
		wd.findElement(By.id("buttonPopUpEasy")).click();
		
		wd.switchTo().window("Popup");
		
		wd.findElement(By.tagName("textarea")).sendKeys("deu certo?");
		wd.close();
		
		//voltar o foco para a pagina pricncipal
		wd.switchTo().window("");
		wd.findElement(By.tagName("textarea")).sendKeys("deu certo!");
	}
	
	@Test
	public void deveInteragirComPopUpHard() {
		//caso em que o pop up não tem um identificador para fazer o switch de janelas
		wd.findElement(By.id("buttonPopUpHard")).click();
		
		//dessa forma, tem como acessar o "id" de cada janela disponível na visualização. 
		//Resolve o problema de não se ter um identificador direto
		System.out.println(wd.getWindowHandle());
		System.out.println(wd.getWindowHandles());	
		wd.switchTo().window(wd.getWindowHandles().toArray()[1].toString());
		wd.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		
		wd.switchTo().window(wd.getWindowHandles().toArray()[0].toString());
		wd.findElement(By.tagName("textarea")).sendKeys("Deu certo!");
	}
}
