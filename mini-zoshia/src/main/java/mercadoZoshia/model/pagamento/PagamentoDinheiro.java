package mercadoZoshia.model.pagamento;

import mercadoZoshia.exceptions.ValidacaoException;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public double pagar(double total, double valorRecebido) throws ValidacaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getNome() {
        return "Dinheiro";
    }
}
