package br.com.tqi.teste;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tqi.pages.AcoesBoletaPageObject;
import br.com.tqi.pages.CriaBoletaPageObject;
import br.com.tqi.pages.HomePageObject;
import br.com.tqi.pages.LoginPageObjetct;
import br.com.tqi.utils.IOManager;


public class TesteCriaBoletaSGAD {
	
	static IOManager ioManager;
	static WebDriver driver; 

	public static void main(String[] args) throws IOException {
		
		try {
			
			//Recebe o arquivo parametros.txt que é setado em Run Configurations >> Arguments
			String fileInput = args[0];
					
			//Cria o controlador do arquivo
			ioManager = new IOManager(fileInput);
			
			//Pega a primeira linha >> url
			String line = ioManager.getLineInput();
			
			//Executar com Firefox
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			//WebDriver driver = new FirefoxDriver();
			
			//Iniciar Chrome driver maximizado
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
					
			driver = new ChromeDriver(options);
			
			//seta a url
			driver.navigate().to(line);
			
			//Pega a próxima linha >> usuário
			line = ioManager.getLineInput();
	
			//Cria a Página de login
			LoginPageObjetct login = new LoginPageObjetct(driver);
			
			login.txtUserName.sendKeys(line);
			
			//Pega a próxima linha >> senha
			line = ioManager.getLineInput();

			login.txtSenha.sendKeys(line);
			
			//simula o enter
			login.txtSenha.sendKeys(Keys.ENTER);
			
			//Pega a próxima linha >> CNPJ
			line = ioManager.getLineInput();
		
			HomePageObject home = new HomePageObject(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
		    wait.until(ExpectedConditions.elementToBeClickable(home.menuBoletas)).click();
		    
		    //home.menuBoletas.click();
	
			AcoesBoletaPageObject boleta = new AcoesBoletaPageObject(driver);
			
			wait.until(ExpectedConditions.elementToBeClickable(boleta.btnNovaBoleta)).click();
			
			//boleta.btnNovaBoleta.click();
			
			CriaBoletaPageObject criaBoleta = new CriaBoletaPageObject(driver);
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.inptCNPJ)).sendKeys(line);
			
			//criaBoleta.inptCNPJ.sendKeys(line);
			
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnPesquisar)).click();
			
			//criaBoleta.btnPesquisar.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnNão)).click();
			
			preencheAba1(boleta, line);
			
			preencheAba2(boleta);
			
			preencheAba3(boleta);
			
			

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {

			//fecha arquivo
			ioManager.close();
			
		}	
	}
	
	public static void preencheAba1 (AcoesBoletaPageObject boleta, String line) throws IOException {
				
		//Pega a próxima linha >> CPF
		line = ioManager.getLineInput();
		
		
		
	}
	
	
	public static void preencheAba2(AcoesBoletaPageObject boleta){

	}


	public static void preencheAba3(AcoesBoletaPageObject boleta){

	}


}
