import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.aplana.autotest.steps.BaseSteps;
import ru.aplana.autotest.steps.IpotekaPageSteps;
import ru.aplana.autotest.steps.MainPageSteps;

public class AllureSberTest {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private IpotekaPageSteps ipotekaPageSteps = new IpotekaPageSteps();

    @Before
    public void before(){
        BaseSteps.initDriver();
    }

    @Test
    public void allureTest() throws InterruptedException {
        mainPageSteps
                .selectMenu()
                .selectItemMenu();
        ipotekaPageSteps
                .scrollToFrame()
                .switchFrame()
                .fillField("Стоимость недвижимости","5180000")
                .fillField("Первоначальный взнос","3058000")
                .fillField("Срок кредита","30")
                .clickOnInvisibleElement("Молодая семья")
                .clickOnInvisibleElement("Есть зарплатная карта Сбербанка")
                .checkCalcValue("Сумма кредита","2 122 000 \u20BD")
                .checkCalcValue("Ежемесячный платеж","17 535 \u20BD")
                .checkCalcValue("Необходимый доход","29 224 \u20BD")
                .checkCalcValue("Процентная ставка","11 %");
    }

    @After
    public void after() throws Exception {
        BaseSteps.tearDown();
    }
}
