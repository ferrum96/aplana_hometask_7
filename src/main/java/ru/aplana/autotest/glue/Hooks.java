package ru.aplana.autotest.glue;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static ru.aplana.autotest.steps.BaseSteps.getDriver;
import static ru.aplana.autotest.steps.BaseSteps.initDriver;
import static ru.aplana.autotest.steps.BaseSteps.tearDown;

public class Hooks {
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
