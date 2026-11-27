package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;
import modelo.Funcionario;

public class FuncionarioService {

    private final List<Funcionario> lista = new ArrayList<>();

    // CADASTRAR FUNCIONÁRIO
    public void adicionar(Funcionario item) throws ValidacaoException {

        if (item == null) {
            throw new ValidacaoException("Funcionário inválido.");
        }

        for (Funcionario f : lista) {
            if (f.getId() == item.getId()) {
                throw new ValidacaoException("Já existe um funcionário com esse ID.");
            }
        }

        lista.add(item);
    }

    // LISTAR FUNCIONÁRIOS
    public List<Funcionario> listar() {
        return new ArrayList<>(lista);
    }

    // LISTAR SÓ OS ATIVOS
    public List<Funcionario> listarAtivos() {
        List<Funcionario> ativos = new ArrayList<>();

        for (Funcionario f : lista) {
            if (f.isAtivo()) {
                ativos.add(f);
            }
        }

        return ativos;
    }

    // BUSCAR POR ID
    public Funcionario buscarPorId(int id) throws ItemNaoEncontradoException {

        for (Funcionario f : lista) {
            if (f.getId() == id) {
                return f;
            }
        }

        throw new ItemNaoEncontradoException("Funcionário não encontrado: " + id);
    }

    // BUSCAR POR NOME
    public List<Funcionario> buscarPorNome(String nome) {

        List<Funcionario> encontrados = new ArrayList<>();

        if (vazio(nome)) {
            return encontrados;
        }

        for (Funcionario f : lista) {
            if (f.getNome().toLowerCase().contains(nome.trim().toLowerCase())) {
                encontrados.add(f);
            }
        }

        return encontrados;
    }

    // BUSCAR POR CARGO
    public List<Funcionario> buscarPorCargo(String cargo) {

        List<Funcionario> encontrados = new ArrayList<>();

        if (vazio(cargo)) {
            return encontrados;
        }

        for (Funcionario f : lista) {
            if (f.getCargo().toLowerCase().contains(cargo.trim().toLowerCase())) {
                encontrados.add(f);
            }
        }

        return encontrados;
    }

    // EDITAR FUNCIONÁRIO (campo vazio = mantém o valor atual)
    public void editar(int id, String nome, String telefone,
                       String email, String cargo)
            throws ItemNaoEncontradoException, ValidacaoException {

        Funcionario f = buscarPorId(id);

        String novoNome = vazio(nome) ? f.getNome() : nome;
        String novoTelefone = vazio(telefone) ? f.getTelefone() : telefone;
        String novoEmail = vazio(email) ? f.getEmail() : email;
        String novoCargo = vazio(cargo) ? f.getCargo() : cargo;

        // Valida tudo antes de alterar: se algo estiver inválido, lança
        // exceção e o funcionário original continua intacto.
        new Funcionario(id, novoNome, novoTelefone, novoEmail, novoCargo);

        f.setNome(novoNome);
        f.setTelefone(novoTelefone);
        f.setEmail(novoEmail);
        f.setCargo(novoCargo);
    }

    // ATIVAR OU INATIVAR FUNCIONÁRIO
    public void alterarStatus(int id, boolean ativo) throws ItemNaoEncontradoException {

        Funcionario f = buscarPorId(id);
        f.setAtivo(ativo);
    }
    //chama este método em vez de repetir o if.
    public Funcionario exigirAtivo(int id) throws ItemNaoEncontradoException, ValidacaoException {
        return exigirAtivo(buscarPorId(id));
    }

    public Funcionario exigirAtivo(Funcionario f) throws ValidacaoException {

        if (f == null) {
            throw new ValidacaoException("Funcionário inválido.");
        }

        if (!f.isAtivo()) {
            throw new ValidacaoException(
                    "O funcionário " + f.getNome() + " está inativo e não pode realizar operações."
            );
        }

        return f;
    }

    private boolean vazio(String s) {
        return s == null || s.trim().isEmpty();
    }
}
