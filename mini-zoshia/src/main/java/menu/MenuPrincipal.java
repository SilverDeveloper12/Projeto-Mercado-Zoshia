package menu;

import util.Entrada;

public class MenuPrincipal {

    private final MenuProdutos menuProdutos;
    private final MenuEstoque menuEstoque;
    private final MenuFornecedores menuFornecedores;
    private final MenuFuncionarios menuFuncionarios;
    private final MenuVendas menuVendas;
    private final MenuFinanceiro menuFinanceiro;

    public MenuPrincipal(MenuProdutos menuProdutos, MenuEstoque menuEstoque, MenuFornecedores menuFornecedores,
            MenuFuncionarios menuFuncionarios, MenuVendas menuVendas, MenuFinanceiro menuFinanceiro) {
        this.menuProdutos = menuProdutos;
        this.menuEstoque = menuEstoque;
        this.menuFornecedores = menuFornecedores;
        this.menuFuncionarios = menuFuncionarios;
        this.menuVendas = menuVendas;
        this.menuFinanceiro = menuFinanceiro;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println();
            System.out.println("=== MINI ZOSHIA ===");
            System.out.println("1 - Produtos");
            System.out.println("2 - Estoque");
            System.out.println("3 - Fornecedores");
            System.out.println("4 - Funcionários");
            System.out.println("5 - Caixa / Vendas");
            System.out.println("6 - Financeiro");
            System.out.println("0 - Sair");
            opcao = Entrada.lerInt("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    menuProdutos.executar();
                    break;
                case 2:
                    menuEstoque.executar();
                    break;
                case 3:
                    menuFornecedores.executar();
                    break;
                case 4:
                    menuFuncionarios.executar();
                    break;
                case 5:
                    menuVendas.executar();
                    break;
                case 6:
                    menuFinanceiro.executar();
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
