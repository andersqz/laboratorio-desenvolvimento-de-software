public class Program {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        double n1 = 20;
        double n2 = 30;

        System.out.println("----------------------------------------------------------------");
        System.out.println("Soma entre: " + n1 + " e " + n2 + ": " + calc.somar(n1, n2));
        System.out.println("Subtração entre: " + n1 + " e " + n2 + ": " + calc.subtrair(n1, n2));
        System.out.println("Multiplicação entre: " + n1 + " e " + n2 + ": " + calc.multiplicar(n1, n2));
        System.out.println("Divisao entre: " + n1 + " e " + n2 + ": " + calc.dividir(n1, n2));
        System.out.println("Raiz quadrada da soma entre: " + n1 + " e " + n2 + ": " + calc.raizquadrada(n1, n2));
        System.out.println("valor de " + n1 + " na potencia " + n2 + ": " + calc.elevarPotencia(n1, n2));
        System.out.println("Log10 de: " + n1 + ": " + calc.logaritmo10(n1));
        System.out.println("----------------------------------------------------------------");
    }
}
