package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;
import modelo.Funcionario;

public class FuncionarioService {

    private final List<Funcionario> lista = new ArrayList<>();

    public void adicionar(Funcionario item) throws ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public List<Funcionario> listar() {
        throw new UnsupportedOperationException();
    }

    public Funcionario buscarPorId(int id) throws ItemNaoEncontradoException {
        throw new UnsupportedOperationException();
    }

    public List<Funcionario> buscarPorNome(String nome) {
        throw new UnsupportedOperationException();
    }

    public void editar(int id, String nome, String telefone, String email, String cargo)
            throws ItemNaoEncontradoException, ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public void alterarStatus(int id, boolean ativo) throws ItemNaoEncontradoException {
        throw new UnsupportedOperationException();
    }
}
