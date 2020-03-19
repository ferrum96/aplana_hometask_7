package ru.aplana.autotest.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.aplana.autotest.pages.BasePage;
import ru.aplana.autotest.utils.TestProperties;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    private static WebDriver driver;
    public static TestProperties props = TestProperties.getInstance();

    @Before
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", props.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty("timeout.global")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty("timeout.pageLoad")), TimeUnit.SECONDS);
        driver.get(props.getProperty("url"));
        driver.manage().deleteAllCookies();
        BasePage.waitClickableElement(driver.findElement(By.xpath("//a[@class='cookie-warning__close']"))).click();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
