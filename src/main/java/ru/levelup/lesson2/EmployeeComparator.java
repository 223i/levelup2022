package ru.levelup.lesson2;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Integer.compare(employee2.workAge(), employee1.workAge());
    }
}
