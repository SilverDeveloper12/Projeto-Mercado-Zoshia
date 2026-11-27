package mercadoZoshia.model;

public class ProdutoNaoPerecivel extends Produto {
    private String categoria;

    public ProdutoNaoPerecivel(String codigo, String nome, double preco, String categoria) {
        super(codigo, nome, preco);
        this.categoria = categoria;
    }

    @Override
    public double calcularPreco() {
        return getPreco();
    }

    @Override
    public String toString() {
        return super.toString() + " | Categoria: " + categoria;
    }
}