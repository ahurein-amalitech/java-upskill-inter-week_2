import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public class ShapeFactory {
    public IShape createShape(ShapeType shapeType){
        if (shapeType == null) {
            throw new InvalidParameterException();
        }
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            default:
               throw new NoSuchElementException();
        }
    }
}
