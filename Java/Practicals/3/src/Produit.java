public class Produit {
    private String code;
    private Date dt;

    public String getCode(){
        return this.code;
    }

    public Date getDt(){
        return dt;
    }

    public Produit(){
        this.code = "null";
        this.dt = new Date();
    }

    public Produit(String code, Date dt){
        this.code = code;
        this.dt = dt;
    }

    public boolean codeEquals(Produit P){
        return this.code.equals(P.code);
    }

    public boolean plusAncient(Produit P){
        if (this.dt.year > P.dt.year) return false;
        if (this.dt.year < P.dt.year) return true;
        if (this.dt.month > P.dt.month) return false;
        if (this.dt.month < P.dt.month) return true;
        return this.dt.day < P.dt.day;
    }

    public boolean equals(Produit P){
        return (this.code.equals(P.code) && this.dt.equals(P.dt));
    }

    public String toString(){
        return this.code + " " + this.dt.toString();
    }
}