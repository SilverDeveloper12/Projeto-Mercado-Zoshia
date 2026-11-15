package modelo;

import excecao.ValidacaoException;

public class ProdutoPerecivel extends Produto {

    private Validador validade;

    public ProdutoPerecivel(String codigo, String nome, String categoria, double precoCusto, double precoVenda,
            int quantidade, int diaValidade, int mesValidade, int anoValidade) throws ValidacaoException {
        super(codigo, nome, categoria, precoCusto, precoVenda, quantidade);
        this.validade = new DataValidade(diaValidade, mesValidade, anoValidade);
    }

    @Override
    public void mostraDescricao() {
        System.out.println(getNome());
    }

    @Override
    public boolean estaValido(int diaHoje, int mesAtual, int anoAtual) {
        return this.validade.estaValido(diaHoje, mesAtual, anoAtual);
    }
}
