package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/inserirConta.feature",
        plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "steps"
)
public class Runner {
}
