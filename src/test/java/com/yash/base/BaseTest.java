package com.yash.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.yash.utilities.ExcelReader;
import com.yash.utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.yash.utilities.TestConfiguration.getCurrentPlatform;

public class BaseTest {

    protected static WebDriver driver;
    protected Properties config = new Properties();
    protected Properties OR = new Properties();
    protected FileInputStream fis = null;
    protected static Logger log;
    protected static String browser, appUrl;
    protected String userDir = System.getProperty("user.dir");
    public String path = userDir + "/src/test/resources/excel/Testdata.xlsx";
    public ExcelReader excel = new ExcelReader(path);

    //public ExtentReports rep = ExtentManager.createExtentReports();
    public ExtentReports extent = null;

    public ExtentTest test = null;

    public WebDriverWait wait = null;


    @BeforeSuite
    public void setUp()
    {
        log = LogManager.getLogger(BaseTest.class);
        log.info("In start of the setUp()");
        String userDir,browser,url;
        Platform platform = getCurrentPlatform();
        log.info("Platform is: "+platform.toString());
        extent = ExtentManager.createExtentReports();
        userDir = System.getProperty("user.dir");
        String path = "src/test/resources/excel/Testdata.xlsx";
        log = LogManager.getLogger(BaseTest.class);
        excel = new ExcelReader(path);
        if(driver == null)
        {
            try {
                fis = new FileInputStream(userDir + "/src/test/resources/properties/Config.properties");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                config.load(fis);
                log.info("Config file is loaded!");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(userDir + "/src/test/resources/properties/OR.properties");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                OR.load(fis);
                log.info("Config file is loaded!");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            browser = config.getProperty("browser");
            System.out.println("Browser: "+browser);
            appUrl = config.getProperty("appUrl");
            System.out.println("appUrl: "+appUrl);
            if(browser.equals("chrome"))
            {
                switch (platform) {
                    case MAC:
//                       System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/executables/MAC/chromedriver");
                        WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver();
                        break;
                    case WINDOWS:
//                        System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/executables/chromedriver.exe");
                        WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver();
                        break;

                    case LINUX:
//                        System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/executables/chromedriver");
                        WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver();
                        break;
                    default:
                        System.out.println("Please select valid browser!\n");
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                }

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--headless"); //!!!should be enabled for Jenkins
                options.addArguments("--disable-dev-shm-usage"); //!!!should be enabled for Jenkins
                options.addArguments("--window-size=1920x1080"); //!!!should be enabled for Jenkins
                driver = new ChromeDriver(options);
//                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                wait = new WebDriverWait(driver, Duration.ofMinutes(5));
                log.info("Chrome browser is loaded!");
            }
            driver.manage().window().maximize();
        }
        log.info("In end of the setUp()");
    }

    @AfterSuite
    public void tearDown()
    {
        log.info("In start of the tearDown()");
        if(driver !=null)
        {
            driver.quit();
            log.info("Browser is closed!");
        }
        log.info("In end of the tearDown()");
    }

    public WebDriver getDriver() {
        return driver;
    }

}
