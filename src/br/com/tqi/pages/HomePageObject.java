package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	public HomePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="q")
	public WebElement txtSearch;

	@FindBy(name="btnK")
	public WebElement btnSearch;

}
