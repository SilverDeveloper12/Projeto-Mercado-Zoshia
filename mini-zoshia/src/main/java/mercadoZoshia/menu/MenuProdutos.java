
package mercadoZoshia.menu;

import java.util.List;

import mercadoZoshia.exceptions.ItemNaoEncontradoException;
import mercadoZoshia.exceptions.ValidacaoException;
import mercadoZoshia.model.Produto;
import mercadoZoshia.model.ProdutoPerecivel;
import mercadoZoshia.model.ProdutoNaoPerecivel;
import mercadoZoshia.service.ProdutoService;
import util.Entrada;

public class MenuProdutos {

    private final ProdutoService produtoService;

    public MenuProdutos(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void executar() {

        int opcao;

        do {
            System.out.println("\n=== MENU DE PRODUTOS ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar por código");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Editar produto");
            System.out.println("6 - Ativar/Inativar produto");
            System.out.println("0 - Voltar");

            opcao = Entrada.lerInt("Escolha: ");

            try {
                switch (opcao) {

                    case 1:
                        cadastrar();
                        break;

                    case 2:
                        listar();
                        break;

                    case 3:
                        buscarCodigo();
                        break;

                    case 4:
                        buscarNome();
                        break;

                    case 5:
                        editar();
                        break;

                    case 6:
                        alterarStatus();
                        break;

                    case 0:
                        System.out.println("Voltando...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (ValidacaoException |
                     ItemNaoEncontradoException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    private void cadastrar() throws ValidacaoException {

        System.out.println("\n=== CADASTRAR PRODUTO ===");

        String codigo = Entrada.lerTexto("Código: ");
        String nome = Entrada.lerTexto("Nome: ");
        String categoria = Entrada.lerTexto("Categoria: ");
        double custo = Entrada.lerDouble("Preço de custo: ");
        double venda = Entrada.lerDouble("Preço de venda: ");
        int quantidade = Entrada.lerInt("Quantidade inicial: ");

        System.out.println("1 - Perecível");
        System.out.println("2 - Não perecível");

        int tipo = Entrada.lerInt("Tipo de produto: ");

        Produto produto;

        if (tipo == 1) {

            int dia = Entrada.lerInt("Dia de validade: ");
            int mes = Entrada.lerInt("Mês de validade: ");
            int ano = Entrada.lerInt("Ano de validade: ");

            produto = new ProdutoPerecivel(
                    codigo, nome, categoria, custo, venda,
                    quantidade, dia, mes, ano
            );

        } else if (tipo == 2) {

            produto = new ProdutoNaoPerecivel(
                    codigo, nome, categoria, custo, venda,
                    quantidade
            );

        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        produtoService.adicionar(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private void listar() {

        List<Produto> produtos = produtoService.listar();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    private void buscarCodigo()
            throws ItemNaoEncontradoException {

        String codigo = Entrada.lerTexto("Digite o código: ");

        Produto p = produtoService.buscarPorCodigo(codigo);

        System.out.println(p);
    }

    private void buscarNome() {

        String nome = Entrada.lerTexto("Digite o nome: ");

        List<Produto> encontrados =
                produtoService.buscarPorNome(nome);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }

        for (Produto p : encontrados) {
            System.out.println(p);
        }
    }

    private void editar()
            throws ItemNaoEncontradoException, ValidacaoException {

        String codigo = Entrada.lerTexto("Código do produto: ");

        String nome = Entrada.lerTexto("Novo nome: ");
        String categoria = Entrada.lerTexto("Nova categoria: ");

        double custo = Entrada.lerDouble("Novo preço de custo: ");
        double venda = Entrada.lerDouble("Novo preço de venda: ");

        produtoService.editar(
                codigo, nome, categoria, custo, venda
        );

        System.out.println("Produto atualizado!");
    }

    private void alterarStatus()
            throws ItemNaoEncontradoException {

        String codigo = Entrada.lerTexto("Código do produto: ");

        System.out.println("1 - Ativar");
        System.out.println("2 - Inativar");

        int opcao = Entrada.lerInt("Escolha: ");

        if (opcao != 1 && opcao != 2) {
            System.out.println("Opção inválida.");
            return;
        }

        produtoService.alterarStatus(codigo, opcao == 1);

        System.out.println("Status atualizado!");
    }
}
