public class Maca extends ProdutoPerecivel {

    public Maca(int quantidade, int diaValidade, int mesValidade, int anoValidade) {
        super("Maçã", 12.0, quantidade, diaValidade, mesValidade, anoValidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println("Maçã Gala 1kg");
    }
    
}
