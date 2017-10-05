package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Representa a página de login
 *
 */
public class LoginPageObjetct {

	public LoginPageObjetct(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userName")
	public WebElement txtUserName;

	@FindBy(id = "senha")
	public WebElement txtSenha;

}
