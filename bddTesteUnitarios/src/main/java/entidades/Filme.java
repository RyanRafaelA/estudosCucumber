package entidades;

public class Filme {
    private int estoque;
    private int preco;

    public void setEstoque(int quant){
        this.estoque = quant;
    }
    public int getEstoque(){
        return estoque;
    }
    public int getPreco(){
        return preco;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }
}
