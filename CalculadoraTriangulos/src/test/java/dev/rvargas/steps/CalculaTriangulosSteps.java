package dev.rvargas.steps;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import dev.rvargas.pages.CalculaTriangulosPage;


public class CalculaTriangulosSteps {
	
	CalculaTriangulosPage page = new CalculaTriangulosPage();
	
	@Dado("^que devo calcular os três lados de um triangulo$")
	public void queDevoCalcularOsTresLadosDeUmTriangulo() {
		page.iniciarWebDriver();
		page.goToUrl();
		page.verificarElementosTela();
	}

	@Quando("^informo lados iguais \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" e efetivo o calculo$")
	public void informoTresLadosIguaisEfetivoOCalculo(String lado1, String lado2, String lado3) {
		page.informarLadosTriangulo(lado1, lado2, lado3);
		page.efetivarCalculo();
	}
	
	@Quando("^informo tres lados diferentes \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" e efetivo o calculo$")
	public void informoTresLadosDiferentesEfetivoOCalculo(String lado1, String lado2, String lado3){
		page.informarLadosTriangulo(lado1, lado2, lado3);
		page.efetivarCalculo();
	}
	
	@Quando("^informo dois lados iguais \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" e efetivo o calculo$")
	public void informoDoisLadosIguaisEUmDiferenteEfetivoOCalculo(String valor1, String valor2, String valor3) {
		page.informarLadosTriangulo(valor1, valor2, valor3);
		page.efetivarCalculo();
	}
	
	@Quando("^nao informo valores e efetivo o cálculo$")
	public void naoInformoValoresEfetivoOCalculo() {
		page.efetivarCalculo();
	}
	
	@Quando("^informo valor decimal \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" e efetivo o calculo$")
	public void informoValorDecimalEfetivoOCalculo(String valor1, String valor2, String valor3) {
		page.informarLadosTriangulo(valor1, valor2, valor3);
		page.efetivarCalculo();
	}

	@Então("^sistema retorna mensagem informando a classificação \"([^\"]*)\"$")
	public void sistemaRetornaMensagemInformandoClassificacao(String classificação){
		page.validarCalculo(classificação);
	}
	
	@Então("^sistema retorna mensagem de erro \"([^\"]*)\"$")
	public void validarMensagemErro(String message) {
		page.validarErroCalculo(message);
	}
	
	@Então("^sistema retorna alerta de erro \"([^\"]*)\"$")
	public void validarAlertaDeErro(String mensagem) {
		page.validarErroLadoDecimal(mensagem);
	}

	@After()
	public void encerrarNavegador() {
		page.encerrarWebDriver();
	}
}