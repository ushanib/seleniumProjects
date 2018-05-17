package twobull.qa.qa1.tests;

/**
 * Created by ushani on 3/6/18.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import twobull.qa.qa1.pages.SearchPage;
import twobull.qa.qa1.pages.ResultsPage;

import java.util.concurrent.TimeUnit;


public class testSearchPage {

    WebDriver driver;

    SearchPage searchPage;

    ResultsPage resultsPage;

    @BeforeTest

    public void setup() {

      //  System.setProperty("webdriver.gecko.driver", "/home/ushani/Selenium_ProjectWS/TwoBulls/seleniumTestProject/src/test/resources/geckodriver");
      //  driver = new FirefoxDriver();

/*   	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo 1\\eclipse-workspace\\firstTestProject\\src\\test\\resources\\chromedriver.exe");
     driver = new ChromeDriver();*/

     System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo 1\\eclipseprojects\\seleniumTestProject\\src\\test\\resources\\geckodriver.exe");
     driver = new FirefoxDriver();


//        System.setProperty("webdriver.chrome.driver", "/home/ushani/Selenium_ProjectWS/TwoBulls/seleniumTestProject/src/test/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.google.com");
    }


    /**
     * This test case will Search for "QA"
     * <p>
     * Verify the results page contains Wikipedia as result
     */

    @Test(priority = 0)
    public void test_Search_Results_Appear_Correct() {

        //Create Google Search Page object
        searchPage = new SearchPage(driver);

        //Search for QA string
        searchPage.searchStringGoogle("QA");

        // go the next page
        resultsPage = new ResultsPage(driver);

        Assert.assertTrue(resultsPage.getSearchedResult().contains("Quality assurance - Wikipedia"));

    }


    /**
     * This test case will login in https://account.magento.com/customer/account/login
     * <p>
     * Provide username and password
     * <p>
     * Login to application
     * <p>
     * Verify the home page using User ID
     */

    @Test(priority = 1)

    public void test_Search_Appear_WikiLink() {

        resultsPage.clickWikiResult();

        // Go the next page
//        wikiPage = new WikiPage(driver);

        //Wait until QA Wikipedia page is loaded
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("noprint")));

        //Verify the URL is wiki URL
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://en.wikipedia.org/wiki/Quality_assurance" );

    }
}
