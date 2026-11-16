
package teste;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;

import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.ProdutoNaoPerecivel;

import servico.ProdutoService;
import servico.FornecedorService;
import servico.FuncionarioService;

public class TesteCadastros {

    public static void main(String[] args) throws Exception {

        System.out.println("=== TESTE DOS CADASTROS ===");

        testarProdutos();
        testarFornecedores();
        testarFuncionarios();

        System.out.println("\nTodos os testes foram executados!");
    }

    private static void testarProdutos() throws Exception {

        System.out.println("\n--- TESTANDO PRODUTOS ---");

        ProdutoService service = new ProdutoService();

        ProdutoNaoPerecivel produto = new ProdutoNaoPerecivel(
                "P001", "Arroz", "Grãos", 20.00, 30.00, 10
        );

        service.adicionar(produto);

        System.out.println("Cadastro: OK");

        System.out.println("Listagem: " + service.listar().size());

        System.out.println(
                "Busca: " + service.buscarPorCodigo("P001").getNome()
        );

        service.editar(
                "P001", "Arroz Integral", "Grãos", 22.00, 35.00
        );

        System.out.println(
                "Edição: " + service.buscarPorCodigo("P001").getNome()
        );

        service.alterarStatus("P001", false);

        System.out.println(
                "Inativação: " +
                        !service.buscarPorCodigo("P001").isAtivo()
        );

        try {
            service.adicionar(produto);
        } catch (ValidacaoException e) {
            System.out.println("Código duplicado: OK");
        }

        try {
            service.buscarPorCodigo("P999");
        } catch (ItemNaoEncontradoException e) {
            System.out.println("Produto inexistente: OK");
        }
    }

    private static void testarFornecedores() throws Exception {

        System.out.println("\n--- TESTANDO FORNECEDORES ---");

        FornecedorService service = new FornecedorService();

        Fornecedor fornecedor = new Fornecedor(
                1, "Fornecedor ABC", "11999999999",
                "abc@email.com", "12345678000199"
        );

        service.adicionar(fornecedor);

        System.out.println("Cadastro: OK");

        System.out.println("Listagem: " + service.listar().size());

        System.out.println(
                "Busca: " + service.buscarPorId(1).getNome()
        );

        service.editar(
                1, "Fornecedor XYZ", "11888888888",
                "xyz@email.com", "98765432000199"
        );

        System.out.println(
                "Edição: " + service.buscarPorId(1).getNome()
        );

        service.alterarStatus(1, false);

        System.out.println(
                "Inativação: " + !service.buscarPorId(1).isAtivo()
        );

        try {
            service.adicionar(fornecedor);
        } catch (ValidacaoException e) {
            System.out.println("ID duplicado: OK");
        }

        try {
            service.buscarPorId(999);
        } catch (ItemNaoEncontradoException e) {
            System.out.println("Fornecedor inexistente: OK");
        }
    }

    private static void testarFuncionarios() throws Exception {

        System.out.println("\n--- TESTANDO FUNCIONÁRIOS ---");

        FuncionarioService service = new FuncionarioService();

        Funcionario funcionario = new Funcionario(
                1, "João Silva", "11999999999",
                "joao@email.com", "Caixa"
        );

        service.adicionar(funcionario);

        System.out.println("Cadastro: OK");

        System.out.println("Listagem: " + service.listar().size());

        System.out.println(
                "Busca: " + service.buscarPorId(1).getNome()
        );

        service.editar(
                1, "João Santos", "11888888888",
                "joao.santos@email.com", "Gerente"
        );

        System.out.println(
                "Edição: " + service.buscarPorId(1).getNome()
        );

        service.alterarStatus(1, false);

        System.out.println(
                "Inativação: " + !service.buscarPorId(1).isAtivo()
        );

        try {
            service.adicionar(funcionario);
        } catch (ValidacaoException e) {
            System.out.println("ID duplicado: OK");
        }

        try {
            service.buscarPorId(999);
        } catch (ItemNaoEncontradoException e) {
            System.out.println("Funcionário inexistente: OK");
        }
    }
}
