package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Add {

    WebDriver driver;
    
    By userRole = By.id("systemUser_userType");
    By employeeName = By.id("systemUser_employeeName_empName");
    By userName = By.id("systemUser_userName");
    By userStatus = By.id("systemUser_status");
    By password = By.id("systemUser_password");
    By confirm  = By.id("systemUser_confirmPassword");
    By save = By.id("btnSave");

    
    public Add(WebDriver driver){

        this.driver = driver;

    }
    
    //Metodo para seleccionar el role del usuario a crear 
    
    public void setselectRole(int option){
        WebElement userType = driver.findElement(userRole);
        Select role = new Select(userType);
        switch(option){
            case 1:
                role.selectByVisibleText("Admin");
                break;
            case 2:
                role.selectByVisibleText("ESS");
                break;
        }
    }
    
    //Metodo para asignar el employee del usuario a crear 
    public void setEmployeeName(String strEmployeeName){

        driver.findElement(employeeName).sendKeys(strEmployeeName);

    }
    
    //Metodo para asignar el nombre del usuario a crear 
    public void setUserName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);

    }
    
    //Metodo para asignar el status del usuario a crear 
    public void selectStatus(int option){
        WebElement status = driver.findElement(userStatus);
        Select Status = new Select(status);
        switch(option){
            case 1:
                Status.selectByVisibleText("Enabled");
                break;
            case 2:
                Status.selectByVisibleText("Disabled");
                break;
        }
        
    }
    
    //Metodo para Asignar una contraseña al usuario a crear
    public void setPassword(String strPassword){

        driver.findElement(password).sendKeys(strPassword);

    }
    
    //Metodo para confimar la contraseña ingresada al usuario a crear 
    public void ConfirmPassword(String strConfirm){

        driver.findElement(confirm).sendKeys(strConfirm);

    }
    
    //Metodo para dar click en el boton "save" para crear al usuario
    public void clickSave(){

        driver.findElement(save).click();

    }

    public void createUser(int option, String strEmployeeName, String strUserName,String strPassword, String strConfirm){
        
        this.setselectRole(option);
        this.setEmployeeName(strEmployeeName);
        this.setUserName(strUserName);
        this.selectStatus(option);
        this.setPassword(strPassword);
        this.ConfirmPassword(strConfirm);
    }

}