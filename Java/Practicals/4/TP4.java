public class TP4 {
    public static void main(String[] args){
        Employee e = new Employee();
        System.out.println(e.toString());

        Register a = new Register();
        a.add(e);
        a.add(e);
        a.add(new Employee("test"));
        System.out.println(a);
    }
}