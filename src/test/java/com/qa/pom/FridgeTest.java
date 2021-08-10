package com.qa.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FridgeTest {
	
	private WebDriver driver;
	fridge Fridge;
	
	@Before
	public void setUp() throws Exception {
		Fridge = new fridge(driver);
		driver = Fridge.chromeDriverC();
		Fridge.visita("https://www.fravega.com/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		Fridge.BuscarHeladeras();
		Thread.sleep(3000);
		Fridge.Listar();
	}

}
