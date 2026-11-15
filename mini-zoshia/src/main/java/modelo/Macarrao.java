package modelo;

import excecao.ValidacaoException;

public class Macarrao extends ProdutoNaoPerecivel {

    public Macarrao(int quantidade) throws ValidacaoException {
        super("MCR001", "Macarrão", "Massas", 0.0, 7.0, quantidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println("Macarrão Dona Berenice 500g");
    }
}
