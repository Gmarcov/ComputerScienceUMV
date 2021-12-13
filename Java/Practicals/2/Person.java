public class Personne {
    private String nom;
    private Date dt;

    public String getNom(){
        return this.nom;
    }
    public Date getDt() {return this.dt;}

    public Personne(String nom, Date dt){
        this.nom = nom;
        this.dt = dt;
    }

    public boolean verifiedName(Personne x){
        return this.nom.equals(x.nom);
    }

    public Date compareAge(Personne x){
        return this.dt.compareDate(x.dt);
    }

    public Boolean sameYear(Personne x){
        return this.dt.sameYear(x.dt);
    }

    public String toString(){
        return this.nom + " " + this.dt.toString();
    }
}
