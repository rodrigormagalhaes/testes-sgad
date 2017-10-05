package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Representa a página Home da aplicação
 *
 */
public class HomePageObject {

	public HomePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Menu Boletas
	@FindBy(css = "#MainMenu > div > a.list-group-item.js-sidebar-toggle.ng-scope > i")
	public WebElement menuBoletas;

}
