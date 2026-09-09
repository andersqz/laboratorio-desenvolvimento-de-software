public class Program {
    public static void main(String[] args) {

        CartaoCreditoPagamento cartao = new CartaoCreditoPagamento ("Cartao de credito", "384834832");
        PaypalPagamento paypal = new PaypalPagamento("Paypal");
        PixPagamento pix = new PixPagamento("Pix");

        System.out.println("CARTAO DE CREDITO");
        cartao.processaPagamento(2999);
        cartao.mostraDetalhesPagamento(2999);

        System.out.println("PAYPAL");
        paypal.processaPagamento(1999);
        paypal.mostraDetalhesPagamento(1999);

        System.out.println("PIX");
        pix.processaPagamento(1999);
        pix.mostraDetalhesPagamento(1999);
    }
}
