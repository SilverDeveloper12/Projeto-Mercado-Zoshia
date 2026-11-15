package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.ValidacaoException;
import modelo.Movimentacao;

public class FinanceiroService {

    private final List<Movimentacao> movimentacoes = new ArrayList<>();

    public void registrarReceita(String descricao, double valor) throws ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public void registrarDespesa(String descricao, double valor, String categoria) throws ValidacaoException {
        throw new UnsupportedOperationException();
    }

    public double totalReceitas() {
        throw new UnsupportedOperationException();
    }

    public double totalDespesas() {
        throw new UnsupportedOperationException();
    }

    public double saldo() {
        throw new UnsupportedOperationException();
    }

    public List<Movimentacao> historico() {
        throw new UnsupportedOperationException();
    }
}
