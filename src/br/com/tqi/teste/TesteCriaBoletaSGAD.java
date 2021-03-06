package br.com.tqi.teste;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
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
import br.com.tqi.utils.JSWaiter;

public class TesteCriaBoletaSGAD {

	static FileUtils file;

	static WebDriver driver;

	static WebDriverWait wait;

	static JSWaiter jSWaiter;

	public static void main(String[] args) throws IOException, InterruptedException {

		try {

			file = new FileUtils(args[0]);

			// Executar com Firefox
			// System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			// WebDriver driver = new FirefoxDriver();

			// Iniciar Chrome driver maximizado
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");

			// Set caminho onde est� o driver do Chrome
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

			// Inicia chorme
			driver = new ChromeDriver(options);

			// Abre a p�gina inicial do sistema
			driver.navigate().to(file.getValue("url"));

			// Seta driver para p�gina que controla t�rmino dos loadings
			JSWaiter.setDriver(driver);

			LoginPageObjetct login = new LoginPageObjetct(driver);

			JSWaiter.waitJQueryAngular();

			login.txtUserName.sendKeys(file.getValue("user"));

			login.txtSenha.sendKeys(file.getValue("pwd"));

			login.txtSenha.sendKeys(Keys.ENTER);

			HomePageObject home = new HomePageObject(driver);

			// Aguarda 50s para atender a condi��o esperada
			wait = new WebDriverWait(driver, 50);

			JSWaiter.waitJQueryAngular();

			// Clica no menu Boletas
			wait.until(ExpectedConditions.elementToBeClickable(home.menuBoletas)).click();

			JSWaiter.waitJQueryAngular();

			AcoesBoletaPageObject boleta = new AcoesBoletaPageObject(driver);

			wait.until(ExpectedConditions.elementToBeClickable(boleta.btnNovaBoleta)).click();

			CriaBoletaPageObject criaBoleta = new CriaBoletaPageObject(driver);

			JSWaiter.waitJQueryAngular();

			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.inputCNPJ)).sendKeys(file.getValue("cnpj"));

			JSWaiter.waitJQueryAngular();

			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnPesquisar)).click();

			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnN�o)).click();

			JSWaiter.waitJQueryAngular();

			CriaDetalhamentoBoletaPageObject criaDetalhamento = new CriaDetalhamentoBoletaPageObject(driver);

			JSWaiter.waitJQueryAngular();

			preencheAbaDadosEstabelecimento(criaDetalhamento, file);

			preencheAbaCondicoesComerciais(criaDetalhamento);

			preencheAbaEquipamentos(criaDetalhamento);
			
			// Simula movimento de passar o mouse sobre o menu da boleta - mouseover
			Actions actionAcoesBoleta = new Actions(driver);
			actionAcoesBoleta.moveToElement(criaDetalhamento.btnAcoesBoleta).build().perform();

			JSWaiter.waitJQueryAngular();

			criaDetalhamento.btnEnviarBoleta.click();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			JSWaiter.waitJQueryAngular();

			// Aguarda 5 segundos antes de fechar o browser, ap�s enviar a boleta
			Thread.sleep(5000);

			driver.quit();

		}
	}

	public static void preencheAbaDadosEstabelecimento(CriaDetalhamentoBoletaPageObject criaDetalhamento,
			FileUtils file) throws IOException, InterruptedException, AWTException {

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputRazaoSocial)).sendKeys("Teste Automa��o - Rodrigo");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputNomeFantasia)).sendKeys("Teste Automa��o - Rodrigo");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCNAE)).sendKeys("4711302 - com�rcio varejista de mercadorias em geral, com predomin�ncia de produtos aliment�cios  supermercados");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputDataFundacao)).sendKeys("27/09/2017");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputTelComercial)).sendKeys("3432224455");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCelComercial)).sendKeys("34992211444");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputEmailComercial)).sendKeys("teste@teste.de");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputContatoComercial)).sendKeys("Rodrigo Magalh�es");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputEmailSenha)).sendKeys("teste@teste.fr");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCelSenha)).sendKeys("99999222222");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.selectTipoEndereco)).sendKeys("Comercial");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCEP)).sendKeys("38408220");

		criaDetalhamento.inputCEP.sendKeys(Keys.TAB);

		JSWaiter.waitJQueryAngular();

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.btnAdicionarEnd)).click();
		
		// Aguarda alert desaparecer
	    wait.until((ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(criaDetalhamento.msgAlert)))));
	
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputNome)).sendKeys("Rodrigo Ribeiro");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputCPF)).sendKeys(file.getValue("cpf"));

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputPart)).sendKeys("100,00");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputDataNascimento)).sendKeys("11/11/1945");
		
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.btnAdicionarAcionista)).click();

		// Aguarda alert desaparecer
		wait.until((ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(criaDetalhamento.msgAlert)))));
						
		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputFaturamento)).sendKeys("999999999,88");

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.inputQtdChkLoja)).sendKeys("3");

		JSWaiter.waitJQueryAngular();

		criaDetalhamento.chkContaDigital.click();

		JSWaiter.waitJQueryAngular();

		criaDetalhamento.chkContaAbertura.click();

		JSWaiter.waitJQueryAngular();

		// localiza a posi��o do elemento, tornando o elemento vis�vel
		((Locatable) criaDetalhamento.abaCondicoesComerciais).getCoordinates().inViewPort();
		try {
			// tenta clicar na aba, se n�o conseguir, sobe a p�gina e tenta novamente
			criaDetalhamento.abaCondicoesComerciais.click();
			JSWaiter.waitJQueryAngular();
		} catch (Exception e) {
			//sobre para topo da p�gina
			new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
			JSWaiter.waitJQueryAngular();
			criaDetalhamento.abaCondicoesComerciais.click();
		}

		JSWaiter.waitJQueryAngular();

	}

	public static void preencheAbaCondicoesComerciais(CriaDetalhamentoBoletaPageObject criaDetalhamento) throws InterruptedException {

		Select select = new Select(criaDetalhamento.selectProduto);
		select.selectByVisibleText("TRICARD MAIS ADQUIRENCIA (ACEITA��O)");

		JSWaiter.waitJQueryAngular();

		wait.until(ExpectedConditions.elementToBeClickable(criaDetalhamento.btnAddProduto)).click();
		
		// Aguarda alert desaparecer
		wait.until((ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(criaDetalhamento.msgAlert)))));
		
		JSWaiter.waitJQueryAngular();

		// localiza a posi��o do elemento, tornando o elemento vis�vel
		((Locatable) criaDetalhamento.abaEquipamentos).getCoordinates().inViewPort();
		try {
			// tenta clicar na aba, se n�o conseguir, sobe a p�gina e tenta novamente
			criaDetalhamento.abaEquipamentos.click();
		} catch (Exception e) {
			new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
			JSWaiter.waitJQueryAngular();
			criaDetalhamento.abaEquipamentos.click();
		}

		JSWaiter.waitJQueryAngular();

	}

	public static void preencheAbaEquipamentos(CriaDetalhamentoBoletaPageObject criaDetalhamento) throws InterruptedException {

		JSWaiter.waitJQueryAngular();

		Select select = new Select(criaDetalhamento.selectMeioConexao);
		select.selectByVisibleText("DIAL");

		Select selectTL = new Select(criaDetalhamento.selectTipoLinha);
		selectTL.selectByVisibleText("Direta");

		Select selectModelo = new Select(criaDetalhamento.selectModelo);
		selectModelo.selectByVisibleText("POS com fio");

		criaDetalhamento.inputQtd.sendKeys("1");

		criaDetalhamento.btnAddEquipamento.click();
		
		// Aguarda alert desaparecer
		wait.until((ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(criaDetalhamento.msgAlert)))));
		
		JSWaiter.waitJQueryAngular();

		criaDetalhamento.btnSalvarEquipamento.click();

		JSWaiter.waitJQueryAngular();

	}

}
