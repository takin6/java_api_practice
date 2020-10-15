public class GenericMethodTest {
    public static void main(String[] args) {
        // must not be primitive type
        Integer[] integerArray = {1,2,3,4,5,6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E','L', 'L', 'O'};

        System.out.printf("Array IntegerArray contains:%n");
        printArray(integerArray);
        System.out.printf("%nArray doubleArray contains:%n");
        printArray(doubleArray);
        System.out.printf("%nArray characterArray contains:%n");
        printArray(characterArray);
    }

    // Type parameter section before the return type of the method declaration
    // T: types of element
    // E: concept of an element in collection,
    public static <T> void printArray(T[] inputArray) {
        for (T element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

// =>
//    public static void printArray(Object[] inputArray) {
//        for (Object element: inputArray) {
//            System.out.printf("%s ", element);
//        }
//        System.out.println();
//    }


}
