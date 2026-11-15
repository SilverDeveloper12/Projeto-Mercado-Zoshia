package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueInsuficienteException;
import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;

public class Venda {

    private final int id;
    private final LocalDateTime data;
    private final Funcionario funcionario;
    private final List<ItemVenda> itens = new ArrayList<>();

    public Venda(int id, Funcionario funcionario) {
        this.id = id;
        this.data = LocalDateTime.now();
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<ItemVenda> getItens() {
        return new ArrayList<>(itens);
    }

    public void adicionarItem(Produto produto, int quantidade) throws EstoqueInsuficienteException, ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public void removerItem(String codigoProduto) throws ItemNaoEncontradoException {
        throw new UnsupportedOperationException();
    }

    public double calcularTotal() {
        throw new UnsupportedOperationException();
    }
}
