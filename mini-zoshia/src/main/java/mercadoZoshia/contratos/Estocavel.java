package mercadoZoshia.contratos;

import mercadoZoshia.exceptions.EstoqueInsuficienteException;
import mercadoZoshia.model.Produto;

public interface Estocavel {
    void adicionar(Produto produto, int quantidade);
    void remover(Produto produto, int quantidade) throws EstoqueInsuficienteException;
    int consultarQuantidade(Produto produto);
}