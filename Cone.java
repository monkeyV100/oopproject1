public class Cone extends Shape3D {
    private double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double getHeight() {
        return height; // Implement the getHeight method specific to Cone
    }
@Override
    public String toString() {
        return "Cone - Height: " + height + ", Radius: " + radius + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
    }
}