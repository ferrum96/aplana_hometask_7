package ru.aplana.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static ru.aplana.autotest.steps.BaseSteps.getDriver;

public class MainPage extends BasePage{

    @FindBy(xpath = "//*[contains(@aria-label,'Ипотека')]")
    public WebElement ipotekaBtn;

    @FindBy(xpath = "//a[contains(text(),'Ипотека на готовое жильё')]")
    public WebElement ipotekaLink;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void selectIpotekaItem(){
        waitClickableOfElement(ipotekaBtn);
        new Actions(getDriver()).moveToElement(ipotekaBtn).click().perform();
    }

    public void selectSubMenu(){
        waitVisibilityOfElement(ipotekaLink);
        new Actions(getDriver()).moveToElement(ipotekaLink).click().perform();
    }

}
