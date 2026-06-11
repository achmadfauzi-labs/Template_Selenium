package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
        features  = "src/test/resources/features",
        glue      = {"steps", "hooks"},
        plugin    = {
            "pretty",
            "html:target/cucumber-reports.html",
            "json:target/cucumber-reports.json"
        },
        monochrome = true
        // Uncomment untuk jalankan tag tertentu:
        // tags = "@smoke"
)
public class TestRunners {
}
