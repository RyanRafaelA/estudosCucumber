package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/inserirConta.feature",
        plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "steps",
        dryRun = false
)
public class Runner {
    @BeforeClass
    public static void reset(){
        WebDriver driver;
        WebDriverWait wait;
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://seubarriga.wcaquino.me/login");

        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        emailField.clear();
        emailField.sendKeys("seil@09");

        WebElement senhaField = wait.until(ExpectedConditions.elementToBeClickable(By.name("senha")));
        senhaField.clear();
        senhaField.sendKeys("seila098");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        button.click();

        WebElement resete = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("reset")));
        resete.click();
    }
}
