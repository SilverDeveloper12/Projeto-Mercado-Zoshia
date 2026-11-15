package modelo;

import java.util.Locale;

import excecao.EstoqueInsuficienteException;
import excecao.ValidacaoException;

public abstract class Produto {

    private final String codigo;
    private String nome;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int quantidade;
    private boolean ativo;

    public Produto(String codigo, String nome, String categoria, double precoCusto, double precoVenda, int quantidade)
            throws ValidacaoException {
        this.codigo = texto(codigo, "código");
        setNome(nome);
        setCategoria(categoria);
        setPrecoCusto(precoCusto);
        setPrecoVenda(precoVenda);
        if (quantidade < 0) {
            throw new ValidacaoException("A quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
        this.ativo = true;
    }

    private static String texto(String valor, String campo) throws ValidacaoException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidacaoException("O campo " + campo + " não pode ser vazio.");
        }
        return valor.trim();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ValidacaoException {
        this.nome = texto(nome, "nome");
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws ValidacaoException {
        this.categoria = texto(categoria, "categoria");
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) throws ValidacaoException {
        if (precoCusto < 0) {
            throw new ValidacaoException("O preço de custo não pode ser negativo.");
        }
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) throws ValidacaoException {
        if (precoVenda < 0) {
            throw new ValidacaoException("O preço de venda não pode ser negativo.");
        }
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void adicionarEstoque(int qtd) throws ValidacaoException {
        if (qtd <= 0) {
            throw new ValidacaoException("A quantidade deve ser maior que zero.");
        }
        quantidade += qtd;
    }

    public void removerEstoque(int qtd) throws EstoqueInsuficienteException, ValidacaoException {
        if (qtd <= 0) {
            throw new ValidacaoException("A quantidade deve ser maior que zero.");
        }
        if (qtd > quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente de " + nome + ": disponível " + quantidade
                    + ", pedido " + qtd + ".");
        }
        quantidade -= qtd;
    }

    public abstract void mostraDescricao();

    public abstract boolean estaValido(int diaHoje, int mesAtual, int anoAtual);

    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pt-BR"),
                "[%s] %s | %s | custo R$ %.2f | venda R$ %.2f | qtd %d | %s",
                codigo, nome, categoria, precoCusto, precoVenda, quantidade, ativo ? "ativo" : "inativo");
    }
}
