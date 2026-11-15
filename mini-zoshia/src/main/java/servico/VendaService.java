package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueInsuficienteException;
import excecao.ValidacaoException;
import modelo.Venda;
import pagamento.FormaPagamento;

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
