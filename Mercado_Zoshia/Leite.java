public class Leite extends ProdutoPerecivel {

    public Leite(int quantidade, int diaValidade, int mesValidade, int anoValidade) {
        super("Leite", 7.50, quantidade,
            diaValidade, mesValidade, anoValidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println("Leite de Vaca 1L");
    }
    
}
