package entidades.service;

import entidades.Filme;
import entidades.NotaAluguel;
import utils.DateUtil;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme){
        if(filme.getEstoque() == 0) {
            throw new RuntimeException("Filme sem estoque");
        }

        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getPreco());
        nota.setDataEntrega(DateUtil.ObterDataDiferencaDias(1));
        filme.setEstoque(filme.getEstoque() - 1);

        return nota;
    }
}
