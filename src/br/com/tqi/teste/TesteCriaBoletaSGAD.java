package br.com.tqi.teste;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tqi.pages.AcoesBoletaPageObject;
import br.com.tqi.pages.CriaBoletaPageObject;
import br.com.tqi.pages.CriaDetalhamentoBoletaPageObject;
import br.com.tqi.pages.HomePageObject;
import br.com.tqi.pages.LoginPageObjetct;
import br.com.tqi.utils.FileUtils;


public class TesteCriaBoletaSGAD {
	
	static FileUtils file;
	
	static WebDriver driver; 
	
	static WebDriverWait wait;
	
	public static void main(String[] args) throws IOException {
		
		try {
								
			file = new FileUtils(args[0]); 			
			
			//Executar com Firefox
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			//WebDriver driver = new FirefoxDriver();
			
			//Iniciar Chrome driver maximizado
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
					
			driver = new ChromeDriver(options);

			driver.navigate().to(file.getValue("url"));
	
			//Cria a Página de login
			LoginPageObjetct login = new LoginPageObjetct(driver);
			
			checkPageIsReady();
			
			login.txtUserName.sendKeys(file.getValue("user"));
			
			login.txtSenha.sendKeys(file.getValue("pwd"));
			
			//simula o enter
			login.txtSenha.sendKeys(Keys.ENTER);
		
			HomePageObject home = new HomePageObject(driver);
			
			wait = new WebDriverWait(driver, 50);
			
			wait.until(ExpectedConditions.elementToBeClickable(home.menuBoletas));
			
			checkPageIsReady();
			
			home.menuBoletas.click();

			AcoesBoletaPageObject boleta = new AcoesBoletaPageObject(driver);
			
			wait.until(ExpectedConditions.elementToBeClickable(boleta.btnNovaBoleta));
			
			checkPageIsReady();
			
			boleta.btnNovaBoleta.click();
			
			CriaBoletaPageObject criaBoleta = new CriaBoletaPageObject(driver);
			
			checkPageIsReady();
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.inputCNPJ));
		
			criaBoleta.inputCNPJ.sendKeys(file.getValue("cnpj"));
			
			checkPageIsReady();
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnPesquisar));
			
			criaBoleta.btnPesquisar.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnNão)).click();
			
			checkPageIsReady();
			
			CriaDetalhamentoBoletaPageObject criaDetalhamento = new CriaDetalhamentoBoletaPageObject(driver);
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.block-ui-container.ng-scope > div.block-ui-message-container > div.block-ui-message.ng-binding")));
			
			checkPageIsReady();
			
			preencheAbaDadosEstabelecimento(criaDetalhamento, file);
			
			preencheAbaCondicoesComerciais(criaDetalhamento);
			
			preencheAbaEquipamentos(criaDetalhamento);
			
			criaDetalhamento.btnEnviarBoleta.click();			
			

		} catch (Exception e) {
			
			e.printStackTrace();

		} 
	}
	
	public static void preencheAbaDadosEstabelecimento(CriaDetalhamentoBoletaPageObject criaDetalhamento, FileUtils file) throws IOException, InterruptedException, AWTException {

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputRazaoSocial));		
		criaDetalhamento.inputRazaoSocial.sendKeys("Teste Automação - Rodrigo");	
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputNomeFantasia));			
		criaDetalhamento.inputNomeFantasia.sendKeys("Teste Automação - Rodrigo");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCNAE));	
		criaDetalhamento.inputCNAE.sendKeys("4711302 - comércio varejista de mercadorias em geral, com predominƒncia de produtos alimentícios  supermercados");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputDataFundacao));	
		criaDetalhamento.inputDataFundacao.sendKeys("27/09/2017");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputTelComercial));	
		criaDetalhamento.inputTelComercial.sendKeys("3432224455");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCelComercial));	
		criaDetalhamento.inputCelComercial.sendKeys("34992211444");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputEmailComercial));	
		criaDetalhamento.inputEmailComercial.sendKeys("teste@teste.de");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputContatoComercial));	
		criaDetalhamento.inputContatoComercial.sendKeys("Rodrigo Magalhães");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputEmailSenha));	
		criaDetalhamento.inputEmailSenha.sendKeys("teste@teste.fr");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCelSenha));	
		criaDetalhamento.inputCelSenha.sendKeys("99999222222");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.selectTipoEndereco));	
		criaDetalhamento.selectTipoEndereco.sendKeys("Comercial");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCEP));	
		criaDetalhamento.inputCEP.sendKeys("38408220");
		
		criaDetalhamento.inputCEP.sendKeys(Keys.TAB);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.block-ui-container.ng-scope > div.block-ui-message-container > div.block-ui-message.ng-binding")));
		
		checkPageIsReady();
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.btnAdicionarEnd));			
		criaDetalhamento.btnAdicionarEnd.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputNome));
		criaDetalhamento.inputNome.sendKeys("Rodrigo Ribeiro");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCPF));
		criaDetalhamento.inputCPF.sendKeys(file.getValue("cpf"));
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCPF));
		criaDetalhamento.inputPart.sendKeys("100");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputDataNascimento));
		criaDetalhamento.inputDataNascimento.sendKeys("11/11/1945");		
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.btnAdicionarAcionista));
		criaDetalhamento.btnAdicionarAcionista.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputFaturamento));
		criaDetalhamento.inputFaturamento.sendKeys("999999999,88");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputQtdChkLoja));
		criaDetalhamento.inputQtdChkLoja.sendKeys("3");

		checkPageIsReady();

		criaDetalhamento.chkContaDigital.click();

		checkPageIsReady();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.block-ui-container.ng-scope > div.block-ui-message-container > div.block-ui-message.ng-binding")));

		criaDetalhamento.label.click();
		criaDetalhamento.chkContaAbertura.click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.block-ui-container.ng-scope > div.block-ui-message-container > div.block-ui-message.ng-binding")));
		
		checkPageIsReady();
		
		Thread.sleep(3000);
		
		((Locatable) criaDetalhamento.abaCondicoesComerciais).getCoordinates().inViewPort();
		try {
			criaDetalhamento.abaCondicoesComerciais.click();
			checkPageIsReady();
		} catch (Exception e) {
			new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
			criaDetalhamento.abaCondicoesComerciais.click();
		}
		
		checkPageIsReady();
		
	}	
	
	public static void preencheAbaCondicoesComerciais(CriaDetalhamentoBoletaPageObject criaDetalhamento) throws InterruptedException {
		
		Select select = new Select(criaDetalhamento.selectProduto);
		select.selectByVisibleText("TRICARD MAIS ADQUIRENCIA (ACEITAÇÃO)");
				
		checkPageIsReady();
		
		criaDetalhamento.btnAddProduto.click();
		
		checkPageIsReady();
		
		((Locatable) criaDetalhamento.abaEquipamentos).getCoordinates().inViewPort();
		try {
			criaDetalhamento.abaEquipamentos.click();
		} catch (Exception e) {
			new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
			criaDetalhamento.abaEquipamentos.click();
		}

		checkPageIsReady();

	}

	public static void preencheAbaEquipamentos(CriaDetalhamentoBoletaPageObject criaDetalhamento) throws InterruptedException {
		
		checkPageIsReady();
		
		Select select = new Select(criaDetalhamento.selectMeioConexao);
		select.selectByVisibleText("DIAL");

		Select selectTL = new Select(criaDetalhamento.selectTipoLinha);
		selectTL.selectByVisibleText("Direta");

		Select selectModelo = new Select(criaDetalhamento.selectModelo);
		selectModelo.selectByVisibleText("POS com fio");
	
		criaDetalhamento.inputQtd.sendKeys("1");
		
		criaDetalhamento.btnAddEquipamento.click();
		
		checkPageIsReady();
		
		criaDetalhamento.btnSalvarEquipamento.click();
		
		checkPageIsReady();

	}
	
	
	public static void checkPageIsReady() throws InterruptedException {

		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			Thread.sleep(2000);
			System.out.println("Página carregada");
			return;
		}

		// This loop will rotate for 25 times to check If page Is ready after every 1 second.
		// You can replace your value with 25 If you wants to Increase or decrease wait time.
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				Thread.sleep(2000);
				break;
			}
		}

	}

}













