public class Pyramid extends Shape3D {
    private double edgeLength;

    public Pyramid(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * Math.pow(edgeLength, 2) * height;
    }

    @Override
public double getHeight() {
    return height; // Implement the getHeight method specific to Pyramid
}


    @Override
public String toString() {
    return "Pyramid - Height: " + height + ", Edge Length: " + edgeLength + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
}

}
