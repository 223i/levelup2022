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
}
