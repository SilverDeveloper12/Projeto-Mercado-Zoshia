package modelo;

import excecao.ValidacaoException;

public class Fornecedor extends Pessoa {

    private String cnpj;
    private boolean ativo;

    public Fornecedor(int id, String nome, String telefone, String email, String cnpj) throws ValidacaoException {
        super(id, nome, telefone, email);
        setCnpj(cnpj);
        this.ativo = true;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws ValidacaoException {
        this.cnpj = texto(cnpj, "CNPJ");
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String getDescricao() {
        return "Fornecedor #" + getId() + " - " + getNome() + " (CNPJ " + cnpj + ") - " + (ativo ? "ativo" : "inativo");
    }
}
