package Chapter21_Factory_Pattern;

public class ShapeFactoryImplementation implements ShapeFactory {
    @Override
    public Shape makeCircle() {
        return new Cicle();
    }

    @Override
    public Shape makeSquare() {
        return new Square();
    }
}
