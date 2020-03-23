import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = {"ru.aplana.autotest.glue"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"},
        tags = {"@scenario1"}

)
public class CucumberRunner {
}
