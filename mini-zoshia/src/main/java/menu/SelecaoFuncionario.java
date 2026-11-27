package menu;

import excecao.ItemNaoEncontradoException;
import excecao.ValidacaoException;
import modelo.Funcionario;
import servico.FuncionarioService;
import util.Entrada;

// Usado por MenuVendas e MenuEstoque para saber "quem está operando?".
// Uso: Funcionario f = SelecaoFuncionario.escolherResponsavel(funcionarioService);
public final class SelecaoFuncionario {

    private SelecaoFuncionario() {
    }

    public static Funcionario escolherResponsavel(FuncionarioService service)
            throws ItemNaoEncontradoException, ValidacaoException {

        int id = Entrada.lerInt("ID do funcionário responsável: ");
        return service.exigirAtivo(id);
    }
}
