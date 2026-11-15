package menu;

import servico.FinanceiroService;

public class MenuFinanceiro {

    private final FinanceiroService financeiroService;

    public MenuFinanceiro(FinanceiroService financeiroService) {
        this.financeiroService = financeiroService;
    }

    public void executar() {
        throw new UnsupportedOperationException();
    }
}
