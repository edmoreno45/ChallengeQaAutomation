package com.challenge.qaautomation;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fravega {
private WebDriver driver;

By IngresaPostal= By.name("postalNumber");
By BotonGuardar= By.xpath("//*[@id=\"modal\"]/div[1]/div/div[2]/form/div/button");
By BuscarProductosLocalizador= By.name("keyword");
By BotonBuscar= By.xpath("//*[@id=\"__next\"]/div[2]/header/div[2]/form/fieldset/div[1]/button");
By Lista1 = By.name("aggregations");
By Heladeras= By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div/div[1]/ul/li[2]/ul/li[1]/ul/li[2]/h4");
By Lista2 = By.name("aggregations");
By Marca= By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div/div[1]/ul/li[2]/ul/li[1]/ul/li[2]/a/label");
By resultados = By.name("itemsGrid");
By cantidad = By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div/div[1]/ul/li[3]/ul/li[1]/ul/li[2]/a/label/span");
By Breadcrumb = By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div/div[1]/ol");

   @Before
	public void setUp()	{
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");/* ubicacion de exe*/
		driver	= new ChromeDriver(); /* declara el objeto, de tipo */
		driver.manage().window().maximize(); /* abre la ventana y la maximiza*/
		driver.get("https://www.fravega.com/"); /* URL que vamos a ir*/
	}
	
	@Test
	public void testPostal() throws InterruptedException {
		
	
		driver.findElement(IngresaPostal).sendKeys("1111");
		driver.findElement(BotonGuardar).click();
		
		driver.findElement(BuscarProductosLocalizador).sendKeys("Heladera");
		driver.findElement(BotonBuscar).click();
		Thread.sleep(3000);
		
		if(driver.findElement(Lista1).isDisplayed()) {
			driver.findElement(Heladeras).click();
		}
		else {
			System.out.println("No encontrado");
		}
		Thread.sleep(3000);
		if(driver.findElement(Lista2).isDisplayed()) {
			driver.findElement(Marca).click();
		}
		else {
			System.out.println("No encontrado");
		}

		Thread.sleep(3000);
		List<WebElement> Lista = driver.findElements(resultados);
		//assertEquals("Patrick",driver.findElement(resultados));
		//assertEquals("22",driver.findElement(cantidad));
		//assertEquals("Heladeras",driver.findElement(Breadcrumb));
		
	}

	
	//@After
	//public void Cerrar() { 
		//driver.quit();
	//}
	
	
}



