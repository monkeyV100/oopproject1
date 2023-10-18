public class PentagonalPrism extends Shape3D {
    private double edgeLength;

    public PentagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return 5 * Math.pow(edgeLength, 2) * Math.tan(Math.toRadians(54)) / 4;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
public double getHeight() {
    return height; // Implement the getHeight method specific to PentagonalPrism
}

    @Override
public String toString() {
    return "Pentagonal Prism - Height: " + height + ", Edge Length: " + edgeLength + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
}

}
