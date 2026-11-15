package modelo;

import excecao.ValidacaoException;

public class Maca extends ProdutoPerecivel {

    public Maca(int quantidade, int diaValidade, int mesValidade, int anoValidade) throws ValidacaoException {
        super("MCA001", "Maçã", "Frutas", 0.0, 12.0, quantidade, diaValidade, mesValidade, anoValidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println("Maçã Gala 1kg");
    }
}
