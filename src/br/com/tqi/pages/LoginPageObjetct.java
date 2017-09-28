package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjetct {
	
	public LoginPageObjetct(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

}
