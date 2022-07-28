import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.put(employee.getFio(), employee);
    }

    public void printEmployee() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void removeEmployee(String fio) {
        employees.remove(fio);
    }

    public void setSalary(String fio, double salary) {
        for (Employee employee : employees.values()) {
            if (employee.getFio().equals(fio)) {
                employee.setSalary(salary);
            }
        }
    }


    public void setDepartment(String fio, int department) {
        for (Employee employee : employees.values()) {
            if (employee.getFio().equals(fio)) {
                employee.setDepartment(department);
            }
        }
    }

    public void printDepartmentEmployee() {
        for (int i = 1; i < 6; i++) {
            System.out.println("Сотрудники отдела " + i + ":");
            for (Employee employee : employees.values()) {
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getFio());
                }
            }
            System.out.println();
        }
    }


    public double calculateAmountEmployee() {
        double amount = 0;
        for (Employee employee : employees.values()) {
            amount += employee.getSalary();
        }
        return amount;
    }

    public double calculateAmountEmployeeDepartment(Employee[] employees) {
        double amount = 0;
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }

    public void printEmployeeMinSalary() {
        double min = Double.MAX_VALUE;
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + min);
    }

    public void printEmployeeMinSalaryDepartment(Employee[] employees) {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minEmployee.getSalary()) {
                minEmployee = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + minEmployee);
    }

    public void printEmployeeMaxSalary() {
        double max = Double.MIN_VALUE;
        for (Employee employee : employees.values()) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + max);
    }

    public void printEmployeeMaxSalaryDepartment(Employee[] employees) {
        Employee maxEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxEmployee.getSalary()) {
                maxEmployee = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + maxEmployee);
    }

    public double calculateAverageSalary() {
        double amount = calculateAmountEmployee();
        return amount / employees.size();
    }

    public double calculateAverageSalaryDepartment(Employee[] employees) {
        double amount = calculateAmountEmployeeDepartment(employees);
        return amount / employees.length;
    }


    public void printEmployeeFio() {
        for (Employee employee : employees.values()) {
            System.out.println(employee.getFio());
        }
    }

    public void printIdEmployeeFioSalary(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("id = " + employee.getId() + ", Ф.И.О. = " + employee.getFio() + ", Зарпалата = " + employee.getSalary());
        }
    }

    public void indexingSalary(double percent) {
        for (Employee employee : employees.values()) {
            double indexing = employee.getSalary() + employee.getSalary() * (percent / 100);
            employee.setSalary(indexing);
        }
    }

    public Employee[] searchByDepartment(int numberDepartment) {
        if (numberDepartment < 0 || numberDepartment > 5) {
            throw new IllegalArgumentException("Неправильно указан номер отдела. Укажите номер отдела от 1 до 5!");
        }
        int size = 0;
        int size2 = 0;
        for (Employee value : employees.values()) {
            if (value.getDepartment() == numberDepartment) {
                size++;
            }
        }
        Employee[] employeesDepartment = new Employee[size];
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == numberDepartment) {
                employeesDepartment[size2++] = employee;
            }
        }
        return employeesDepartment;
    }

    public Employee[] compareLessSalary(int number) {
        int size = 0;
        int size2 = 0;
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < number) {
                size++;
            }
        }
        Employee[] lessSalary = new Employee[size];
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < number) {
                lessSalary[size2++] = employee;
            }
        }
        return lessSalary;
    }

    public Employee[] compareMoreSalary(int number) {
        int size = 0;
        int size2 = 0;
        for (Employee employee : employees.values()) {
            if (employee.getSalary() >= number) {
                size++;
            }
        }
        Employee[] moreSalary = new Employee[size];
        for (Employee employee : employees.values()) {
            if (employee.getSalary() >= number) {
                moreSalary[size2++] = employee;
            }
        }
        return moreSalary;
    }

    public void indexingSalaryDepartment(int department, double percent) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                double indexing = employee.getSalary() + employee.getSalary() * (percent / 100);
                employee.setSalary(indexing);
            }
        }
    }

    public void printDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.println("id = " + employee.getId() + ", Ф.И.О. = " + employee.getFio() + ", Зарпалата = " + employee.getSalary());
            }
        }
    }
}
