package ru.levelup.lesson2;

import java.util.Comparator;
import java.util.Objects;

public class EmployeeTreeSetComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        if (Objects.equals(employee1.getInitials(), employee2.getInitials())){
            return 0;
        } else{
            return 1;
        }
    }
}
