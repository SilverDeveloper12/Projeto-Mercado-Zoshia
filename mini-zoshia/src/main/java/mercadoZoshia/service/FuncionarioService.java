
package mercadoZoshia.service;

import java.util.ArrayList;
import java.util.List;

import mercadoZoshia.exceptions.ItemNaoEncontradoException;
import mercadoZoshia.exceptions.ValidacaoException;
import mercadoZoshia.model.Funcionario;

public class FuncionarioService {

    private final List<Funcionario> lista = new ArrayList<>();

    // CADASTRAR FUNCIONÁRIO
    public void adicionar(Funcionario item) throws ValidacaoException {

        if (item == null) {
            throw new ValidacaoException("Funcionário inválido.");
        }

        for (Funcionario f : lista) {
            if (f.getId() == item.getId()) {
                throw new ValidacaoException(
                        "Já existe um funcionário com esse ID."
                );
            }
        }

        lista.add(item);
    }

    // LISTAR FUNCIONÁRIOS
    public List<Funcionario> listar() {
        return new ArrayList<>(lista);
    }

    // BUSCAR POR ID
    public Funcionario buscarPorId(int id)
            throws ItemNaoEncontradoException {

        for (Funcionario f : lista) {
            if (f.getId() == id) {
                return f;
            }
        }

        throw new ItemNaoEncontradoException(
                "Funcionário não encontrado: " + id
        );
    }

    // BUSCAR POR NOME
    public List<Funcionario> buscarPorNome(String nome) {

        List<Funcionario> encontrados = new ArrayList<>();

        for (Funcionario f : lista) {
            if (f.getNome().toLowerCase()
                    .contains(nome.toLowerCase())) {
                encontrados.add(f);
            }
        }

        return encontrados;
    }

    // EDITAR FUNCIONÁRIO
    public void editar(int id, String nome, String telefone,
                       String email, String cargo)
            throws ItemNaoEncontradoException, ValidacaoException {

        Funcionario f = buscarPorId(id);

        f.setNome(nome);
        f.setTelefone(telefone);
        f.setEmail(email);
        f.setCargo(cargo);
    }

    // ATIVAR OU INATIVAR FUNCIONÁRIO
    public void alterarStatus(int id, boolean ativo)
            throws ItemNaoEncontradoException {

        Funcionario f = buscarPorId(id);
        f.setAtivo(ativo);
    }
}
