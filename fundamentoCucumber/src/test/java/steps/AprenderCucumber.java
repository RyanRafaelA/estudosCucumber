package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AprenderCucumber {

    @Dado("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() { }

    @Quando("executá-lo")
    public void executáLo() { }

    @Então("o especificação deve finalizar com sucesso")
    public void oEspecificaçãoDeveFinalizarComSucesso() { }

    private int contador = 0;

    @Dado("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(Integer int1) {
        contador = int1;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contador += int1;
    }

    @Então("o valor do contador ser {int}")
    public void oValorDoContadorSer(Integer int1) {
        Assert.assertEquals(contador, (int) int1);
    }

    LocalDate entrega;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Dado("que o prazo é dia {string}")
    public void queOPrazoÉDia(String dataInicial) {
        entrega = LocalDate.parse(dataInicial, formato);
    }

    @Quando("a entrega atrasar em {int} dias")
    public void aEntregaAtrasarEmDias(Integer adicionar) {
        entrega = entrega.plusDays(adicionar);
    }

    @Quando("a entrega atrasar em {int} meses")
    public void aEntregaAtrasarEmMeses(Integer adicionar) {
        entrega = entrega.plusMonths(adicionar);
    }

    @Então("a entrega será efetuada em {string}")
    public void aEntregaSeráEfetuadaEm(String dataEsperada) {
        System.out.println(entrega.toString());
        LocalDate dataEsperadaFormatada = LocalDate.parse(dataEsperada, formato);

        Assert.assertEquals(dataEsperadaFormatada, entrega);
    }

}