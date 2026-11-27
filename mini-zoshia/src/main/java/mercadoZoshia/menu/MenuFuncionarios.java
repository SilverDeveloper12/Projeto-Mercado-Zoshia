
package mercadoZoshia.menu;

import java.util.List;

import mercadoZoshia.exceptions.ItemNaoEncontradoException;
import mercadoZoshia.exceptions.ValidacaoException;
import mercadoZoshia.model.Funcionario;
import mercadoZoshia.service.FuncionarioService;
import mercadoZoshia.util.Entrada;

public class MenuFuncionarios {

    private final FuncionarioService funcionarioService;

    public MenuFuncionarios(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    public void executar() {

        int opcao;

        do {
            System.out.println("\n=== MENU DE FUNCIONÁRIOS ===");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Editar funcionário");
            System.out.println("6 - Ativar/Inativar funcionário");
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

        System.out.println("\n=== CADASTRAR FUNCIONÁRIO ===");

        int id = Entrada.lerInt("ID: ");
        String nome = Entrada.lerTexto("Nome: ");
        String telefone = Entrada.lerTexto("Telefone: ");
        String email = Entrada.lerTexto("E-mail: ");
        String cargo = Entrada.lerTexto("Cargo: ");

        Funcionario funcionario = new Funcionario(
                id, nome, telefone, email, cargo
        );

        funcionarioService.adicionar(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void listar() {

        List<Funcionario> funcionarios = funcionarioService.listar();

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

    private void buscarId() throws ItemNaoEncontradoException {

        int id = Entrada.lerInt("Digite o ID: ");

        Funcionario f = funcionarioService.buscarPorId(id);

        System.out.println(f);
    }

    private void buscarNome() {

        String nome = Entrada.lerTexto("Digite o nome: ");

        List<Funcionario> encontrados =
                funcionarioService.buscarPorNome(nome);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
            return;
        }

        for (Funcionario f : encontrados) {
            System.out.println(f);
        }
    }

    private void editar()
            throws ItemNaoEncontradoException, ValidacaoException {

        int id = Entrada.lerInt("ID do funcionário: ");

        String nome = Entrada.lerTexto("Novo nome: ");
        String telefone = Entrada.lerTexto("Novo telefone: ");
        String email = Entrada.lerTexto("Novo e-mail: ");
        String cargo = Entrada.lerTexto("Novo cargo: ");

        funcionarioService.editar(
                id, nome, telefone, email, cargo
        );

        System.out.println("Funcionário atualizado!");
    }

    private void alterarStatus()
            throws ItemNaoEncontradoException {

        int id = Entrada.lerInt("ID do funcionário: ");

        System.out.println("1 - Ativar");
        System.out.println("2 - Inativar");

        int opcao = Entrada.lerInt("Escolha: ");

        if (opcao != 1 && opcao != 2) {
            System.out.println("Opção inválida.");
            return;
        }

        funcionarioService.alterarStatus(id, opcao == 1);

        System.out.println("Status atualizado!");
    }
}
