package modelo;

import java.time.LocalDateTime;

public abstract class Movimentacao {

    private final String descricao;
    private final double valor;
    private final LocalDateTime data;

    protected Movimentacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public abstract double getValorComSinal();
}
