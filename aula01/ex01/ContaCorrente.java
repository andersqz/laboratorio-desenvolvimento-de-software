public class ContaCorrente {
    private float saldo;

    public ContaCorrente() {}

    public float getSaldo() {
        return saldo;
    }

    public void definirSaldoInicial(float value) {
        saldo = value;
    }

    public void depositar(float value) {
        saldo += value;
    }

    public boolean sacar(float value) {

        if (saldo < value) 
            return false;
    
        saldo -= value;
        return true;
    }

}
