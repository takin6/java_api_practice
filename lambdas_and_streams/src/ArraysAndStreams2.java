import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String[] strings = { "Red", "orange", "yellow", "green", "Blue", "indigo", "Violet" };

        // diaplays original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // Strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList()) );

        // Strings greater than "m" (case insensitive) sorted ascending
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("m")>0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // Strings greater than "m" (case insensitive) sorted descending
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("m")>0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));
    }
}
