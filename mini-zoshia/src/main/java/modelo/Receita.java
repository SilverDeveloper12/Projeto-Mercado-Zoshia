package modelo;

public class Receita extends Movimentacao {

    public Receita(String descricao, double valor) {
        super(descricao, valor);
    }

    @Override
    public double getValorComSinal() {
        throw new UnsupportedOperationException();
    }
}
