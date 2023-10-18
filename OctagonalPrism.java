public class OctagonalPrism extends Shape3D {
    private double edgeLength;

    public OctagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public double getHeight() {
        return height; // Implement the getHeight method specific to OctagonalPrism
    }
    
    @Override
public String toString() {
    return "Octagonal Prism - Height: " + height + ", Edge Length: " + edgeLength + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
}

}
