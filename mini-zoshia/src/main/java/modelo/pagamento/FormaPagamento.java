package modelo.pagamento;

import excecao.ValidacaoException;

public interface FormaPagamento {

    double pagar(double total, double valorRecebido) throws ValidacaoException;

    String getNome();
}
