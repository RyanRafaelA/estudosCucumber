package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get("https://seubarriga.wcaquino.me/login");
    }

    @Quando("informo o usuário {string}")
    public void informoOUsuário(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @Quando("a senha {string}")
    public void aSenha(String senha) {
        driver.findElement(By.name("senha")).sendKeys(senha);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

        System.out.println(texto);
        Assert.assertEquals("Bem vindo, Sei La!", texto);
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("informo a conta {string}")
    public void informoAConta(String conta) {
        driver.findElement(By.id("nome")).sendKeys(conta);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("a conta é inserida com sucesso")
    public void aContaÉInseridaComSucesso() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

        System.out.println(texto);
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }
}