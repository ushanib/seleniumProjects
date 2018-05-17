package twobull.qa.qa2.pages;

/**
 * Created by ushani on 3/6/18.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

        WebDriver driver;

    //Home page text
        By homePageUserName = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[1]/span");


        public HomePage(WebDriver driver){

            this.driver = driver;

        }



        //Get the ID from Home Page

        public String getHomePageDashboardUserName(){

            return    driver.findElement(homePageUserName).getText();

        }

    }