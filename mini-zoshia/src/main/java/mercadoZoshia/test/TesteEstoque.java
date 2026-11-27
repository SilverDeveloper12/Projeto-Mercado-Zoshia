package mercadoZoshia.test;

import mercadoZoshia.service.EstoqueService;
import mercadoZoshia.service.ProdutoService;

public class TesteEstoque {

    public static void main(String[] args) throws Exception {
        ProdutoService produtoService = new ProdutoService();
        EstoqueService estoque = new EstoqueService(produtoService);

        TesteProduto arroz = new TesteProduto("001", "Arroz", 5);
        produtoService.adicionar(arroz);

        estoque.registrarEntrada(arroz, 10, "Compra", null, null);
        estoque.registrarSaida(arroz, 12, mercadoZoshia.model.TipoMovimento.VENDA, "Venda", null);

        System.out.println("Quantidade: " + arroz.getQuantidade());
        System.out.println("Estoque baixo: " + estoque.listarEstoqueBaixo(5).size());
        System.out.println("Histórico: " + estoque.historicoDoProduto("001").size());
    }
}