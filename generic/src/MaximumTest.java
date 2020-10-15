public class MaximumTest {

    public static void main(String[] args) {
        System.out.printf("Maximum of %d, %d and %d is %d%n%n", 3, 4, 5, maximum(3,4,5));
        System.out.printf("Maximum of %.1f, %.1f and %.1f is %.1f%n%n", 6.6, 7.7, 8.8, maximum(6.6, 7.7, 8.8));
        System.out.printf("Maximum of %s, %s and %s is %s%n%n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
    }

    // extends is used to both interface and extends
    // <型パラメータ extends <データ型>>
    // is_a relationship
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }
}
