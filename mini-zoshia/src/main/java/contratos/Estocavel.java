package contratos;

import excecao.EstoqueInsuficienteException;
import modelo.Produto;

public interface Estocavel {
    void adicionar(Produto produto, int quantidade);
    void remover(Produto produto, int quantidade) throws EstoqueInsuficienteException;
    int consultarQuantidade(Produto produto);
}