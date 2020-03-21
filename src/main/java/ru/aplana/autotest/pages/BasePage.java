package ru.aplana.autotest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotest.utils.TextApproved;

import static ru.aplana.autotest.steps.BaseSteps.getDriver;

public class BasePage {

    public static WebDriverWait wait = new WebDriverWait(getDriver(),100);

    BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void fillField(WebElement field, String value){
        waitVisibilityOfElement(field);
        waitClickableOfElement(field);
        while (!new TextApproved(value, field).apply(getDriver())){
            waitClickableOfElement(field);
            field.sendKeys(value);
            field.clear();
            break;
        }
        wait.until(new TextApproved(value, field));
    }

    public void clickButton(WebElement element) throws InterruptedException {
        Thread.sleep(1000);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element  );
    }


    public static WebElement waitVisibilityOfElement(WebElement element){
        wait = new WebDriverWait(getDriver(),100);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitClickableOfElement(WebElement element){
        wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitClickableElement(WebElement element){
        wait = new WebDriverWait(getDriver(),10);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waittextToBePresentInElement(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

}
