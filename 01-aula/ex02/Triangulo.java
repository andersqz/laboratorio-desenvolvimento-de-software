
public class Triangulo extends FormaGeometrica {

    private float base;
    private float altura;

    public Triangulo(float altura, float base) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public float calcularArea() {
        return (base * altura) / 2;
    }
}
