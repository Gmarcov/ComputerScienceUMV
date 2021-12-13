public class tp3 {
    public static void main(String[] args){
        Date d1 = new Date(3, 5, 2021);
        Date d2 = new Date(2, 5, 2021);

        Produit p1 = new Produit("XXX", d1);
        Produit p2 = new Produit("XXX", d2);
        Produit p3 = new Produit();
        Produit p4 = new Produit();

        Stock s = new Stock();


        System.out.println("First part");

        System.out.println(d1.equals(d2));
        System.out.println(p1.equals(p2));
        System.out.println(p1.toString());

        System.out.println(p1.plusAncient(p2));

        System.out.println("Second part");
        s.add(p1);
        s.add(p2);
        s.add(p3);
        s.add(p4);
        System.out.println(s.size());

        System.out.println(s.oldestProduct());
        System.out.println(s.validProducts(new Date(3, 4, 2000)));
        System.out.println(s);
        s.deleteOldProducts(new Date(3, 4, 2000));
        System.out.println(s);
    }
}