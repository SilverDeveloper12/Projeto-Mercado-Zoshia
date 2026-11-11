public abstract class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    

    @Override
    public String toString() {
        return this.nome + " - " + this.quantidade 
                     + " x R$" + this.preco;
    }



    public String getNome() {
        return this.nome;
    }
    public double getPreco() {
        return this.preco * this.quantidade;
    }
    public abstract void mostraDescricao();
    public abstract boolean estaValido( int diaHoje, int mesAtual, int anoAtual );

}
