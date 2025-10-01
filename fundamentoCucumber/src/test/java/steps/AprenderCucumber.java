package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

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
        contador += int1
    }

    @Então("o valor do contador ser {int}")
    public void oValorDoContadorSer(Integer int1) {
        Assert.assertEquals(contador, (int) int1);

    }
}