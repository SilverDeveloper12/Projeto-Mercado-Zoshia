package mercadoZoshia.model;

public class Despesa extends Movimentacao {

    private final String categoria;

    public Despesa(String descricao, double valor, String categoria) {
        super(descricao, valor);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public double getValorComSinal() {
        throw new UnsupportedOperationException();
    }
}
