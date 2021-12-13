import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public final class Register extends LinkedList<Employee> {

    public Register(){}

    public Register clone(Register r){
        Register temp = (Register) super.clone();
        for (Employee e : r) {
            temp.add(new Employee(e.getCode(), e.getSalary()));
        }
        return temp;
    }

    @Override
    public boolean add(Employee employee) {
        if (employee == null) return false;
        if (this.contains(employee)) return false;
        return super.add(employee);
    }

    public void readFile (File f) {
        Scanner input = null;
        String code;
        double salary;

        try {
            input = new Scanner(f);
        } catch (Exception e) {
            System.err.println("Couldn't open the File");
        }
        while (true){
            assert input != null;
            if (!input.hasNextLine()) break;
            code = input.next();
            salary = input.nextDouble();
            this.add(new Employee(code, salary));
        }
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Employee e : this) {
            s.append(e).append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean remove(Object obj) {
        if (obj == null || obj.getClass() != this.get(0).getClass()) return false;
        Employee e = (Employee) obj;
        return super.remove(e);
    }

    public Register filter(Predicate<Employee> p) {
        Register r = new Register();
        for (Employee e : this) {
            if (p.test(e)) {
                r.add(e);
            }
        }
        return r;
    }

    public Register mapper(Function<Employee, Employee> f){
        Register r = new Register();
        for (Employee e : this) {
            r.add(f.apply(e));
        }
        return r;
    }
}
