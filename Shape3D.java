import java.util.Comparator;

public abstract class Shape3D implements Comparable<Shape3D> {
    protected double height;

    public Shape3D(double height) {
        this.height = height;
    }

    public abstract double getBaseArea();
    public abstract double getVolume();

    // Add an abstract getHeight method
    public abstract double getHeight();

    @Override
    public int compareTo(Shape3D other) {
        return Double.compare(this.height, other.height);
    }

    @Override
    public String toString() {
        return "Height: " + getHeight() + ", Base Area: " + getBaseArea() + ", Volume: " + getVolume();
    }

    public static class ShapeComparator implements Comparator<Shape3D> {
        private final String compareType;

        public ShapeComparator(String compareType) {
            if (!compareType.equals("h") && !compareType.equals("v") && !compareType.equals("a")) {
                throw new IllegalArgumentException("Invalid compare type. Allowed values are 'h', 'v', and 'a'.");
            }
            this.compareType = compareType;
        }

        @Override
        public int compare(Shape3D shape1, Shape3D shape2) {
            switch (compareType) {
                case "v":
                    return Double.compare(shape1.getVolume(), shape2.getVolume());
                case "a":
                    return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
                default:
                    return Double.compare(shape1.getHeight(), shape2.getHeight());
            }
        }
    }
}
