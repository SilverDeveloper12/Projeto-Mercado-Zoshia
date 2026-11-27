package mercadoZoshia.service;

import java.util.ArrayList;
import java.util.List;

import mercadoZoshia.exceptions.EstoqueInsuficienteException;
import mercadoZoshia.exceptions.ValidacaoException;
import mercadoZoshia.model.Venda;
import mercadoZoshia.model.pagamento.FormaPagamento;

public class VendaService {

    private final EstoqueService estoqueService;
    private final List<Venda> vendas = new ArrayList<>();

    public VendaService(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    public double finalizarVenda(Venda venda, FormaPagamento forma, double valorRecebido)
            throws ValidacaoException, EstoqueInsuficienteException {
        throw new UnsupportedOperationException();
    }

    public List<Venda> listarVendas() {
        throw new UnsupportedOperationException();
    }
}
