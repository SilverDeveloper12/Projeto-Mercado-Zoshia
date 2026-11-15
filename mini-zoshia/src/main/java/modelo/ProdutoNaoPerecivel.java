package modelo;

import excecao.ValidacaoException;

public class ProdutoNaoPerecivel extends Produto {

    public ProdutoNaoPerecivel(String codigo, String nome, String categoria, double precoCusto, double precoVenda,
            int quantidade) throws ValidacaoException {
        super(codigo, nome, categoria, precoCusto, precoVenda, quantidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println(getNome());
    }

    @Override
    public boolean estaValido(int diaAtual, int mesAtual, int anoAtual) {
        return true;
    }
}
