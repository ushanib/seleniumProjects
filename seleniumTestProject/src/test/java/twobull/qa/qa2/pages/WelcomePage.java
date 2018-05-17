package twobull.qa.qa2.pages;

/**
 * Created by ushani on 3/6/18.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {

        WebDriver driver;

        By welcomePageText = By.xpath("/html/body/div[3]/div/article/div[1]/div/div/div/h1/span");
        By click = By.linkText("MY ACCOUNT");

        public WelcomePage(WebDriver driver){

            this.driver = driver;

        }

        //Click My Account Link

        public void clickMyAccount(){

            driver.findElement(click).click();

        }


        //Get the text from Login Page

        public String getLoginPageDashboard(){

            return    driver.findElement(welcomePageText).getText();

        }

    }