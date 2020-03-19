package ru.aplana.autotest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotest.steps.BaseSteps;

public class IpotekaPage extends BasePage{

    @FindBy(xpath = "//div[contains(@data-pid, 'Iframe')]/parent::div")
    public static WebElement frame;

    @FindBy(id = "estateCost")
    WebElement estateCost;

    @FindBy(id = "initialFee")
    WebElement initialFee;

    @FindBy(id = "creditTerm")
    WebElement creditTerm;

    @FindBy(xpath = "//input[@data-test-id=\"youngFamilyDiscount\"]")
    WebElement youngFamilyDiscount;

    @FindBy(xpath = "//input[@data-test-id=\"paidToCard\"]")
    WebElement paidToCard;

    @FindBy(xpath = "//input[@data-test-id=\"canConfirmIncome\"]")
    WebElement canConfirmIncome;

    @FindBy(xpath = "//input[@data-test-id=\"realtyDiscount\"]")
    WebElement realtyDiscount;

    @FindBy(xpath = "//input[@data-test-id=\"lifeInsurance\"]")
    WebElement lifeInsurance;

    @FindBy(xpath = "//span[@data-test-id=\"amountOfCredit\"]")
    public static WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id=\"monthlyPayment\"]")
    public static WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-test-id=\"requiredIncome\"]")
    public static WebElement requiredIncome;

    @FindBy(xpath = "//span[@data-test-id=\"rate\"]")
    public static WebElement rate;

    public IpotekaPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void scrollToElement(WebElement element, int offset) {
        waitVisibilityOfElement(element);
        int y = element.getLocation().getY() + offset;
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) BaseSteps.getDriver();
        js.executeScript("window.scrollTo(0,"+y+")");
    }

    public void switchFrame() {
        BaseSteps.getDriver().switchTo().frame(0);
    }

    public void fillField(String fieldName, String value){

        switch (fieldName){
            case  "Стоимость недвижимости":
                fillField(estateCost, value);
                break;
            case  "Первоначальный взнос":
                fillField(initialFee, value);
                break;
            case  "Срок кредита":
                fillField(creditTerm, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void clickOnButton(String title) throws InterruptedException {

        switch (title){
            case "Скидка 0,3% при покупке квартиры на ДомКлик.":
                clickButton(realtyDiscount);
                break;
            case "Есть зарплатная карта Сбербанка":
                clickButton(paidToCard);
                break;
            case "Есть возможность подтвердить доход справкой":
                clickButton(canConfirmIncome);
                break;
            case "Страхование жизни":
                clickButton(lifeInsurance);
                break;
            case "Молодая семья":
                clickButton(youngFamilyDiscount);
                break;
            default:  throw new AssertionError("Нет такой кнопки" + title);
        }
    }

    public static WebElement getValue(String field){

        switch (field){
            case "Сумма кредита":
                return amountOfCredit;
            case "Ежемесячный платеж":
                return monthlyPayment;
            case "Необходимый доход":
                return requiredIncome;
            case "Процентная ставка":
                return rate;
            default: throw new AssertionError("Нет такого параметра");
        }
    }
}
