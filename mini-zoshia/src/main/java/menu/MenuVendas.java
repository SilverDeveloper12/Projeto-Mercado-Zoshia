package menu;

import servico.FinanceiroService;
import servico.FuncionarioService;
import servico.ProdutoService;
import servico.VendaService;

public class MenuVendas {

    private final VendaService vendaService;
    private final ProdutoService produtoService;
    private final FuncionarioService funcionarioService;
    private final FinanceiroService financeiroService;

    public MenuVendas(VendaService vendaService, ProdutoService produtoService, FuncionarioService funcionarioService, FinanceiroService financeiroService) {
        this.vendaService = vendaService;
        this.produtoService = produtoService;
        this.funcionarioService = funcionarioService;
        this.financeiroService = financeiroService;
    }

    public void executar() {
        throw new UnsupportedOperationException();
    }
}
