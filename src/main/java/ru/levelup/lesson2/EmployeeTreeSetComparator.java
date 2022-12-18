package ru.levelup.lesson2;

import java.util.Comparator;
import java.util.Objects;

public class EmployeeTreeSetComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        if (Objects.equals(employee1.initials(), employee2.initials())) {
            return 0;
        } else {
            if (employee2.workAge() >= employee1.workAge()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
