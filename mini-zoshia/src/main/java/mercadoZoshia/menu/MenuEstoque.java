package mercadoZoshia.menu;

import mercadoZoshia.service.EstoqueService;
import mercadoZoshia.service.FornecedorService;
import mercadoZoshia.service.FuncionarioService;
import mercadoZoshia.service.ProdutoService;

public class MenuEstoque {

    private final EstoqueService estoqueService;
    private final ProdutoService produtoService;
    private final FornecedorService fornecedorService;
    private final FuncionarioService funcionarioService;

    public MenuEstoque(EstoqueService estoqueService, ProdutoService produtoService, FornecedorService fornecedorService, FuncionarioService funcionarioService) {
        this.estoqueService = estoqueService;
        this.produtoService = produtoService;
        this.fornecedorService = fornecedorService;
        this.funcionarioService = funcionarioService;
    }

    public void executar() {
        throw new UnsupportedOperationException();
    }
}
