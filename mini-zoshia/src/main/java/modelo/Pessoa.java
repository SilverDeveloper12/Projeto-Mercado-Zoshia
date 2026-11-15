package modelo;

import excecao.ValidacaoException;

public abstract class Pessoa {

    private final int id;
    private String nome;
    private String telefone;
    private String email;

    protected Pessoa(int id, String nome, String telefone, String email) throws ValidacaoException {
        if (id <= 0) {
            throw new ValidacaoException("O id deve ser maior que zero.");
        }
        this.id = id;
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
    }

    protected static String texto(String valor, String campo) throws ValidacaoException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidacaoException("O campo " + campo + " não pode ser vazio.");
        }
        return valor.trim();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ValidacaoException {
        this.nome = texto(nome, "nome");
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws ValidacaoException {
        this.telefone = texto(telefone, "telefone");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ValidacaoException {
        this.email = texto(email, "e-mail");
    }

    public abstract String getDescricao();

    @Override
    public String toString() {
        return getDescricao();
    }
}
