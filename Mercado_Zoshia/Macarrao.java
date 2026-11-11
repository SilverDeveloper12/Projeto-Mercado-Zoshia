public class Macarrao extends ProdutoNaoPerecivel {

    public Macarrao(int quantidade) {
        super("Macarrão", 7.0, quantidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println("Macarrão Dona Berenice 500g");
    }
    
}
