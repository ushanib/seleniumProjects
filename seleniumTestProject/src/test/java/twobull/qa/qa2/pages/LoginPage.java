package twobull.qa.qa2.pages;

/**
 * Created by ushani on 3/6/18.
 */

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

public class LoginPage {

    WebDriver driver;

    By email = By.name("login[username]");

    By password = By.name("login[password]");

    By login = By.name("send");

    By titleText =By.className("page-title");


    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(email).sendKeys(strUserName);

    }


    //Get the title of Login Page

    public String getLoginTitle(){

        return    driver.findElement(titleText).getText();

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

        driver.findElement(password).sendKeys(strPassword);

    }



    //Click on login button

    public void clickLogin(){

            driver.findElement(login).click();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     */

    public void loginToMagento(String strUserName,String strPasword){

            //Fill user name/email add

            this.setUserName(strUserName);

            //Fill password

            this.setPassword(strPasword);

            //Click Login button

            this.clickLogin();

       }

}
