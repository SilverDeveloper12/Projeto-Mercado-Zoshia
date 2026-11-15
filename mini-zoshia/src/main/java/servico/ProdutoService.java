package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;
import modelo.Produto;

public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) throws ValidacaoException {
        produtos.add(produto);
    }

    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }

    public Produto buscarPorCodigo(String codigo) throws ItemNaoEncontradoException {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return produto;
            }
        }
        throw new ItemNaoEncontradoException("Produto não encontrado: " + codigo);
    }

    public List<Produto> buscarPorNome(String nome) {
        throw new UnsupportedOperationException();
    }

    public void editar(String codigo, String nome, String categoria, double custo, double venda)
            throws ItemNaoEncontradoException, ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public void alterarStatus(String codigo, boolean ativo) throws ItemNaoEncontradoException {
        throw new UnsupportedOperationException();
    }
}
