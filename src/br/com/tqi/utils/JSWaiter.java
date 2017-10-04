package br.com.tqi.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		// Aguarda carregamento JQuery
		ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) jsWaitDriver)
				.executeScript("return jQuery.active") == 0);

		// Verifica se já carregou
		boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

		// Aguarda até JQuery terminar processamento
		if (!jqueryReady) {
			System.out.println("JQuery NÃO terminou!");
			// Aguarda até JQuery terminar processamento
			jsWait.until(jQueryLoad);
		} else {
			System.out.println("JQuery terminou!");
		}
	}

	// Aguarda carregamento do Angular
	public static void waitForAngularLoad() {
		WebDriverWait wait = new WebDriverWait(jsWaitDriver, 60);
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		// Aguarda carregamento do Angular
		ExpectedCondition<Boolean> angularLoad = driver -> Boolean
				.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());

		// Verifica se Angulgar terminou
		boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

		// Aguarda carregamento do Angular
		if (!angularReady) {
			System.out.println("ANGULAR NÃO terminou!");
			// Aguarda carregamento do Angular
			wait.until(angularLoad);
		} else {
			System.out.println("ANGULAR terminou!");
		}
	}

	// Aguarda JS terminar carregamento
	public static void waitUntilJSReady() {
		WebDriverWait wait = new WebDriverWait(jsWaitDriver, 60);
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// Aguarda JS terminar carregamento
		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) jsWaitDriver)
				.executeScript("return document.readyState").toString().equals("complete");

		// Verifica se já carregou
		boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

		// Aguarda JS terminar carregamento
		if (!jsReady) {
			System.out.println("JS NÃO terminou!");
			// Aguarda JS terminar carregamento
			wait.until(jsLoad);
		} else {
			System.out.println("JS terminou!");
		}
	}

	// Aguardar até JQuery e JS terminar carregamento
	public static void waitUntilJQueryReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// First check that JQuery is defined on the page. If it is, then wait AJAX
		Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined == true) {

			sleep(20);

			// Aguarda JQuery terminar
			waitForJQueryLoad();

			// Aguarda JS terminar
			waitUntilJSReady();

			sleep(20);
		} else {
			System.out.println("jQuery is not defined on this site!");
		}
	}

	// Aguarda até Angular e JS terminar carregamento
	public static void waitUntilAngularReady() {
		JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

		// First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
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
				System.out.println("Angular injector is not defined on this site!");
			}
		} else {
			System.out.println("Angular is not defined on this site!");
		}
	}

    // Aguarda até JQuery, Angular e JS terminar carregamento
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
