package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InserirContasSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://seubarriga.wcaquino.me/login");
    }

    @Quando("informo o usuário {string}")
    public void informoOUsuário(String email) {
        WebElement emailField = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("email")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Quando("a senha {string}")
    public void aSenha(String senha) {
        WebElement senhaField = wait.until(ExpectedConditions
                .elementToBeClickable(By.name("senha")));
        senhaField.clear();
        senhaField.sendKeys(senha);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        WebElement button = wait.until(ExpectedConditions
                .elementToBeClickable(By.tagName("button")));
        button.click();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-success')]")
        )).getText();

        Assert.assertEquals("Bem vindo, Sei La!", texto);
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        WebElement contasLink = wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Contas")));
        contasLink.click();
    }

    @Quando("seleciono Adicionar")
    public void selecionoAdicionar() {
        WebElement adicionarLink = wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Adicionar")));
        adicionarLink.click();
    }

    @Quando("informo a conta {string}")
    public void informoAConta(String conta) {
        WebElement contaField = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("nome")));
        contaField.clear();
        contaField.sendKeys(conta);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        WebElement salvarButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.tagName("button")
                ));
        salvarButton.click();
    }

    @Então("a conta é inserida com sucesso")
    public void aContaÉInseridaComSucesso() {
        String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-success')]")
        )).getText();

        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }

    @Então("sou notificado que o nome da conta é obrigatório")
    public void souNotificarQueONomeDaContaÉObrigatório() {
        String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-danger')]")
        )).getText();
        Assert.assertEquals("Informe o nome da conta", texto);
    }
}