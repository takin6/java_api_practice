import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matther", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing"),
        };

        // get List view of the Employees
        List<Employee> list = Arrays.asList(employees);

        // display all Employees
        System.out.println("Complete Employee list: ");
        list.stream().forEach(System.out::println);
        System.out.println();

        // predicate that returns true for salaries in the range $4000-$6000
        Predicate<Employee> fourToSixThousan = e -> (e.getSalary()>=4000 && e.getSalary()<=6000);

        // Display Employees with salaries in the range $4000-$6000
        // sorted into ascending order by salary
        System.out.println("Employees earning $4000 - $6000 per month sorted by salary:%n");
        list.stream()
                .filter(fourToSixThousan)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
        System.out.println();

        // Display first Employee with salary in the range $4000-$6000
        System.out.println("First employee who earns $4000 - $6000");
        Employee e = list.stream()
                        .filter(fourToSixThousan)
                        .findFirst()
                        .get();
        System.out.println(e);
        System.out.println();

        // Functions for getting first and last names from an Employee
        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        // Comparator for comparing Employees by last name and then first name
        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

        // sort employees by last name then first name
        System.out.println("Employees in ascending order by last name then first");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Employees in descending order by last name then first");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);
        System.out.println();

        // Display unique employees last names sorted
        System.out.println("Unique employee last names: ");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // display only first and last names
        System.out.println("displays only first and last names: ");
        list.stream()
                .sorted(lastThenFirst)
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println();

        // group Employees by department
        System.out.println("Employees by department: ");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    System.out.println(department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("    %s%n", employee));
                }
        );
        System.out.println();

        // count number of Employees in each department
        System.out.println("Count of Employees by department: ");
        // treemap: map factory, maintains keys in the sorted order
        // Collectors.counting: downstream collector
        Map<String, Long> employeeCountByDepartment =
                list.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf("%s has %d employee(s)%n", department, count));


        // sum of Employee salaries with DoubleStream sum method
        System.out.printf(
                "%nSum fo Employees' salaries (via sum method): %.2f%n",
                list.stream().mapToDouble(Employee::getSalary).sum());

        // calculate sum of Employee salaries with Stream reduce method
        System.out.printf(
                "%nSum fo Employees' salaries (via reduce method): %.2f%n",
                list.stream().mapToDouble(Employee::getSalary).reduce(0, (value1, value2) -> value1+value2));

        // average of Employee salaries with DoubleStream average method
        System.out.printf(
                "%nAverage fo Employees' salaries): %.2f%n",
                list.stream().mapToDouble(Employee::getSalary).average().getAsDouble());

    }
}
