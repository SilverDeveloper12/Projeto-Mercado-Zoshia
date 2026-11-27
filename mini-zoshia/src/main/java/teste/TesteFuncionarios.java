package teste;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;
import modelo.Funcionario;
import servico.FuncionarioService;

public class TesteFuncionarios {

    private static int falhas = 0;

    public static void main(String[] args) throws Exception {

        FuncionarioService service = new FuncionarioService();
        service.adicionar(new Funcionario(1, "João Silva", "(11) 99999-9999", "joao@email.com", "Caixa"));
        service.adicionar(new Funcionario(2, "Maria Souza", "11988887777", "maria@email.com", "Gerente"));

        // validações
        espera("telefone curto", () -> new Funcionario(3, "A", "123", "a@a.com", "x"));
        espera("e-mail sem @", () -> new Funcionario(3, "A", "11999999999", "aaa.com", "x"));
        espera("nome vazio", () -> new Funcionario(3, " ", "11999999999", "a@a.com", "x"));
        espera("ID duplicado", () -> service.adicionar(new Funcionario(1, "B", "11999999999", "b@b.com", "x")));
        confere("telefone normalizado", service.buscarPorId(1).getTelefone().equals("11999999999"));

        // buscas
        confere("buscarPorNome(null) vazio", service.buscarPorNome(null).isEmpty());
        confere("buscarPorNome 'maria'", service.buscarPorNome("maria").size() == 1);
        confere("buscarPorCargo 'caixa'", service.buscarPorCargo("caixa").size() == 1);

        // editar: vazio mantém, inválido não altera nada
        service.editar(1, "", "", "", "Supervisor");
        confere("editar mantém nome", service.buscarPorId(1).getNome().equals("João Silva"));
        confere("editar muda cargo", service.buscarPorId(1).getCargo().equals("Supervisor"));
        espera("editar com e-mail inválido", () -> service.editar(1, "Novo Nome", "", "invalido", ""));
        confere("editar inválido não alterou nome", service.buscarPorId(1).getNome().equals("João Silva"));

        // regra de ativo
        confere("exigirAtivo ativo passa", service.exigirAtivo(1) != null);
        service.alterarStatus(1, false);
        espera("exigirAtivo inativo", () -> service.exigirAtivo(1));
        espera("exigirAtivo null", () -> service.exigirAtivo(null));
        esperaNaoEncontrado("exigirAtivo id inexistente", () -> service.exigirAtivo(999));
        confere("listarAtivos só 1", service.listarAtivos().size() == 1);

        System.out.println(falhas == 0 ? "\nTUDO OK" : "\nFALHAS: " + falhas);
    }

    interface Acao { void rodar() throws Exception; }

    private static void espera(String nome, Acao a) {
        try {
            a.rodar();
            System.out.println("FALHOU (devia lançar ValidacaoException): " + nome);
            falhas++;
        } catch (ValidacaoException e) {
            System.out.println("ok: " + nome + " -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FALHOU (exceção errada): " + nome + " " + e);
            falhas++;
        }
    }

    private static void esperaNaoEncontrado(String nome, Acao a) {
        try {
            a.rodar();
            System.out.println("FALHOU: " + nome);
            falhas++;
        } catch (ItemNaoEncontradoException e) {
            System.out.println("ok: " + nome + " -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FALHOU (exceção errada): " + nome + " " + e);
            falhas++;
        }
    }

    private static void confere(String nome, boolean condicao) {
        if (condicao) {
            System.out.println("ok: " + nome);
        } else {
            System.out.println("FALHOU: " + nome);
            falhas++;
        }
    }
}

