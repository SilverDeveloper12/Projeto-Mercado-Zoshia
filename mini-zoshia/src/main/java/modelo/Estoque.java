package modelo;

import excecao.EstoqueInsuficienteException;
import contratos.Estocavel;
import contratos.Relatorio;

import java.util.ArrayList;

public class Estoque implements Estocavel, Relatorio {
    private ArrayList<ItemEstoque> itens = new ArrayList<>();

    private ItemEstoque buscarItem(String codigo) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }

    public Produto buscarPorCodigo(String codigo) {
        ItemEstoque item = buscarItem(codigo);
        if (item == null) {
            return null;
        }
        return item.getProduto();
    }

    @Override
    public void adicionar(Produto produto, int quantidade) {
        ItemEstoque item = buscarItem(produto.getCodigo());
        if (item == null) {
            itens.add(new ItemEstoque(produto, quantidade));
        } else {
            item.setQuantidade(item.getQuantidade() + quantidade);
        }
    }

    @Override
    public void remover(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        ItemEstoque item = buscarItem(produto.getCodigo());
        if (item == null || item.getQuantidade() < quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente de " + produto.getNome());
        }
        item.setQuantidade(item.getQuantidade() - quantidade);
    }

    @Override
    public int consultarQuantidade(Produto produto) {
        ItemEstoque item = buscarItem(produto.getCodigo());
        if (item == null) {
            return 0;
        }
        return item.getQuantidade();
    }

    @Override
    public String gerarRelatorio() {
        if (itens.isEmpty()) {
            return "Estoque vazio.";
        }
        String texto = "=== ESTOQUE ===\n";
        for (ItemEstoque item : itens) {
            texto += item.getProduto() + " | Qtd: " + item.getQuantidade() + "\n";
        }
        return texto;
    }
}