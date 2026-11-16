
package servico;

import java.util.ArrayList;
import java.util.List;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;
import modelo.Fornecedor;

public class FornecedorService {

    private final List<Fornecedor> lista = new ArrayList<>();

    // CADASTRAR FORNECEDOR
    public void adicionar(Fornecedor item) throws ValidacaoException {

        if (item == null) {
            throw new ValidacaoException("Fornecedor inválido.");
        }

        for (Fornecedor f : lista) {
            if (f.getId() == item.getId()) {
                throw new ValidacaoException(
                        "Já existe um fornecedor com esse ID."
                );
            }
        }

        lista.add(item);
    }

    // LISTAR FORNECEDORES
    public List<Fornecedor> listar() {
        return new ArrayList<>(lista);
    }

    // BUSCAR POR ID
    public Fornecedor buscarPorId(int id)
            throws ItemNaoEncontradoException {

        for (Fornecedor f : lista) {
            if (f.getId() == id) {
                return f;
            }
        }

        throw new ItemNaoEncontradoException(
                "Fornecedor não encontrado: " + id
        );
    }

    // BUSCAR POR NOME
    public List<Fornecedor> buscarPorNome(String nome) {

        List<Fornecedor> encontrados = new ArrayList<>();

        for (Fornecedor f : lista) {
            if (f.getNome().toLowerCase()
                    .contains(nome.toLowerCase())) {
                encontrados.add(f);
            }
        }

        return encontrados;
    }

    // EDITAR FORNECEDOR
    public void editar(int id, String nome, String telefone,
                       String email, String cnpj)
            throws ItemNaoEncontradoException, ValidacaoException {

        Fornecedor f = buscarPorId(id);

        f.setNome(nome);
        f.setTelefone(telefone);
        f.setEmail(email);
        f.setCnpj(cnpj);
    }

    // ATIVAR OU INATIVAR FORNECEDOR
    public void alterarStatus(int id, boolean ativo)
            throws ItemNaoEncontradoException {

        Fornecedor f = buscarPorId(id);
        f.setAtivo(ativo);
    }
}
