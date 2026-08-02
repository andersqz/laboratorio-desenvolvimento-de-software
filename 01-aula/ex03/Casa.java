
public class Casa {
    private int metrosQuadrados;
    private int numeroQuartos;

    public Casa() {}

/*     public Casa(int metros, int quartos) {
        metrosQuadrados = metros;
        numeroQuartos = quartos;
    } */

    public int getMetrosQuadrados() {
        return metrosQuadrados;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public float calcularPreco(int tamanho) {
        return tamanho * 1200;
    }

    public float calcularPreco(int tamanho, int quartos) {
        return (tamanho * 1200) + (500 * quartos);
    }

}
