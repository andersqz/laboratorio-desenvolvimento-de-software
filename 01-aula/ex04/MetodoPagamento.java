public abstract class MetodoPagamento {
    
    private int id = 0;
    private String nomeMetodo;

    public MetodoPagamento(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
        id++;
    }


    public int processaPagamento(double valor) {

        System.out.println("Processando pagamento em " + nomeMetodo);
        return id;
    }

    public int mostraDetalhesPagamento(double valor) {

        System.out.println("Modalidade: " + nomeMetodo);
        System.out.println("[" + id + "] Pagamento: " + valor);
        return id;
    }




}
