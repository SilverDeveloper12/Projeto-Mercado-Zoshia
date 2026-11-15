package menu;

import servico.ProdutoService;

public class MenuProdutos {

    private final ProdutoService produtoService;

    public MenuProdutos(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void executar() {
        throw new UnsupportedOperationException();
    }
}
