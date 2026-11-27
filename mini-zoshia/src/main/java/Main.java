import mercadoZoshia.menu.MenuEstoque;
import mercadoZoshia.menu.MenuFinanceiro;
import mercadoZoshia.menu.MenuFornecedores;
import mercadoZoshia.menu.MenuFuncionarios;
import mercadoZoshia.menu.MenuPrincipal;
import mercadoZoshia.menu.MenuProdutos;
import mercadoZoshia.menu.MenuVendas;
import mercadoZoshia.service.EstoqueService;
import mercadoZoshia.service.FinanceiroService;
import mercadoZoshia.service.FornecedorService;
import mercadoZoshia.service.FuncionarioService;
import mercadoZoshia.service.ProdutoService;
import mercadoZoshia.service.VendaService;

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
