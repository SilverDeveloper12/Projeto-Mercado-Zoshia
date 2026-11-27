
package mercadoZoshia.service;

import java.util.ArrayList;
import java.util.List;

import mercadoZoshia.exceptions.ItemNaoEncontradoException;
import mercadoZoshia.exceptions.ValidacaoException;
import mercadoZoshia.model.Produto;

public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    // CADASTRAR PRODUTO
    public void adicionar(Produto produto) throws ValidacaoException {

        if (produto == null) {
            throw new ValidacaoException("Produto inválido.");
        }

        for (Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(produto.getCodigo())) {
                throw new ValidacaoException("Já existe um produto com esse código.");
            }
        }

        produtos.add(produto);
    }

    // LISTAR PRODUTOS
    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }

    // BUSCAR POR CÓDIGO
    public Produto buscarPorCodigo(String codigo)
            throws ItemNaoEncontradoException {

        for (Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }

        throw new ItemNaoEncontradoException(
                "Produto não encontrado: " + codigo
        );
    }

    // BUSCAR POR NOME
    public List<Produto> buscarPorNome(String nome) {

        List<Produto> encontrados = new ArrayList<>();

        for (Produto p : produtos) {
            if (p.getNome().toLowerCase()
                    .contains(nome.toLowerCase())) {
                encontrados.add(p);
            }
        }

        return encontrados;
    }

    // EDITAR PRODUTO
    public void editar(String codigo, String nome,
                       String categoria, double custo, double venda)
            throws ItemNaoEncontradoException, ValidacaoException {

        Produto p = buscarPorCodigo(codigo);

        p.setNome(nome);
        p.setCategoria(categoria);
        p.setPrecoCusto(custo);
        p.setPrecoVenda(venda);

        // A quantidade em estoque não é alterada aqui.
    }

    // ATIVAR OU INATIVAR PRODUTO
    public void alterarStatus(String codigo, boolean ativo)
            throws ItemNaoEncontradoException {

        Produto p = buscarPorCodigo(codigo);
        p.setAtivo(ativo);
    }
}
