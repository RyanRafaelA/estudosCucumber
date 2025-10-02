package entidades.service;

import entidades.Filme;
import entidades.NotaAluguel;
import utils.DateUtil;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipo){
        if(filme.getEstoque() == 0) {
            throw new RuntimeException("Filme sem estoque");
        }

        NotaAluguel nota = new NotaAluguel();
        if("extendido".equals(tipo)) {
            nota.setPreco(filme.getPreco() * 2);
            nota.setDataEntrega(DateUtil.ObterDataDiferencaDias(3));
            nota.setPontuacao(2);
        } else {
            nota.setPreco(filme.getPreco());
            nota.setDataEntrega(DateUtil.ObterDataDiferencaDias(1));
            nota.setPontuacao(1);
        }
        filme.setEstoque(filme.getEstoque() - 1);

        return nota;
    }
}
