
public class Program {
    public static void main(String[] args) {

        System.out.println("VENDE-SE CASA");
        System.out.println("Preço metro quadrado: R$ 1200.00");
        System.out.println("Preço p/ quarto: R$ 500.00 cada");

        Casa casa = new Casa();

        System.out.println("Preço casa com 500 metros quadrados: " + casa.calcularPreco(500));
        System.out.println("Preço casa com 400 metros quadrados e 4 quartos: " + casa.calcularPreco(400, 4));
    }
}
