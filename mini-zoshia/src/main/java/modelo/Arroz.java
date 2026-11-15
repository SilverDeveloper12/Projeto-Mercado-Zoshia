package modelo;

import excecao.ValidacaoException;

public class Arroz extends ProdutoNaoPerecivel {

    public Arroz(int quantidade) throws ValidacaoException {
        super("ARZ001", "Arroz", "Grãos", 0.0, 7.0, quantidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println("Arroz Tio Pedro 1kg");
    }
}
