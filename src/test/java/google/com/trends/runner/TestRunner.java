package google.com.trends.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {
                "html:target/default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "google/com/trends/step_definitions",
        dryRun = false,
        tags = "@trends"


)
@RunWith(Cucumber.class)
public class TestRunner {


}
