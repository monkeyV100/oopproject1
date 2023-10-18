import java.util.Comparator;

public class ShapeSorter {

    public static void sort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(shapes[j], shapes[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            Shape3D temp = shapes[maxIdx];
            shapes[maxIdx] = shapes[i];
            shapes[i] = temp;
        }
    }
}
