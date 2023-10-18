public class TriangularPrism extends Shape3D {
    private double edgeLength;

    public TriangularPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return Math.pow(edgeLength, 2) * Math.sqrt(3) / 4;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
    @Override
public double getHeight() {
    return height; // Implement the getHeight method specific to TriangularPrism
}


    @Override
public String toString() {
    return "Triangular Prism - Height: " + height + ", Edge Length: " + edgeLength + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
}

}
