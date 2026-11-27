package mercadoZoshia.test;

import mercadoZoshia.exceptions.*;
import mercadoZoshia.model.Estoque;
import mercadoZoshia.model.Produto;
import mercadoZoshia.model.ProdutoNaoPerecivel;
import mercadoZoshia.model.ProdutoPerecivel;

public class TesteBase {

    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        // 1. Produto não perecível + estoque
        System.out.println("--- Teste 1: estoque ---");
        try {
            Produto arroz = new ProdutoNaoPerecivel("P001", "Arroz 5kg", 25.90, "Alimentos");
            System.out.println("Produto criado: " + arroz);

            estoque.adicionar(arroz, 10);
            System.out.println("Depois de adicionar 10: " + estoque.consultarQuantidade(arroz));

            estoque.remover(arroz, 3);
            System.out.println("Depois de remover 3: " + estoque.consultarQuantidade(arroz));

            estoque.remover(arroz, 100); // deve dar erro
            System.out.println("ERRO: não deveria chegar aqui!");
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro esperado de estoque: " + e.getMessage());
        }

        // 2. Preço inválido (negativo)
        System.out.println("\n--- Teste 2: preço negativo ---");
        try {
            new ProdutoNaoPerecivel("P002", "Feijão", -8.0, "Alimentos");
            System.out.println("ERRO: não deveria chegar aqui!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado de validação: " + e.getMessage());
        }

        // 3. Preço inválido (zero)
        System.out.println("\n--- Teste 3: preço zero ---");
        try {
            new ProdutoNaoPerecivel("P003", "Macarrão", 0, "Alimentos");
            System.out.println("ERRO: não deveria chegar aqui!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado de validação: " + e.getMessage());
        }

        // 4. Polimorfismo: desconto no perecível perto de vencer
        System.out.println("\n--- Teste 4: polimorfismo no preço ---");
        Produto iogurteFresco = new ProdutoPerecivel("P004", "Iogurte", 4.50, 15);
        Produto iogurteVencendo = new ProdutoPerecivel("P005", "Iogurte", 4.50, 2);
        System.out.println("Vence em 15 dias (sem desconto): " + iogurteFresco);
        System.out.println("Vence em 2 dias (30% off):       " + iogurteVencendo);

        // 5. Remover produto que nunca entrou no estoque
        System.out.println("\n--- Teste 5: produto fora do estoque ---");
        try {
            Produto leite = new ProdutoPerecivel("P006", "Leite", 6.50, 10);
            estoque.remover(leite, 1);
            System.out.println("ERRO: não deveria chegar aqui!");
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro esperado de estoque: " + e.getMessage());
        }

        // 6. Busca por código
        System.out.println("\n--- Teste 6: busca por código ---");
        estoque.adicionar(iogurteVencendo, 20);
        System.out.println("Buscar P001: " + estoque.buscarPorCodigo("P001"));
        System.out.println("Buscar P999: " + estoque.buscarPorCodigo("P999"));

        // 7. Relatório
        System.out.println("\n--- Teste 7: relatório ---");
        System.out.println(estoque.gerarRelatorio());
    }
}