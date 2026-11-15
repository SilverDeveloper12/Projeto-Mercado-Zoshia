package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;
import modelo.Fornecedor;

public class FornecedorService {

    private final List<Fornecedor> lista = new ArrayList<>();

    public void adicionar(Fornecedor item) throws ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public List<Fornecedor> listar() {
        throw new UnsupportedOperationException();
    }

    public Fornecedor buscarPorId(int id) throws ItemNaoEncontradoException {
        throw new UnsupportedOperationException();
    }

    public List<Fornecedor> buscarPorNome(String nome) {
        throw new UnsupportedOperationException();
    }

    public void editar(int id, String nome, String telefone, String email, String cnpj)
            throws ItemNaoEncontradoException, ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public void alterarStatus(int id, boolean ativo) throws ItemNaoEncontradoException {
        throw new UnsupportedOperationException();
    }
}
