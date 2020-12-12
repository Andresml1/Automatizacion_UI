package pageobject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;

    By userName = By.name("txtUsername");

    By password = By.name("txtPassword");

    By login = By.name("Submit");

    public Login(WebDriver driver){

        this.driver = driver;

    }

    //Ingresa el valor del usuario

    public void setUserName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);

    }

    //Ingresa el valor de la contraseña del usuario

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

    //Click en el boton "Login" para ingresar a la home page

    public void clickLogin(){

            driver.findElement(login).click();

    }


    public void loginToPage(String strUserName,String strPasword){

        this.setUserName(strUserName);

        this.setPassword(strPasword);

        this.clickLogin();        
    }

}