package mercadoZoshia.model;

public class ProdutoPerecivel extends Produto {
    private int diasParaVencer;

    public ProdutoPerecivel(String codigo, String nome, double preco, int diasParaVencer) {
        super(codigo, nome, preco);
        this.diasParaVencer = diasParaVencer;
    }


    //desconto p produtos próximo de vencer
    @Override
    public double calcularPreco() {
        if (diasParaVencer <= 3) {
            return getPreco() * 0.7;
        }
        return getPreco();
    }

    @Override
    public String toString() {
        return super.toString() + " | Vence em " + diasParaVencer + " dias";
    }
}
