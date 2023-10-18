public class SquarePrism extends Shape3D {
    private double edgeLength;

    public SquarePrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
    @Override
public double getHeight() {
    return height; // Implement the getHeight method specific to SquarePrism
}


    @Override
public String toString() {
    return "Square Prism - Height: " + height + ", Edge Length: " + edgeLength + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
}

}
