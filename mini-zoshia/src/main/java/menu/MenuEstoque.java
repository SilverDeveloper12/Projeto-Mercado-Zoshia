package menu;

import servico.EstoqueService;
import servico.FornecedorService;
import servico.FuncionarioService;
import servico.ProdutoService;

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
