package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver wd;
	
	public DSL(WebDriver wd) {
		this.wd = wd;
	}
	
	/********* TextField e TextArea ************/
	
	public void escrever(By by, String texto){
		wd.findElement(by).clear();
		wd.findElement(by).sendKeys(texto);
	}
	
	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return wd.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/********* Radio e Check ************/
	
	public void clicarRadio(String id) {
		wd.findElement(By.id(id)).click();
	}
	
	public boolean isRadioMarcado(String id){
		return wd.findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		wd.findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return wd.findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = wd.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = wd.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = wd.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = wd.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = wd.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = wd.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	/********* Botao ************/
	
	public void clicarBotao(String id) {
		wd.findElement(By.id(id)).click();
	}
	
	public String obterValueElemento(String id) {
		return wd.findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		wd.findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return wd.findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = wd.switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = wd.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = wd.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = wd.switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		wd.switchTo().frame(id);
	}
	
	public void sairFrame(){
		wd.switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		wd.switchTo().window(id);
	}
	
	// JS
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		return js.executeScript(cmd, param);
	}
}
