package mercadoZoshia.model;

import java.time.LocalDateTime;

public class MovimentacaoEstoque {

    private final Produto produto;
    private final int quantidade;
    private final TipoMovimento tipo;
    private final LocalDateTime data;
    private final String motivo;
    private final Fornecedor fornecedor;
    private final Funcionario funcionario;

    public MovimentacaoEstoque(Produto produto, int quantidade, TipoMovimento tipo, String motivo,
            Fornecedor fornecedor, Funcionario funcionario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.data = LocalDateTime.now();
        this.motivo = motivo;
        this.fornecedor = fornecedor;
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public TipoMovimento getTipo() {
        return tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getMotivo() {
        return motivo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Override
    public String toString() {
        return data + " | " + tipo + " | " + produto.getNome() + " | qtd " + quantidade + " | " + motivo;
    }
}
