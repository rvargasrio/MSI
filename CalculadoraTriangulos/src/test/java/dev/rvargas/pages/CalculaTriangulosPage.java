package dev.rvargas.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import dev.rvargas.common.BasePage;

public class CalculaTriangulosPage extends BasePage {

	final String LADO1 = "lado1";
	final String LADO2 = "lado2";
	final String LADO3 = "lado3";
	final String CALCULAR = "calcular";
	final String MSG_TIPO_TRIANGULO = "message";
	final String MSG_VALOR_DECIMAL = "Insira um valor válido. Os dois valores válidos mais próximos são 10 e 11.";

	public void verificarElementosTela() {
		validarTitulo("Calculadora de Triângulos");
		elementoVisivel(By.id(LADO1));
		elementoVisivel(By.id(LADO2));
		elementoVisivel(By.id(LADO3));
		elementoVisivel(By.id(CALCULAR));
	}

	public void informarLadosTriangulo(String lado1, String lado2, String lado3) {
		escrever(By.id(LADO1), lado1);
		escrever(By.id(LADO2), lado2);
		escrever(By.id(LADO3), lado3);
	}

	public void efetivarCalculo() {
		click(By.id(CALCULAR));
	}

	public void validarCalculo(String classificação) {
		String classificacaoTriangulo = obterTexto(By.id(MSG_TIPO_TRIANGULO));
		Assert.assertEquals(classificacaoTriangulo, classificação);
	}

	public void validarErroCalculo(String mensagem) {
		String MSG_ERRO = obterTexto(By.id(MSG_TIPO_TRIANGULO));
		Assert.assertEquals(MSG_ERRO, mensagem);
	}

	public void validarErroLadoDecimal(String mensagem) {
		Assert.assertEquals(MSG_VALOR_DECIMAL, mensagem);
	}

}
