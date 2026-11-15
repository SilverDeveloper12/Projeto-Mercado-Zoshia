package teste;

import excecao.EstoqueInsuficienteException;
import excecao.ValidacaoException;
import modelo.Funcionario;
import modelo.Produto;
import modelo.ProdutoNaoPerecivel;
import modelo.ProdutoPerecivel;

public class TesteBase {

    public static void main(String[] args) {
        try {
            Produto arroz = new ProdutoNaoPerecivel("P001", "Arroz 5kg", "Alimentos", 18.0, 25.9, 10);
            System.out.println("Produto válido criado: " + arroz);
            arroz.adicionarEstoque(5);
            System.out.println("Depois de adicionar 5: " + arroz.getQuantidade());
            arroz.removerEstoque(3);
            System.out.println("Depois de remover 3: " + arroz.getQuantidade());
            arroz.removerEstoque(100);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro esperado de estoque: " + e.getMessage());
        } catch (ValidacaoException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }

        try {
            new ProdutoNaoPerecivel("", "Feijão", "Alimentos", 5.0, 8.0, 10);
        } catch (ValidacaoException e) {
            System.out.println("Erro esperado de validação: " + e.getMessage());
        }

        try {
            new ProdutoNaoPerecivel("P002", "Feijão", "Alimentos", -5.0, 8.0, 10);
        } catch (ValidacaoException e) {
            System.out.println("Erro esperado de validação: " + e.getMessage());
        }

        try {
            Produto iogurte = new ProdutoPerecivel("P003", "Iogurte", "Laticínios", 2.0, 4.5, 20, 15, 12, 2026);
            System.out.println("Iogurte válido em 01/12/2026: " + iogurte.estaValido(1, 12, 2026));
            System.out.println("Iogurte válido em 16/12/2026: " + iogurte.estaValido(16, 12, 2026));
        } catch (ValidacaoException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }

        try {
            Funcionario funcionario = new Funcionario(1, "Maria", "11999990000", "maria@minizoshia.com", "Caixa");
            System.out.println(funcionario);
            new Funcionario(2, " ", "11999990000", "x@x.com", "Caixa");
        } catch (ValidacaoException e) {
            System.out.println("Erro esperado de validação: " + e.getMessage());
        }
    }
}
