package mercadoZoshia.model;

import mercadoZoshia.exceptions.ValidacaoException;

public class Funcionario extends Pessoa {

    private String cargo;
    private boolean ativo;

    public Funcionario(int id, String nome, String telefone, String email, String cargo) throws ValidacaoException {
        super(id, nome, telefone, email);
        setCargo(cargo);
        this.ativo = true;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws ValidacaoException {
        this.cargo = texto(cargo, "cargo");
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String getDescricao() {
        return "Funcionário #" + getId() + " - " + getNome() + " (" + cargo + ") - " + (ativo ? "ativo" : "inativo");
    }
}
