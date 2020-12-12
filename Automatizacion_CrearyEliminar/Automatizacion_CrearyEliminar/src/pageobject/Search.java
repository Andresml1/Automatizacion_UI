package pageobject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Search {

    WebDriver driver;

    By searchUser = By.id("searchSystemUser_userName");
    By userRole = By.id("searchSystemUser_userType");
    By employeeName = By.id("searchSystemUser_employeeName_empName");
    By userStatus = By.id("searchSystemUser_status");
    By searchBtn = By.id("searchBtn");
    By checkbox = By.xpath("//input[@type='checkbox']");
    By delete = By.id("btnDelete");
    By confirmDelete = By.id("dialogDeleteBtn");
    By getVerifyDelete = By.xpath("//table/tbody/tr/td[1]");
    By getSearchUser = By.xpath("//table/tbody/tr/td[2]/a");
    By getUserRole = By.xpath("//table/tbody/tr/td[3]");
    By getEmployeeName = By.xpath("//table/tbody/tr/td[4]");
    By getUserStatus = By.xpath("//table/tbody/tr/td[5]");
    
    public Search(WebDriver driver){

        this.driver = driver;

    }

    //Click on login button


    public void setSearch(String strSearchUser){

        driver.findElement(searchUser).sendKeys(strSearchUser);

    }
    
    //Metodo para asignar el role del empleado a buscar
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
    
    //Metodo para asignar el employee del usuario a buscar 
    public void setSearchEmployee(String strSearchEmployee){

        driver.findElement(employeeName).sendKeys(strSearchEmployee);

    }
    
    //Metodo para asignar el status del usuario a buscar 
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
     //Click en el boton "Search" para buscar un usuario 
    public void clickSearch(){

        driver.findElement(searchBtn).click();

    }
    
     //Metodo  para obtener el nombre del usuario
    public String getUserText(){
           
        return driver.findElement(getSearchUser).getText(); 
    }
    
    //Metodo  para obtener el role  del usuario
    public String getUserRole(){
           
        return driver.findElement(getUserRole).getText(); 
        
    } 
    
     //Metodo  para obtener el role  del usuario
    public String getEmployeeName(){
           
        return driver.findElement(getEmployeeName).getText(); 
        
    }
    
     //Metodo  para obtener el Status  del usuario
    public String getUserStatus(){
           
        return driver.findElement(getUserStatus).getText(); 
        
    }
    
     //Metodo  para seleccionar el checkbox de un usuarios
    public void setCheckbox(){
           
        driver.findElement(checkbox).click(); 
        
    }
    
    //Metodo  para seleccionar el boton "Delete" para eliminar al usuario seleccionado 
    public void setDelete(){
           
        driver.findElement(delete).click(); 
        
    }
    
    //Metodo para confirmar eliminar al usuario seleccionado
    public void setConfirmDelete(){
           
        driver.findElement(confirmDelete).click(); 
        
    }
    
    //Metodo para veficar que el usuario si quedo eliminado correctamente
    public String getVeriFy(){
           
        return driver.findElement(getVerifyDelete).getText(); 
        
    }
        
    public void searchUser(String strSearchUser, String strSearchEmployee, int option){
        
        this.setSearch(strSearchUser);
        this.setselectRole(option);
        this.setSearchEmployee(strSearchEmployee);
        this.selectStatus(option);
        this.clickSearch();
        
        
    }

}