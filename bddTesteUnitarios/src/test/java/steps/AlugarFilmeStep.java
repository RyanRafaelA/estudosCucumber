package steps;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import entidades.service.AluguelService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import utils.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class AlugarFilmeStep {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel;

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer quant) {
        filme = new Filme();
        filme.setEstoque(quant);
    }

    @Dado("que o preço do aluguel seja R$ {int}")
    public void queOPreçoDoAluguelSejaR$(Integer preco) {
        filme.setPreco(preco);
    }

    @Dado("um filme")
    public void umFilme(DataTable dataTable) {
        filme = new Filme();
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String tipo = map.get("tipo");

        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setPreco(Integer.parseInt(map.get("preco")));

        if(tipo.equals("semanal")){
            tipoAluguel = TipoAluguel.SEMANAL;
        } else if(tipo.equals("extendido")){
            tipoAluguel = TipoAluguel.EXTENDIDO;
        } else {
            tipoAluguel = TipoAluguel.COMUM;
        }
    }

    @Quando("alugar")
    public void alugar() throws Throwable{
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch(RuntimeException e){
            erro = e.getMessage();
        }
    }

    @Então("o preço do aluguel será R$ {int}")
    public void oPreçoDoAluguelSeráR$(Integer valorEsperado) {
        Assert.assertEquals(valorEsperado.intValue(), nota.getPreco());
    }

    @Então("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer estoqueEsperado) {
        Assert.assertEquals(estoqueEsperado.intValue(), filme.getEstoque());
    }

    @Então("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Dado("que o tipo de aluguel seja {string}")
    public void queOTipoDeAluguelSeja(String tipo) {
        if(tipo.equals("semanal")){
            tipoAluguel = TipoAluguel.SEMANAL;
        } else if(tipo.equals("extendido")){
            tipoAluguel = TipoAluguel.EXTENDIDO;
        } else {
            tipoAluguel = TipoAluguel.COMUM;
        }
    }

    @Então("a data de entrega será em {int} dias")
    public void aDataDeEntregaSeráEmDias(Integer int1) {
        Date dataEsperada = DateUtil.obterDataDiferencaDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("a pontuação recebida será de {int} pontos")
    public void aPontuaçãoRecebidaSeráDePontos(Integer int1) {
        Assert.assertEquals(int1.intValue(), nota.getPontuacao());
    }
}
