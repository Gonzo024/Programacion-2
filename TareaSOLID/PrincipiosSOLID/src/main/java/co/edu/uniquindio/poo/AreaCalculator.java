package co.edu.uniquindio.poo;

public class AreaCalculator {
    private Shape[] shapes;

    public AreaCalculator(Shape[] shapes) {
        this.shapes = shapes;
    }



    public double sum(Shape[] figuras) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}




