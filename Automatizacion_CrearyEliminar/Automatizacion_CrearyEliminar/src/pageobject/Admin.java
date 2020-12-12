package pageobject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class Admin {

    WebDriver driver;

    By Add = By.name("masterStash");

    public Admin(WebDriver driver){

        this.driver = driver;

    }

    //Click en el boton "Add" para crear un nuevo usuario

    public void clickAdd(){

            driver.findElement(Add).click();

    }

    
    public void navigateToAdd(){

        this.clickAdd();    
        
    }

}