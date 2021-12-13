import java.util.Arrays;

public class Livret {
    private int dim, der = -1;
    private Personne[] cont;

    public int getDim() {
        return dim;
    }

    public Personne[] getCont() {
        return cont;
    }

    public Livret(){
        this.dim = 0;
    }

    public Livret(int dim){
        this.dim = dim;
        this.cont = new Personne[dim];
    }

    public void addPerson(Personne x){ this.cont[++der] = x; }

    public int localPerson(String nomPersonne){
        for (int i = 0; i < cont.length; i++){
            if( cont[i].getNom().equals(nomPersonne) ){
                return i;
            }
        }
        return -1;
    }

    public Personne[] catalogueSameYear(Date y){
        Personne[] cat = new Personne[this.dim];
        for(int i = 0; i < this.cont.length; i++){
            if (this.cont[i].getDt().sameYear(y)){
                cat[i] = cont[i];
            }
        }
        return cat;
    }

    public String toString(){
        return this.dim + " " + this.der + " " + Arrays.toString(this.cont);
    }

}
