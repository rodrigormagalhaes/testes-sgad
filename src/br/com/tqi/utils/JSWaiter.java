package br.com.tqi.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Respons�vel por validar t�rmino de carregamento de p�ginas usando JS, JQuery ou Angular
 *
 */
public class JSWaiter {

	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;

	public static void setDriver(WebDriver driver) {
		jsWaitDriver = driver;
		jsWait = new WebDriverWait(jsWaitDriver, 10);
		jsExec = (JavascriptExecutor) jsWaitDriver;
	}

	// Aguarda carregamento JQuery
	public static void waitForJQueryLoad() {
		// Verifica se j� carregou
		ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) jsWaitDriver)
				.executeScript("return jQuery.active") == 0);

		// Verifica se j� carregou
		boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

		// Verifica se j� carregou
		if (!jqueryReady) {
			System.out.println("JQuery N�O terminou!");
			// Aguarda at� JQuery terminar processamento
			jsWait.until(jQueryLoad);
		} else {
			System.out.println("JQuery terminou!");
		}
	}

	// Aguarda carregamento do Angular
	public static void waitForAngularLoad() {
		
		//timeout de 1 min
		WebDriverWait wait = new WebDriverWait(jsWaitDriver, 60);
		
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		// Verifica se j� carregou
		ExpectedCondition<Boolean> angularLoad = driver -> Boolean
				.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());

		// Verifica se j� carregou
		boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

		// Verifica se j� carregou
		if (!angularReady) {
			System.out.println("ANGULAR N�O terminou!");
			// Aguarda carregamento do Angular
			wait.until(angularLoad);
		} else {
			System.out.println("ANGULAR terminou!");
		}
	}

	// Aguarda JS terminar carregamento
	public static void waitUntilJSReady() {
		
		//timeout de 1 min
		WebDriverWait wait = new WebDriverWait(jsWaitDriver, 60);
		
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// Verifica se j� carregou
		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) jsWaitDriver)
				.executeScript("return document.readyState").toString().equals("complete");

		// Verifica se j� carregou
		boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

		// Verifica se j� carregou
		if (!jsReady) {
			System.out.println("JS N�O terminou!");
			// Aguarda JS terminar carregamento
			wait.until(jsLoad);
		} else {
			System.out.println("JS terminou!");
		}
	}

	// Aguardar at� JQuery e JS terminar carregamento
	public static void waitUntilJQueryReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// Verifica se JQuery est� definido na p�gina
		Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined == true) {

			sleep(20);

			// Aguarda JQuery terminar
			waitForJQueryLoad();

			// Aguarda JS terminar
			waitUntilJSReady();

			sleep(20);
		} else {
			System.out.println("jQuery n�o est� definido na p�gina!");
		}
	}

	// Aguarda at� Angular e JS terminar carregamento
	public static void waitUntilAngularReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// Verifica se Angular � usado na p�gina, se sim aguarda Angular carregar
		Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
		if (!angularUnDefined) {
			Boolean angularInjectorUnDefined = (Boolean) jsExec
					.executeScript("return angular.element(document).injector() === undefined");
			if (!angularInjectorUnDefined) {

				sleep(20);

				// Aguarda carregamento Angular
				waitForAngularLoad();

				// Aguarda JS terminar carregamento
				waitUntilJSReady();

				sleep(20);
			} else {
				System.out.println("Angular injector n�o est� definido na p�gina");
			}
		} else {
			System.out.println("Angular n�o est� definido na p�gina");
		}
	}

    // Aguarda at� JQuery, Angular e JS terminar carregamento
	public static void waitJQueryAngular() {
		waitUntilJQueryReady();
		waitUntilAngularReady();
	}

	public static void sleep(Integer seconds) {
		long secondsLong = (long) seconds;
		try {
			Thread.sleep(secondsLong);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
