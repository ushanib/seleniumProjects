package twobull.qa.qa1.pages;

/**
 * Created by ushani on 3/6/18.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {

        WebDriver driver;

        By secondResult = By.xpath("//*[@id='rso']/div[3]/div/div[1]/div/div/h3/a");
        By clickWikiLink = By.linkText("Quality assurance - Wikipedia");

        public ResultsPage(WebDriver driver){

            this.driver = driver;

        }


    //Click Wikipedia Result Link

    public void clickWikiResult(){

        driver.findElement(clickWikiLink).click();

    }



    //Get the text from Login Page

        public String getSearchedResult(){

            return    driver.findElement(secondResult).getText();

        }

    }
