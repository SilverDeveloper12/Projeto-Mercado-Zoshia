import java.util.ArrayList;
import java.util.List;

public class Compra implements OperadorCaixa {

    private List<Produto> produtos = new ArrayList();

    @Override
    public void adicionaProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void finalizaCompra() {
        System.out.println("------");
        double total = 0.0;
        for( Produto produto : produtos ){
            if( produto.estaValido(11, 9, 2026) ){
                total += produto.getPreco();
                produto.mostraDescricao();
                System.out.println(produto);
            } else {
                System.out.println(produto.getNome() + " estragado.");
            }
        }
        System.out.println("Total R$" + total);
    }
    
}
