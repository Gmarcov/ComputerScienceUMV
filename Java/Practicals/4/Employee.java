
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;


public class Employee implements Comparable<Employee>{
    private String code;
    private double salary;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Constructors
    public Employee(){
        code = "XXX";
        salary = 10_000;
    }

    public Employee(String code){
        this.code = code;
        this.salary = 10_000;
    }

    public Employee(String code, double salary){
        this.code = code;
        this.salary = salary;
    }

    //Interface Methods
    @Override
    public int compareTo(Employee employee) {
        if (employee == null) return 1;
        return Double.compare(this.salary, employee.salary);
    }

    //Methods
    @Override
    public String toString(){
        return "Id : " + this.code + " | Salary : " + this.salary;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Employee emp = (Employee) obj;
        return this.code.equals(emp.getCode());
    }

    public static Comparator<Employee> sp(){
        return new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.salary, o2.salary);
            }
        };
    }

    public static Predicate<Employee> sup(double salaryMin) {
        return new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.salary > salaryMin;
            }
        };
    }

    public static Function<Employee, Employee> multiplyByX(double x) {
        return new Function<Employee, Employee>() {
            @Override
            public Employee apply(Employee employee) {
                employee.setSalary(employee.salary * x);
                return employee;
            }
        };
    }
}
