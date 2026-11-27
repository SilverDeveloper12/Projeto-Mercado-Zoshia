package modelo;

public abstract class Produto {
    private String codigo;
    private String nome;
    private double preco;

    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        setPreco(preco);
    }

    // Cada produto calcula o preço final do seu jeito
    public abstract double calcularPreco();

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nome + " - R$ " + String.format("%.2f", calcularPreco());
    }
}