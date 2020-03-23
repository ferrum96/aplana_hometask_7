package ru.aplana.autotest.glue;

import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.aplana.autotest.steps.IpotekaPageSteps;
import ru.aplana.autotest.steps.MainPageSteps;
import java.util.Map;
import static ru.aplana.autotest.steps.BaseSteps.*;


public class MyStepdefs {

    private MainPageSteps mainPageSteps = new MainPageSteps();

    private IpotekaPageSteps ipotekaPageSteps = new IpotekaPageSteps();

    @Когда("^выбрано меню Ипотека$")
    public void выбрано_меню_Ипотека(){
        mainPageSteps.selectMenu();
    }

    @Когда("^выбран вид ипотеки Ипотека на готовое жильё$")
    public void выбран_вид_ипотеки_Ипотека_на_готовое_жильё(){
        mainPageSteps.selectItemMenu();
    }

    @Когда("^выполнен скроллинг до формы расчета ипотеки$")
    public void выполнен_скроллинг_до_формы_расчета_ипотеки(){
        ipotekaPageSteps.scrollToFrame();
    }

    @Когда("^выполнено переключение на форму расчета ипотеки$")
    public void выполнено_переключение_на_форму_расчета_ипотеки(){
        ipotekaPageSteps.switchFrame();
    }

    @Когда("^заполняются поля:$")
    public void заполняются_поля(DataTable fields){
        Map<String,String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach((field, value) -> { ipotekaPageSteps.fillField(field, value); });
    }

    @Когда("^выполнено нажатие на кнопку \"Молодая семья\"$")
    public void нажатие_на_кнопку_Молодая_семья() throws InterruptedException {
        ipotekaPageSteps.clickOnInvisibleElement("Молодая семья");
    }

    @Когда("^выполнено нажатие на кнопку \"Есть зарплатная карта Сбербанка\"$")
    public void нажатие_на_кнопку_Зарплатная_карта() throws InterruptedException {
        ipotekaPageSteps.clickOnInvisibleElement("Есть зарплатная карта Сбербанка");
    }

    @Тогда("^значения полей равны:$")
    public void значения_полей(DataTable fields) {
        Map<String,String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach((field, value) -> { new IpotekaPageSteps().checkCalcValue(field, value); });
    }

    @Before
    public void before(){
        initDriver();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public void after(Scenario sc) throws Exception {
        if(sc.isFailed()) saveScreenshot();
        tearDown();
    }

}

