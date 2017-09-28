package br.com.tqi.teste;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.tqi.pages.LoginPageObjetct;
import br.com.tqi.utils.IOManager;


public class CriaBoletaSGAD {
	
	static IOManager ioManager;
	static WebDriver driver; 

	public static void main(String[] args) throws IOException {
		
		try {
			
			//Recebe o arquivo config.txt que é setado em Run Configurations >> Arguments
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
			
			//Pega a próxima linha >> texto a ser buscado
			line = ioManager.getLineInput();
			
			//Cria a Página de login
			LoginPageObjetct login = new LoginPageObjetct(driver);
			
			// seta o valor a ser pesquisado no campo de pesquisa do google
			login.txtUser.sendKeys(line);
			
			//login.btnSearch.click();
			
			//simula o enter
			login.txtUser.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {

			// fecha conexões
			ioManager.close();
			
		}	
	}


}
