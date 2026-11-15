package menu;

import servico.FuncionarioService;

public class MenuFuncionarios {

    private final FuncionarioService funcionarioService;

    public MenuFuncionarios(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    public void executar() {
        throw new UnsupportedOperationException();
    }
}
