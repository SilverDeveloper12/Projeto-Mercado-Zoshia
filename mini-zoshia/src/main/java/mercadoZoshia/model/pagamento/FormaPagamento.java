package mercadoZoshia.model.pagamento;

import mercadoZoshia.exceptions.ValidacaoException;

public interface FormaPagamento {

    double pagar(double total, double valorRecebido) throws ValidacaoException;

    String getNome();
}
