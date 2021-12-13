package com.company;
import java.util.LinkedList;

public class Polynomials extends LinkedList<Monomer> {

    // Constructors
    public Polynomials(){}

    // Methods
    @Override
    public int indexOf(Object o) {
        if (o == null || o.getClass() != this.get(0).getClass()) return -1;
        Monomer m = (Monomer) o;
        for (int i =0; i < this.size(); i++) {
            if (m.getDeg() <= this.get(i).getDeg()) {
                return i;
            }
        } return this.size();
    }

    @Override
    public boolean add(Monomer m){
        int indexOfM = this.indexOf(m);
        if (this.get(indexOfM).getDeg() != m.getDeg()) {
            super.add(indexOfM, m);
        }
        this.get(indexOfM).addition(m);
        return true;
    }

    public Polynomials addPoly(Polynomials p) {
        this.addAll(p);
        return this;
    };
}
