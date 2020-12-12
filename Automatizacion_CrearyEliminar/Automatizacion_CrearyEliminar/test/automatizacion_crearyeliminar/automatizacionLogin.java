/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatizacion_crearyeliminar;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;


import java.sql.Timestamp;
import pageobject.Login;
import pageobject.Home;
import pageobject.Admin;
import pageobject.Add;
import junit.framework.Assert;
import pageobject.Search;


public class automatizacionLogin {
    private static WebDriver driver = null;
    
    Login login;
    Home home;
    Admin admin;
    Add add;
    Search search;
    
    //Metodo para darle tiempo a cada respuesta 
    public static void sleep(){
       try {
           Thread.sleep(2000);
       } catch (Exception e) {
       }
    }
    
    @BeforeClass
    public static void setUpClass() {                
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
        driver.get("https://opensource-demo.orangehrmlive.com/");   
        login = new Login(driver);
        home = new Home(driver);
        admin = new Admin(driver);
        add = new Add(driver);
        search = new Search(driver);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test of main method, of class SeleniumPractice.
     */
    @Test
    public void loginToSystem() {
        login.loginToPage("ramirofelipe", "Ramirofelipe123");
        sleep();
        home.navigateToAdmin();
        sleep();
        admin.navigateToAdd();
        
        //variables para asignar nombres de usuario y contraseñas aleatorias
        int passRandom = (int)(Math.random()* 9999) + 1000;
        int userRandom = (int)(Math.random()* 1500) + 1;
        int option = (int)(Math.random()* 2) + 1;
        String role = "";
        String status = "";
        //Condicionales para selecionar aleatoriamente el role y status
        if (option == 1) {
            role = "Admin";
            status = "Enabled";
        }
        if (option == 2) {
            role = "ESS";
            status = "Disabled";
        }

        String employee = "Jacqueline White";
        String userName = "user" + userRandom;
        String password = "Pass" + passRandom;
        sleep();
        add.createUser(option, employee, userName, password, password);
        
        sleep();
        
        add.clickSave();
        
        sleep();
        
        search.searchUser(userName, employee, option);
        
        String userText = search.getUserText();
        String userRole = search.getUserRole();
        String employeeName = search.getEmployeeName();
        String userStatus = search.getUserStatus();

        Assert.assertTrue(userText.contains(userName));
        Assert.assertTrue(userRole.contains(role));
        Assert.assertTrue(employeeName.contains(employee));
        Assert.assertTrue(userStatus.contains(status));
        System.out.println("Usuario verificado");
        
        sleep();
                
        search.setCheckbox();
        
        sleep();
        
        search.setDelete();
        
        sleep();
        
        search.setConfirmDelete();
        
        sleep();
        
        search.searchUser(userName, employee, option);
        
        String veriFy = search.getVeriFy();

        Assert.assertTrue(veriFy.contains(""));
        System.out.println("Usuario eliminado");
    }  
    
    
}
