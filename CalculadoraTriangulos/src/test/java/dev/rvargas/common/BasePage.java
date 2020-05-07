package dev.rvargas.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static final String URL = "https://calculadoratriangulo.herokuapp.com";
	private static WebDriver _driver;

	public void iniciarWebDriver() {
		if (_driver == null) {
			WebDriverManager.chromedriver().version("81.0.4044.138").setup();
			_driver = new ChromeDriver();
		}
	}

	public void goToUrl() {
		_driver.get(URL);
	}

	public void aguardarVisibilidadeElemento(WebElement element) {
		new WebDriverWait(_driver, 10).until(ExpectedConditions.visibilityOf(element));
	}

	public void escrever(By by, String value) {
		try {
			aguardarVisibilidadeElemento((_driver.findElement(by)));
			_driver.findElement(by).clear();
			_driver.findElement(by).sendKeys(value);
		} catch (WebDriverException e) {
			Assert.fail("Elemento não localizado.");
		}
	}

	public void validarTitulo(String esperado) {
		String title = _driver.getTitle();
		Assert.assertEquals(esperado, title);
	}

	public String obterTexto(By by) {
		if (!elementoVisivel(by)) {
			Assert.fail("Texto não localizado.");
		}
		return _driver.findElement(by).getText();
	}

	public void click(By by) {
		try {
			aguardarVisibilidadeElemento((_driver.findElement(by)));
			_driver.findElement(by).click();
		} catch (Exception e) {
			Assert.fail("Elemento não localizado.");
		}
	}

	public boolean elementoVisivel(By by) {
		try {
			return _driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void encerrarWebDriver() {
		if (_driver != null) {
			_driver.quit();
			_driver = null;
		}
	}
}