public class MercadoZoshia {
    public static void main(String[] args){
        //Produto p1 = new Produto("Leite", 7.5, 3);
        //Produto p1 = new Arroz(1);
        //Produto p2 = new Leite(3,11,11,2026);

        OperadorCaixa compra = new Compra();
        compra.adicionaProduto( new Macarrao(3) );
        compra.adicionaProduto( new Arroz(5) );
        compra.adicionaProduto( new Maca(1, 20, 9, 2026) );
        compra.adicionaProduto( new Leite(2, 10, 9, 2026) );
        compra.finalizaCompra();
    }
}