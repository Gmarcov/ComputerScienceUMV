import java.util.Arrays;

public class tp2 {
    public static void main(String[] args) {
        Date date = new Date(6, 27, 2000);
        Date date2 = new Date(11, 1, 2002);
        Date date3 = new Date(3, 4, 2002);

        Personne p1 = new Personne("Marcos", date);
        Personne p2 = new Personne("Sam", date2);
        Personne p3 = new Personne("Jo", date3);

        System.out.println(date.compareDate(date2).toString());
        System.out.println(date.sameYear(date2));

        System.out.println(p1.toString());

        Livret livret1 = new Livret(3);
        livret1.addPerson(p1);
        livret1.addPerson(p2);
        livret1.addPerson(p3);

        System.out.println(livret1.getCont().length);
        System.out.println(livret1.getCont()[0]);
        System.out.println(livret1.localPerson("Sam"));

        System.out.println(Arrays.toString(livret1.catalogueSameYear(date3)));

        Livret test = new Livret();

        System.out.println(test.getDim());
        System.out.println(livret1.toString());
    }
}