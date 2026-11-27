package teste;

import excecao.ValidacaoException;
import modelo.Arroz;
import modelo.Leite;
import modelo.Maca;
import modelo.Macarrao;
import modelo.Produto;

public class TesteProdutos {

    public static void main(String[] args) {
        try {
            Produto[] produtos = {
                new Macarrao(3),
                new Arroz(5),
                new Maca(1, 20, 9, 2026),
                new Leite(2, 10, 9, 2026)
            };
            System.out.println("------");
            double total = 0.0;
            for (Produto produto : produtos) {
                if (produto.estaValido(11, 9, 2026)) {
                    total += produto.getPrecoVenda() * produto.getQuantidade();
                    produto.mostraDescricao();
                    System.out.println(produto);
                } else {
                    System.out.println(produto.getNome() + " estragado.");
                }
            }
            System.out.println("Total R$" + total);
        } catch (ValidacaoException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }
    }
}
