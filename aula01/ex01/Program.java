public class Program {
    public static void main(String[] args) {

        ContaCorrente conta = new ContaCorrente();

        conta.definirSaldoInicial(1000);
        System.out.println("Saldo definido em: R$" + conta.getSaldo());

        conta.sacar(conta.getSaldo() - 500);
        System.out.println("Saque de R$ 500. Saldo: R$ " + conta.getSaldo());

        conta.depositar(50);
        System.out.println("Deposito de R$ 50. Saldo: R$ " + conta.getSaldo());

        boolean retorno = conta.sacar(600);
        System.out.println("Saque de R$ 600. Saldo: R$ " + conta.getSaldo());
        if (retorno == false) {System.out.println("Saque de R$ 600 invalido!");}

    }
}
