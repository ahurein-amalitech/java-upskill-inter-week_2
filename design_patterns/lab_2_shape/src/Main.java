public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        IShape circle = shapeFactory.createShape(ShapeType.CIRCLE);
        circle.draw();

        IShape square = shapeFactory.createShape(ShapeType.SQUARE);
        square.draw();
    }
}
