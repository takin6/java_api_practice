import java.lang.reflect.Array;
import java.util.ArrayList;

public class TotalNumbers {
    public static void main(String[] args) {
        Number[] numbers = {1, 2.3, 3, 4.1};
        ArrayList<Number> numberList = new ArrayList<>();

        for (Number element: numbers) {
            numberList.add(element);
        }

        System.out.printf("numberlist contains: %s%n", numberList);
        System.out.printf("Total of the element sin numberList: %.1f%n", sum(numberList));

        Number[] numbers2 = {1, 2, 3, 4};
        ArrayList<Number> numberList2 = new ArrayList<>();

        for (Number element: numbers2) {
            numberList2.add(element);
        }

        System.out.printf("numberlist contains: %s%n", numberList2);
        System.out.printf("Total of the element sin numberList: %.1f%n", sum(numberList2));
    }

    public static double sum(ArrayList<? extends Number> list) {
        double total = 0;

        for (Number element: list) {
            total += element.doubleValue();
        }

        return total;
    }
}
