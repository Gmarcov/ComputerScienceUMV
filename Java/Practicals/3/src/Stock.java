import java.util.LinkedList;

public class Stock extends LinkedList<Produit> {

    public boolean add(Produit P){
        if (!this.contains(P)) {
            this.addLast(P);
            return true;
        }
        return false;
    }

    public Produit oldestProduct(){
        int temp = 0;
        for (int i = 0; i < this.size(); i++){
            if (!this.get(temp).plusAncient(this.get(i))){
                temp = i;
            }
        }
        return this.get(temp);
    }

    public LinkedList<Produit> validProducts(Date dt){
        LinkedList<Produit> listValidProducts = new LinkedList<Produit>();
        for (int i = 0; i < this.size(); i++){
            if (!this.get(i).getDt().isValid(dt)){
                listValidProducts.add(this.get(i));
            }
        }
        return listValidProducts;
    }

    public void deleteOldProducts(Date dt){
        for (int i = 0; i < this.size(); i++){
            if (!this.get(i).getDt().isValid(dt)){
                System.out.println(i + " was deleted");
                this.remove(this.get(i));
                i--;
            }
        }
    }
}
