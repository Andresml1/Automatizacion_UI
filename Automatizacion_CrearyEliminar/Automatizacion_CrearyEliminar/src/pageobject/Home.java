package pageobject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class Home {

    WebDriver driver;

    By Admin = By.id("menu_admin_viewAdminModule");

    public Home(WebDriver driver){

        this.driver = driver;

    }

    //Click en el boton "Admin" para ingresar a la pagina de gestionar los usuarios

    public void clickAdmin(){

            driver.findElement(Admin).click();

    }

    public void navigateToAdmin(){

        this.clickAdmin();    
        
    }

}