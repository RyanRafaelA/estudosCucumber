package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"steps"},
        features = "src/test/resources/features/alugar_filme.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = true
)
public class Runner {
}
