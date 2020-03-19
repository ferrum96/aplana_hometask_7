import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"},
        glue = {"ru.aplana.autotest.glue/"},
        plugin = {"ru.aplana.autotest.utils.AllureReporter"}
        )

public class CucumberRunnerTest {

}
