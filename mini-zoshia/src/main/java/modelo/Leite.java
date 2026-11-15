package modelo;

import excecao.ValidacaoException;

public class Leite extends ProdutoPerecivel {

    public Leite(int quantidade, int diaValidade, int mesValidade, int anoValidade) throws ValidacaoException {
        super("LTE001", "Leite", "Laticínios", 0.0, 7.50, quantidade, diaValidade, mesValidade, anoValidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println("Leite de Vaca 1L");
    }
}
