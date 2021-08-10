package com.qa.pom;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fridge extends Base{
	
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

	public fridge(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void BuscarHeladeras() throws InterruptedException {
		Ingreso("1111",IngresaPostal);
		click(BotonGuardar);
		Ingreso("Heladera",BuscarProductosLocalizador);
		click(BotonBuscar);
		Thread.sleep(3000);
		
		if(isDisplayed(Lista1)) {
			click(Heladeras);
		}
		else {
			System.out.println("No encontrado");
		}
		
		Thread.sleep(3000);
		
		if(isDisplayed(Lista2)) {
			click(Marca);
		}
		else {
			System.out.println("No encontrado");
		}
		Thread.sleep(3000);
		
		
	}
		
	public Boolean Listar() {
		List<WebElement> Lista = findElements(resultados);
		//assertEquals("Patrick", findElement(resultados));
		//assertEquals("22", findElement(cantidad));
		//assertEquals("Heladeras", findElement(Breadcrumb));
		return  isDisplayed(resultados);
}
		
	


}
