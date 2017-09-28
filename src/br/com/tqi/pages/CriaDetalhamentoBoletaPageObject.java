package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CriaDetalhamentoBoletaPageObjects {
	
	public CriaDetalhamentoBoletaPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(name="dsRazaoSocial")
	public WebElement inputRazaoSocial;
	
	@FindBy(name="dsNomeFantasia")
	public WebElement inputNomeFantasia;
	
	@FindBy(id="input-1")
	public WebElement inputCNAE;	
	
	@FindBy(name="dtFundacao")
	public WebElement inputDataFundacao;

	@FindBy(name="dsTelefoneComercial")
	public WebElement inputTelComercial;	
	
	@FindBy(name="dsCelularComercial")
	public WebElement inputCelComercial;
	
	@FindBy(name="dsEmailComercial")
	public WebElement inputEmailComercial;
	
	@FindBy(name="nmContatoComercial")
	public WebElement inputContatoComercial;
	
	@FindBy(name="dsEmailSenha")
	public WebElement inputEmailSenha;
	
	@FindBy(name="nrTelefoneSenha")
	public WebElement inputTelSenha;
	
	@FindBy(name="nrTipoEndereco")
	public WebElement selectNrTipoEndereco;
	
	@FindBy(name="cdCep")
	public WebElement inputCEP;
	
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-scope > div > ng-form > div:nth-child(3) > div.panel-body > ng-form > div > div > div:nth-child(2) > div.col-md-3 > div > button.btn.table-btn.btn-success.btn-grid-fix")
	public WebElement btnAdicionarEnd;
	
	@FindBy(name="dsNome")
	public WebElement inputNome;
	
	@FindBy(name="cdCpf")
	public WebElement inputCPF;
	
	@FindBy(name="pcParticipacao")
	public WebElement inputPart;
	
	@FindBy(name="dtNascimento")
	public WebElement inputDataNascimento;
	
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-scope > div > ng-form > div.ng-scope > div.panel.panel-default > div.panel-body > ng-form > div > div:nth-child(6) > div > button.btn.table-btn.btn-success.btn-grid-fix")
	public WebElement btnAdicionarAcionista;
	
	@FindBy(name="nrFaturamentoLoja")
	public WebElement inputFaturamento;
	
	@FindBy(name="qtdCheckoutsLoja")
	public WebElement inputQtdChkLoja;

	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-scope > div > ng-form > div.ng-scope > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div.panel-body > div:nth-child(1) > div.col-md-6.ng-scope > div > input")
	public WebElement chkContaDigital;

	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-scope > div > ng-form > div.ng-scope > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div.panel-body > div:nth-child(1) > div:nth-child(1) > div > input")
	public WebElement chkContaAbertura;
	
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-isolate-scope > ul > li:nth-child(2) > a > uib-tab-heading > span")
	public WebElement abaCondicoesComerciais;
	
	
	

}




















