import java.util.Objects;

public class Employee {
    private String fio;
    private int department;
    private double salary;
    private int id;
    private static int idSequence = 0;

    public Employee(String fio, int department, double salary) {
        this.fio = fio;
        this.department = department;
        this.salary = salary;
        this.id = ++idSequence;
    }

    public String getFio() {
        return fio;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department > 0 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Неправильно указан номер отдела. Укажите номер отдела от 1 до 5!");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарпалта не может быть отрицательным числом");
        }

    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fio.equals(employee.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio);
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id +
                ", Ф.И.О. = " + fio +
                ", Отдел = " + department +
                ", Зарплата = " + salary +
                '}';
    }
}
