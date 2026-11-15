package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueInsuficienteException;
import excecao.ValidacaoException;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.MovimentacaoEstoque;
import modelo.Produto;
import modelo.TipoMovimento;

public class EstoqueService {

    private final ProdutoService produtoService;
    private final List<MovimentacaoEstoque> historico = new ArrayList<>();

    public EstoqueService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void registrarEntrada(Produto produto, int quantidade, String motivo, Fornecedor fornecedor,
            Funcionario funcionario) throws ValidacaoException {
        produto.adicionarEstoque(quantidade);
        historico.add(new MovimentacaoEstoque(produto, quantidade, TipoMovimento.ENTRADA, motivo, fornecedor, funcionario));
    }

    public void registrarSaida(Produto produto, int quantidade, TipoMovimento tipo, String motivo,
            Funcionario funcionario) throws EstoqueInsuficienteException, ValidacaoException {
        produto.removerEstoque(quantidade);
        historico.add(new MovimentacaoEstoque(produto, quantidade, tipo, motivo, null, funcionario));
    }

    public List<Produto> listarEstoqueBaixo(int limite) {
        throw new UnsupportedOperationException();
    }

    public List<Produto> listarZerados() {
        throw new UnsupportedOperationException();
    }

    public List<MovimentacaoEstoque> historicoDoProduto(String codigo) {
        throw new UnsupportedOperationException();
    }
}
