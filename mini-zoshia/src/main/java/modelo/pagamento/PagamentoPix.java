package pagamento;

import excecao.ValidacaoException;

public class PagamentoPix implements FormaPagamento {

    @Override
    public double pagar(double total, double valorRecebido) throws ValidacaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getNome() {
        return "Pix";
    }
}
