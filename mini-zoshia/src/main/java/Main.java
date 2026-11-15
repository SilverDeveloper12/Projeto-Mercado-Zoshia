import menu.MenuEstoque;
import menu.MenuFinanceiro;
import menu.MenuFornecedores;
import menu.MenuFuncionarios;
import menu.MenuPrincipal;
import menu.MenuProdutos;
import menu.MenuVendas;
import servico.EstoqueService;
import servico.FinanceiroService;
import servico.FornecedorService;
import servico.FuncionarioService;
import servico.ProdutoService;
import servico.VendaService;

public class Main {

    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();
        FornecedorService fornecedorService = new FornecedorService();
        FuncionarioService funcionarioService = new FuncionarioService();
        EstoqueService estoqueService = new EstoqueService(produtoService);
        VendaService vendaService = new VendaService(estoqueService);
        FinanceiroService financeiroService = new FinanceiroService();

        MenuPrincipal menuPrincipal = new MenuPrincipal(
                new MenuProdutos(produtoService),
                new MenuEstoque(estoqueService, produtoService, fornecedorService, funcionarioService),
                new MenuFornecedores(fornecedorService),
                new MenuFuncionarios(funcionarioService),
                new MenuVendas(vendaService, produtoService, funcionarioService, financeiroService),
                new MenuFinanceiro(financeiroService));

        menuPrincipal.executar();
    }
}
