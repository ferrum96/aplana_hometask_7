package ru.aplana.autotest.steps;

import io.qameta.allure.Step;
import ru.aplana.autotest.pages.IpotekaPage;
import static org.junit.Assert.assertTrue;
import static ru.aplana.autotest.pages.BasePage.waittextToBePresentInElement;

public class IpotekaPageSteps extends BaseSteps {

    @Step("Выполнен скроллинг до формы расчета ипотеки")
    public IpotekaPageSteps scrollToFrame(){
        new IpotekaPage().scrollToElement(IpotekaPage.frame,160);
        return this;
    }

    @Step("Выполнено переключение на форму расчета ипотеки")
    public IpotekaPageSteps switchFrame() {
        new IpotekaPage().switchFrame();
        return this;
    }

    @Step("поле {0} заполняется значением {1}")
    public IpotekaPageSteps fillField(String field, String value){
        new IpotekaPage().fillField(field, value);
        return this;
    }

    @Step("Выполнено нажатие на кнопку {0}")
    public IpotekaPageSteps clickOnInvisibleElement(String name) throws InterruptedException {
        new IpotekaPage().clickOnButton(name);
        return this;
    }

    @Step("поле {0} заполнено значением {1}")
    public IpotekaPageSteps checkCalcValue(String field, String value) {
        waittextToBePresentInElement(IpotekaPage.getValue(field),value);
        String actual = IpotekaPage.getValue(field).getText();
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
        return this;
    }
}
