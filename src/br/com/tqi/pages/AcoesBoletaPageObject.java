package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe que representa a p�gina que tem op��o de criar ou pesquisar boleta
 *
 */
public class AcoesBoletaPageObject {

	public AcoesBoletaPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Bot�o Nova Boleta
	@FindBy(css = "#menu-fix > div > button.btn-lg.btn-success.ng-scope")
	public WebElement btnNovaBoleta;

}
