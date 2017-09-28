package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcoesBoletaPageObject {
	
	public AcoesBoletaPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Botão Nova Boleta
	@FindBy(css="#menu-fix > div > button.btn-lg.btn-success.ng-scope")
	public WebElement btnNovaBoleta;


}
