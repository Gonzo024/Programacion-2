package co.edu.uniquindio.poo;

public class Main {
    public static void main(String[] args) {
        Shape[] figuras = {
                new Circle(2),
                new Rectangle(4, 6),
                new Trinagle(4, 6),
                new Cone(15, 6),
        };

        AreaCalculator areaCalculator = new AreaCalculator(figuras);

        double total = areaCalculator.sum(figuras);

        System.out.println("Suma total de áreas: " + total);
    }
}
