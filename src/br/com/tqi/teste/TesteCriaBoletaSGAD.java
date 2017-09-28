package br.com.tqi.teste;

import java.io.IOException;

import org.openqa.selenium.By;
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
import br.com.tqi.utils.IOManager;


public class TesteCriaBoletaSGAD {
	
	static IOManager ioManager;
	static WebDriver driver; 
	
	//static WebDriverWait wait = new WebDriverWait(driver, 50);

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
			
			Thread.sleep(3000);
			
			login.txtUserName.sendKeys(line);
			
			//Pega a próxima linha >> senha
			line = ioManager.getLineInput();

			login.txtSenha.sendKeys(line);
			
			//simula o enter
			login.txtSenha.sendKeys(Keys.ENTER);
			
			//Pega a próxima linha >> CNPJ
			line = ioManager.getLineInput();
		
			HomePageObject home = new HomePageObject(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
			wait.until(ExpectedConditions.elementToBeClickable(home.menuBoletas)).click();

			AcoesBoletaPageObject boleta = new AcoesBoletaPageObject(driver);
			
			wait.until(ExpectedConditions.elementToBeClickable(boleta.btnNovaBoleta)).click();
			
			CriaBoletaPageObject criaBoleta = new CriaBoletaPageObject(driver);
			
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.inptCNPJ)).sendKeys(line);
			
			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnPesquisar)).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(criaBoleta.btnNão)).click();
			
			CriaDetalhamentoBoletaPageObject criaDetalhamento = new CriaDetalhamentoBoletaPageObject(driver);
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.block-ui-container.ng-scope > div.block-ui-message-container > div.block-ui-message.ng-binding")));
			
			Thread.sleep(15000);			
			
			preencheAbaDadosEstabelecimento(criaDetalhamento, line);
			
			preencheAbaCondicoesComerciais(criaDetalhamento);
			
			preencheAbaEquipamentos(criaDetalhamento);
			
			criaDetalhamento.btnEnviarBoleta.click();			
			

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {

			//fecha arquivo
			ioManager.close();
			
		}	
	}
	
	public static void preencheAbaDadosEstabelecimento(CriaDetalhamentoBoletaPageObject criaDetalhamento, String line) throws IOException, InterruptedException {
				
		//Pega a próxima linha >> CPF
		line = ioManager.getLineInput();
		
		criaDetalhamento.inputRazaoSocial.sendKeys("Teste Automação - Rodrigo");
		criaDetalhamento.inputNomeFantasia.sendKeys("Teste Automação - Rodrigo");
		criaDetalhamento.inputCNAE.sendKeys("4711302 -  Comércio varejista de mercadorias em geral, com predominƒncia de produtos alimentícios  supermercados");
		criaDetalhamento.inputDataFundacao.sendKeys("27/09/2017");
		criaDetalhamento.inputTelComercial.sendKeys("3432224455");
		criaDetalhamento.inputCelComercial.sendKeys("34992211444");
		criaDetalhamento.inputEmailComercial.sendKeys("teste@teste.de");
		criaDetalhamento.inputContatoComercial.sendKeys("Rodrigo Magalhães");
		criaDetalhamento.inputEmailSenha.sendKeys("teste@teste.fr");
		criaDetalhamento.inputCelSenha.sendKeys("99999222222");
		criaDetalhamento.selectTipoEndereco.sendKeys("Comercial");
		criaDetalhamento.inputCEP.sendKeys("38408220");
		criaDetalhamento.selectTipoEndereco.click();
		
		Thread.sleep(15000);
		
		criaDetalhamento.btnAdicionarEnd.click();
		
		criaDetalhamento.inputNome.sendKeys("Rodrigo Ribeiro");
		criaDetalhamento.inputCPF.sendKeys(line);
		criaDetalhamento.inputPart.sendKeys("100");
		criaDetalhamento.inputDataNascimento.sendKeys("11/11/1945");
		
		criaDetalhamento.btnAdicionarAcionista.click();
		
		criaDetalhamento.inputFaturamento.sendKeys("999999999,88");
		criaDetalhamento.inputQtdChkLoja.sendKeys("3");
		
		Thread.sleep(2000);
		
		criaDetalhamento.chkContaDigital.click();
		
		Thread.sleep(5000);
		
		criaDetalhamento.chkContaAbertura.click();
		
		Thread.sleep(5000);
		
		criaDetalhamento.abaCondicoesComerciais.click();	
		
		Thread.sleep(5000);
		
	}	
	
	public static void preencheAbaCondicoesComerciais(CriaDetalhamentoBoletaPageObject criaDetalhamento) {
		
		criaDetalhamento.selectProduto.sendKeys("TRICARD MAIS ADQUIRENCIA (ACEITAÇÃO)");
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


}













