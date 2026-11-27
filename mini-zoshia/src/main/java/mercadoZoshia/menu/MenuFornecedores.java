
package mercadoZoshia.menu;

import java.util.List;

import mercadoZoshia.exceptions.ItemNaoEncontradoException;
import mercadoZoshia.exceptions.ValidacaoException;
import mercadoZoshia.model.Fornecedor;
import mercadoZoshia.service.FornecedorService;
import mercadoZoshia.util.Entrada;

public class MenuFornecedores {

    private final FornecedorService fornecedorService;

    public MenuFornecedores(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    public void executar() {

        int opcao;

        do {
            System.out.println("\n=== MENU DE FORNECEDORES ===");
            System.out.println("1 - Cadastrar fornecedor");
            System.out.println("2 - Listar fornecedores");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Editar fornecedor");
            System.out.println("6 - Ativar/Inativar fornecedor");
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
                        buscarId();
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

        System.out.println("\n=== CADASTRAR FORNECEDOR ===");

        int id = Entrada.lerInt("ID: ");
        String nome = Entrada.lerTexto("Nome: ");
        String telefone = Entrada.lerTexto("Telefone: ");
        String email = Entrada.lerTexto("E-mail: ");
        String cnpj = Entrada.lerTexto("CNPJ: ");

        Fornecedor fornecedor = new Fornecedor(
                id, nome, telefone, email, cnpj
        );

        fornecedorService.adicionar(fornecedor);

        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    private void listar() {

        List<Fornecedor> fornecedores = fornecedorService.listar();

        if (fornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastrado.");
            return;
        }

        for (Fornecedor f : fornecedores) {
            System.out.println(f);
        }
    }

    private void buscarId() throws ItemNaoEncontradoException {

        int id = Entrada.lerInt("Digite o ID: ");

        Fornecedor f = fornecedorService.buscarPorId(id);

        System.out.println(f);
    }

    private void buscarNome() {

        String nome = Entrada.lerTexto("Digite o nome: ");

        List<Fornecedor> encontrados =
                fornecedorService.buscarPorNome(nome);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum fornecedor encontrado.");
            return;
        }

        for (Fornecedor f : encontrados) {
            System.out.println(f);
        }
    }

    private void editar()
            throws ItemNaoEncontradoException, ValidacaoException {

        int id = Entrada.lerInt("ID do fornecedor: ");

        String nome = Entrada.lerTexto("Novo nome: ");
        String telefone = Entrada.lerTexto("Novo telefone: ");
        String email = Entrada.lerTexto("Novo e-mail: ");
        String cnpj = Entrada.lerTexto("Novo CNPJ: ");

        fornecedorService.editar(
                id, nome, telefone, email, cnpj
        );

        System.out.println("Fornecedor atualizado!");
    }

    private void alterarStatus()
            throws ItemNaoEncontradoException {

        int id = Entrada.lerInt("ID do fornecedor: ");

        System.out.println("1 - Ativar");
        System.out.println("2 - Inativar");

        int opcao = Entrada.lerInt("Escolha: ");

        if (opcao != 1 && opcao != 2) {
            System.out.println("Opção inválida.");
            return;
        }

        fornecedorService.alterarStatus(id, opcao == 1);

        System.out.println("Status atualizado!");
    }
}
