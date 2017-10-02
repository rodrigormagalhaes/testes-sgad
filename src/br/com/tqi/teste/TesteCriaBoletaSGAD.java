package br.com.tqi.teste;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	//static WebDriverWait wait = new WebDriverWait(driver, 50);

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
	
			//Cria a P�gina de login
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
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnN�o)).click();
			
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
		criaDetalhamento.inputRazaoSocial.sendKeys("Teste Automa��o - Rodrigo");	
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputNomeFantasia));			
		criaDetalhamento.inputNomeFantasia.sendKeys("Teste Automa��o - Rodrigo");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCNAE));	
		criaDetalhamento.inputCNAE.sendKeys("4711302 - com�rcio varejista de mercadorias em geral, com predomin�ncia de produtos aliment�cios  supermercados");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputDataFundacao));	
		criaDetalhamento.inputDataFundacao.sendKeys("27/09/2017");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputTelComercial));	
		criaDetalhamento.inputTelComercial.sendKeys("3432224455");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCelComercial));	
		criaDetalhamento.inputCelComercial.sendKeys("34992211444");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputEmailComercial));	
		criaDetalhamento.inputEmailComercial.sendKeys("teste@teste.de");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputContatoComercial));	
		criaDetalhamento.inputContatoComercial.sendKeys("Rodrigo Magalh�es");
		
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

//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		 
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		
//		((JavascriptExecutor) driver).executeScript("scroll(0,0)");
//		

		
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		
//		new Actions(driver).sendKeys(driver.findElement(By.tagName("html")), Keys.CONTROL).sendKeys(driver.findElement(By.tagName("html")),Keys.NUMPAD2).build().perform();
		
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
//	    WebElement e = driver.findElement(By
//	            .xpath("//*[@id=\"conteudo-gerenciar-boleta\"]/div[1]/ul/li[2]/a/uib-tab-heading"));
//	e.sendKeys(selectLinkOpeninNewTab);//to open the link in a current page in to the browsers new tab
//
//	    e.sendKeys(Keys.CONTROL + "\t");//to move focus to next tab in same browser

//		WebElement eSupplierSuggest = driver.findElement(By.xpath("//*[@id=\"conteudo-gerenciar-boleta\"]/div[1]/ul/li[2]/a/uib-tab-heading"));
//		Point location = eSupplierSuggest.getLocation();
//		new Actions(driver).moveToElement(eSupplierSuggest, location.x, location.y).click();
//		
//		new Actions(driver).moveToElement(eSupplierSuggest).click().perform();
//		
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		
//		//js.executeScript(arg0, arg1)
		
//		criaDetalhamento.topo.sendKeys(Keys.HOME);
		
//		Actions builder = new Actions(driver);   
//		builder.moveToElement(criaDetalhamento.topo, -100, -200).click().build().perform();
		
//		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.abaCondicoesComerciais));
//		criaDetalhamento.abaCondicoesComerciais.click();	
											   
		driver.navigate().to(file.getValue("urlAbaCondicoesComerciais"));
		
		checkPageIsReady();
		
	}	
	
	public static void preencheAbaCondicoesComerciais(CriaDetalhamentoBoletaPageObject criaDetalhamento) {
		
		criaDetalhamento.selectProduto.sendKeys("TRICARD MAIS ADQUIRENCIA (ACEITA��O)");
		criaDetalhamento.btnAddProduto.click();
		
		criaDetalhamento.abaEquipamentos.click();		

	}

	public static void preencheAbaEquipamentos(CriaDetalhamentoBoletaPageObject criaDetalhamento) {
		
		criaDetalhamento.selectMeioConexao.sendKeys("DIAL");
		criaDetalhamento.selectTipoLinha.sendKeys("Direta");
		criaDetalhamento.selectModelo.sendKeys("POS com fio");
		criaDetalhamento.inputQtd.sendKeys("1");
		
		criaDetalhamento.btnAddEquipamento.click();
		
		criaDetalhamento.btnSalvarEquipamento.click();

	}
	
	
	public static void checkPageIsReady() throws InterruptedException {

		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			Thread.sleep(2000);
			System.out.println("Page Is loaded.");
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
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//
//		wait.until(new ExpectedCondition<Boolean>() {
//			public Boolean apply(WebDriver wdriver) {
//				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//			}
//		});
	}
	
	
	
	


}













