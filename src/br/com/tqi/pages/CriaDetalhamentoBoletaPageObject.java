package br.com.tqi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CriaDetalhamentoBoletaPageObject {
	
	public CriaDetalhamentoBoletaPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="#containerMain > div > div > div > section > div > div")
	public WebElement topo;
	
	@FindBy(css="body > div.block-ui-container.ng-scope > div.block-ui-message-container > div.block-ui-message.ng-binding > text")
	public WebElement msgCarregando;	
	
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
	public WebElement inputCelSenha;
	
	@FindBy(name="nrTipoEndereco")
	public WebElement selectTipoEndereco;
	
	@FindBy(name="cdCep")
	public WebElement inputCEP;
	
	@FindBy(name="dsBairro")
	public WebElement inputBairro;
	
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
	
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-scope > div > ng-form > div.ng-scope > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div.panel-body > div:nth-child(1) > div:nth-child(1) > div > label")
	public WebElement label;
	
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-isolate-scope > ul > li:nth-child(2) > a > uib-tab-heading")
	public WebElement abaCondicoesComerciais;
	
	//----------------------------------------------------------/Aba Condições Comerciais/---------------------------------------------//
	
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-scope > div > div:nth-child(3) > div.panel-body > div.row.ng-scope > div > div > select")
	public WebElement selectProduto;
	             
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-scope > div > ng-form > div > div > div.panel-body > div:nth-child(2) > div.col-md-2 > button")
	public WebElement btnAddProduto;
	
	@FindBy(css="#conteudo-gerenciar-boleta > div.ng-isolate-scope > ul > li:nth-child(3) > a")
	public WebElement abaEquipamentos;
	
	
	//----------------------------------------------------------/Aba Equipamentoss-------/---------------------------------------------//

	@FindBy(css="div > ng-form > div:nth-child(1) > div:nth-child(1) > div > select")             
	public WebElement selectMeioConexao;
	
	@FindBy(css="div > ng-form > div:nth-child(1) > div.col-md-3 > div > select")
	public WebElement selectTipoLinha;
	
	@FindBy(css="div > ng-form > div:nth-child(2) > div:nth-child(1) > div > select")
	public WebElement selectModelo;
	
	@FindBy(css="div > ng-form > div:nth-child(2) > div:nth-child(2) > div > input")
	public WebElement inputQtd;
	
	@FindBy(css="div > ng-form > div:nth-child(2) > div.col-md-1.col-md-offset-7 > div > div > button")
	public WebElement btnAddEquipamento;
	
	@FindBy(css="div > div:nth-child(4) > div > div > button.btn.btn-success.btn-grid-fix")
	public WebElement btnSalvarEquipamento;
	
	@FindBy(css="#containerMain > div > div > div > section > div > div > div.conteudo.conteudo-fix-boleta > nav > ul > li:nth-child(4) > ul > li > a > i.mfb-component__main-icon--active.fa.fa-arrow-circle-up.fa-lg")
	public WebElement btnAcoesBoleta;
		
	@FindBy(css="#containerMain > div > div > div > section > div > div > div.conteudo.conteudo-fix-boleta > nav > ul > li:nth-child(4) > ul > li > ul > li:nth-child(3) > a > i")
	public WebElement btnEnviarBoleta;
	
	
}






















