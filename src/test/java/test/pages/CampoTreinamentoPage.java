package test.pages;

import org.openqa.selenium.WebDriver;

import test.DSL;

public class CampoTreinamentoPage {
	
	private DSL dsl;

	public CampoTreinamentoPage(WebDriver wd) {
		this.dsl = new DSL(wd);
	}

	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}
}
