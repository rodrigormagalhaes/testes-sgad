package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CriaBoletaPageObject {
	
	public CriaBoletaPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="cdCnpj")
	public WebElement inptCNPJ;
	
	@FindBy(css="#conteudo-fix-pesquisa > ng-form > div.panel.panel-default > div > div:nth-child(3) > div > div > button")
	public WebElement btnPesquisar;

	@FindBy(css="body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > button")
	public WebElement btnN�o;
	
	

}
