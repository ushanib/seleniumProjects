package twobull.qa.qa2.tests;

/**
 * Created by ushani on 3/6/18.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import twobull.qa.qa2.pages.HomePage;
import twobull.qa.qa2.pages.LoginPage;
import twobull.qa.qa2.pages.WelcomePage;

import java.util.concurrent.TimeUnit;


public class testLoginPage {

    WebDriver driver;

    WelcomePage welcomePage;

    LoginPage loginPage;

    HomePage homePage;

    @BeforeTest

    public void setup() {

        //  System.setProperty("webdriver.gecko.driver", "/home/ushani/Selenium_ProjectWS/TwoBulls/seleniumTestProject/src/test/resources/geckodriver");
      //  driver = new FirefoxDriver();

 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo 1\\eclipse-workspace\\firstTestProject\\src\\test\\resources\\chromedriver.exe");
     driver = new ChromeDriver();

     /*System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo 1\\eclipseprojects\\seleniumTestProject\\src\\test\\resources\\geckodriver.exe");
     driver = new FirefoxDriver();
*/

//        System.setProperty("webdriver.chrome.driver", "/home/ushani/Selenium_ProjectWS/TwoBulls/seleniumTestProject/src/test/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://magento.com/products/magento-commerce");
    }


    /**
     * This test case will verify login page
     * <p>
     * Verify login page by  "Log Out" text
     */

    @Test(priority = 0)
    public void test_Login_Page_Appear_Correct() {

        //Create Welcome Page object
        welcomePage = new WelcomePage(driver);

        //Verify Welcome Page
        Assert.assertTrue(welcomePage.getLoginPageDashboard().contains("Commerce"));

        welcomePage.clickMyAccount();

        // go the next page
        loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.getLoginTitle().contains("Login or Create an Account"));

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

    public void test_Home_Page_Appear_Correct() {

        //login to application
        loginPage.loginToMagento("ushanib@gmail.com", "Password123");

        // Implicit wait for 5 seconds
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // go the next page
        homePage = new HomePage(driver);

        //Verify home page logged in user ID
        Assert.assertTrue(homePage.getHomePageDashboardUserName().contains("ID: MAG005320468"));

    }
}
