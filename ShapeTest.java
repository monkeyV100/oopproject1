import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeTest {

    public static void main(String[] args) {
        String fileName = null;
        String sortingAlgorithm = null;
        String sortingCriteria = null; // No default value
    
        for (int i = 0; i < args.length; i++) {
            String arg = args[i].toLowerCase(); // Convert the argument to lowercase for case insensitivity
    
            if (arg.equals("-f") && i + 1 < args.length) {
                fileName = args[i + 1];
                i++; // Skip the next argument
            } else if (arg.equals("-s") && i + 1 < args.length) {
                sortingAlgorithm = args[i + 1].toLowerCase();
                i++; // Skip the next argument
            } else if (arg.equals("-t") && i + 1 < args.length) {
                String criteria = args[i + 1].toLowerCase(); // Convert the criteria to lowercase
                if (!criteria.equals("v") && !criteria.equals("h") && !criteria.equals("a")) {
                    System.out.println("Invalid sorting criteria choice: " + criteria);
                    return;
                }
                sortingCriteria = criteria;
                i++; // Skip the next argument
            }
        }

        if (fileName == null || sortingAlgorithm == null || sortingCriteria == null) {
            System.out.println("Usage: java ShapeTest -f <filename> -s <sorting_algorithm> -t <sorting_criteria>");
            System.out.println("Sorting Algorithms: b (bubble), s (selection), i (insertion), m (merge), q (quick), h (heap)");
            System.out.println("Sorting Criteria: v (volume), h (height), a (base area)");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<Shape3D> shapesList = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length < 3) {
                    System.out.println("Invalid line format: " + line);
                    continue; // Skip invalid lines
                }

                for (int i = 0; i < parts.length; i += 3) {
                    String shapeType = parts[i];
                    double height = Double.parseDouble(parts[i + 1]);
                    double dimension = Double.parseDouble(parts[i + 2]);

                    switch (shapeType) {
                        case "Cylinder":
                            shapesList.add(new Cylinder(height, dimension));
                            break;
                        case "Cone":
                            shapesList.add(new Cone(height, dimension));
                            break;
                        case "Pyramid":
                            shapesList.add(new Pyramid(height, dimension));
                            break;
                        case "SquarePrism":
                            shapesList.add(new SquarePrism(height, dimension));
                            break;
                        case "TriangularPrism":
                            shapesList.add(new TriangularPrism(height, dimension));
                            break;
                        case "PentagonalPrism":
                            shapesList.add(new PentagonalPrism(height, dimension));
                            break;
                        case "OctagonalPrism":
                            shapesList.add(new OctagonalPrism(height, dimension));
                            break;
                        default:
                            System.out.println("Invalid shape type: " + shapeType);
                    }
                }
            }

            Shape3D[] shapes = shapesList.toArray(new Shape3D[0]);

            if (sortingAlgorithm.equals("b")) {
                // Bubble Sort
                bubbleSort(shapes, sortingCriteria);
            } else if (sortingAlgorithm.equals("s")) {
                // Selection Sort
                selectionSort(shapes, sortingCriteria);
            } else if (sortingAlgorithm.equals("i")) {
                // Insertion Sort
                insertionSort(shapes, sortingCriteria);
            } else if (sortingAlgorithm.equals("m")) {
                // Merge Sort
                mergeSort(shapes, sortingCriteria);
            } else if (sortingAlgorithm.equals("q")) {
                // Quick Sort
                quickSort(shapes, sortingCriteria);
            } else if (sortingAlgorithm.equals("h")) {
                // Your choice of sorting algorithm (replace with actual algorithm)
                heapSort(shapes, sortingCriteria);
            } else {
                System.out.println("Invalid sorting algorithm choice: " + sortingAlgorithm);
                return;
            }
            

            // Printing shapes after sorting
            for (Shape3D shape : shapes) {
                System.out.println(shape); // This requires a toString method in your Shape3D subclasses
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file: " + e.getMessage());
        }
    }

    // Bubble Sort implementation for an array of Shape3D objects
    public static void bubbleSort(Shape3D[] arr, String sortingCriteria) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (compareShapes(arr[i], arr[i + 1], sortingCriteria) > 0) {
                    // Swap arr[i] and arr[i+1]
                    Shape3D temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }


    public static void selectionSort(Shape3D[] arr, String sortingCriteria) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (compareShapes(arr[j], arr[minIdx], sortingCriteria) < 0) {
                minIdx = j;
            }
        }
        Shape3D temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}

public static void insertionSort(Shape3D[] arr, String sortingCriteria) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        Shape3D key = arr[i];
        int j = i - 1;
        while (j >= 0 && compareShapes(arr[j], key, sortingCriteria) > 0) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

public static void mergeSort(Shape3D[] arr, String sortingCriteria) {
    int n = arr.length;
    if (n > 1) {
        int mid = n / 2;
        Shape3D[] left = Arrays.copyOfRange(arr, 0, mid);
        Shape3D[] right = Arrays.copyOfRange(arr, mid, n);

        mergeSort(left, sortingCriteria);
        mergeSort(right, sortingCriteria);

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (compareShapes(left[i], right[j], sortingCriteria) < 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

public static void quickSort(Shape3D[] arr, String sortingCriteria) {
    quickSort(arr, 0, arr.length - 1, sortingCriteria);
}

private static void quickSort(Shape3D[] arr, int low, int high, String sortingCriteria) {
    if (low < high) {
        int pivotIndex = partition(arr, low, high, sortingCriteria);
        quickSort(arr, low, pivotIndex - 1, sortingCriteria);
        quickSort(arr, pivotIndex + 1, high, sortingCriteria);
    }
}

private static int partition(Shape3D[] arr, int low, int high, String sortingCriteria) {
    Shape3D pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (compareShapes(arr[j], pivot, sortingCriteria) <= 0) {
            i++;
            Shape3D temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    Shape3D temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}

public static void heapSort(Shape3D[] arr, String sortingCriteria) {
    int n = arr.length;

    // Build max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i, sortingCriteria);
    }

    // Extract elements from the heap one by one
    for (int i = n - 1; i >= 0; i--) {
        Shape3D temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        // Call max heapify on the reduced heap
        heapify(arr, i, 0, sortingCriteria);
    }
}

private static void heapify(Shape3D[] arr, int n, int i, String sortingCriteria) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && compareShapes(arr[left], arr[largest], sortingCriteria) > 0) {
        largest = left;
    }

    if (right < n && compareShapes(arr[right], arr[largest], sortingCriteria) > 0) {
        largest = right;
    }

    if (largest != i) {
        Shape3D swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;

        heapify(arr, n, largest, sortingCriteria);
    }
}

public static int compareShapes(Shape3D shape1, Shape3D shape2, String sortingCriteria) {
    // Implement comparisons based on sortingCriteria (volume, height, or base area)
    // Return a positive value if shape1 > shape2, negative if shape1 < shape2, and 0 if equal
    if (sortingCriteria.equals("v")) {
        return Double.compare(shape1.getVolume(), shape2.getVolume());
    } else if (sortingCriteria.equals("h")) {
        return Double.compare(shape1.getHeight(), shape2.getHeight());
    } else if (sortingCriteria.equals("a")) {
        // Implement comparison based on base area (if applicable to your shapes)
        return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
    }
    return 0; // Default to volume comparison
}

}
    

