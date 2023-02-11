package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageGenerator;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class BaseTest {
        public WebDriver driver;
        public WebDriverWait wait;
        public PageGenerator page;
        public static Logger log = Logger.getLogger(BaseTest.class.getName());

        @BeforeMethod
        public void setup () {

            File file = new File("src/main/resources/chromedriver.exe");
            String absolutePath = file.getAbsolutePath();


            System.setProperty("webdriver.chrome.driver", absolutePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en-us");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            //Deleting all the cookies
            driver.manage().deleteAllCookies();

            //Specifiying pageLoadTimeout and Implicit wait
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);




            //Instantiate the Page Class
            page = new PageGenerator(driver);
        }

        @AfterMethod
        public void teardown () {
            driver.quit();
        }
    }

