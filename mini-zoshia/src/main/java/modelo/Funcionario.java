package modelo;

import excecao.ValidacaoException;

public class Funcionario extends Pessoa {

    private String cargo;
    private boolean ativo;

    public Funcionario(int id, String nome, String telefone, String email, String cargo) throws ValidacaoException {
        super(id, nome, telefone, email);
        setCargo(cargo);
        this.ativo = true;
    }

    @Override
    public void setTelefone(String telefone) throws ValidacaoException {
        String digitos = texto(telefone, "telefone").replaceAll("\\D", "");
        if (digitos.length() < 10 || digitos.length() > 11) {
            throw new ValidacaoException("O telefone deve ter 10 ou 11 dígitos (com DDD).");
        }
        super.setTelefone(digitos);
    }
    @Override
    public void setEmail(String email) throws ValidacaoException {
        String valor = texto(email, "e-mail");
        if (!valor.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new ValidacaoException("E-mail inválido.");
        }
        super.setEmail(valor);
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
