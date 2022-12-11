package ru.levelup.lesson2;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<Employee> employees = createListOfEmployees();
        System.out.println("---------------All employees------------------");
        printAllEmployees(employees);
        System.out.println("-------Employees with defined work age -------");
        printEmployeesWithDefinedWorkAge(employees, 1);
        List<Employee> reducedListEmployees = removeEveryEvenEmployee(employees);
        System.out.println("--------Reduced list of employees(only uneven from top)---------");
        printAllEmployees(reducedListEmployees);
        List<Employee> reducedListEmployeesReversed = removeEveryEvenEmployeeReversed(employees);
        System.out.println("--------Reduced list of employees(only uneven reversed)---------");
        printAllEmployees(reducedListEmployeesReversed);
        System.out.println("--------Task 2: Set<Employees> with ranged work age---------");
        Set<Employee> setOfEmployees = getSetOfEmployees(employees);
        printAllEmployees(setOfEmployees);
        System.out.println("--------Task 3: union and intersect methods for Sets---------");
        Set<Employee> someSet = getSetOfEmployees(new ArrayList<>(reducedListEmployees));
        System.out.println("--------intersection---------");
        printAllEmployees(intersect(setOfEmployees, someSet));
        System.out.println("--------joined Set---------");
        printAllEmployees(union(setOfEmployees, someSet));
    }

    public static List<Employee> createListOfEmployees() {
        List<Employee> employees = new ArrayList<>();
        Random randomGenerator = new Random();
        String[] names = {"Alexey Antonovic Petrov", "Olga Sergeevna Sidorova", "Anatoliy Viktorovich Shatz",
                "Alexander Semenovich Vasiliev", "Irina Igorevna Korobeinikova", "Oleg Alexandrovich  Popov",
                "Evgeniya Ivanovna Medvedieva", "Semen Petrovich Kraus", "A.A. Vysotskiy", "I.I Musorgskiy", "D.S. Richmann",
                "L.O. Severetskaya", "L. A. Bloh", "V. F. Fedorov", "E.A. Kolesnikova", "R.V. Lisova"};

        for (String name : names) {
            employees.add(new Employee(name, randomGenerator.nextInt(0, 5)));
        }
        return employees;
    }

    public static void printAllEmployees(Collection<Employee> employees) {
        employees.forEach(employee -> System.out.println(
                employee.getInitials() + ": " + employee.getWorkAge()));
    }

    public static void printEmployeesWithDefinedWorkAge(Collection<Employee> employees, int workAge) {
        List<Employee> employeesFilteredByAge = employees.stream()
                .filter(employe -> workAge == employe.getWorkAge())
                .toList();

        printAllEmployees(employeesFilteredByAge);
    }

    public static List<Employee> removeEveryEvenEmployee(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> (employees.indexOf(employee) + 1) % 2 != 0)
                .toList();
    }

    public static List<Employee> removeEveryEvenEmployeeReversed(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream();
                }))
                .filter(employee -> (employees.indexOf(employee) + 1) % 2 != 0)
                .toList();
    }

    public static Set<Employee> getSetOfEmployees(List<Employee> listOfEmployees) {
        TreeSet<Employee> rangedSetOfEmployees = new TreeSet<>(new EmployeeTreeSetComparator());
        listOfEmployees.sort(new EmployeeComparator());
        rangedSetOfEmployees.addAll(listOfEmployees);
        return rangedSetOfEmployees;
    }

    public static Set<Employee> union(Set<Employee> set1, Set<Employee> set2) {
        set1.addAll(set2);
        return set1;
    }

    public static Set<Employee> intersect(Set<Employee> set1, Set<Employee> set2) {
        return set1.stream()
                .filter(set2::contains)
                .collect(Collectors.toSet());
    }
}
