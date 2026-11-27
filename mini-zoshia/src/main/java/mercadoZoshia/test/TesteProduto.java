package mercadoZoshia.test;

import mercadoZoshia.exceptions.ValidacaoException;
import mercadoZoshia.model.Produto;

public class TesteProduto extends Produto {

    public TesteProduto(String codigo, String nome, int quantidade) throws ValidacaoException {
        super(codigo, nome, "teste", 1.0, 2.0, quantidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println(getNome());
    }

    @Override
    public boolean estaValido(int diaHoje, int mesAtual, int anoAtual) {
        return true;
    }
}