package twobull.qa.qa1.pages;

/**
 * Created by ushani on 3/6/18.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

        WebDriver driver;

        By searchText = By.name("q");
        By clickSearch = By.name("btnK");

        public SearchPage(WebDriver driver){

            this.driver = driver;

        }


        //Set search text

        public void setSearchText(String searchString){

            driver.findElement(searchText).sendKeys(searchString);

        }


        //Click on Search button

        public void clickSearch(){

            driver.findElement(clickSearch).click();

        }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strSearchQuery

     */

    public void searchStringGoogle(String strSearchQuery){

        //Fill search String

        this.setSearchText(strSearchQuery);

        //Click Search button

        this.clickSearch();

    }

    }