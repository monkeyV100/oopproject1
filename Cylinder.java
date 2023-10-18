public class Cylinder extends Shape3D {
    private double radius;

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double getHeight() {
        return height; // Implement the getHeight method specific to Cylinder
    }
    
    @Override
public String toString() {
    return "Cylinder - Height: " + height + ", Radius: " + radius + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
}

}
