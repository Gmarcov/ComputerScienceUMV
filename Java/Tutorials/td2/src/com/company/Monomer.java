package com.company;

import java.util.Objects;

public class Monomer {
    private int deg;
    private Rational coefficient;

    // Getters & Setters
    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public Rational getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Rational coefficient) {
        this.coefficient = coefficient;
    }

    // Constructors
    public Monomer(){
        deg = 0;
        coefficient = new Rational();
    }

    public Monomer(int deg) {
        this.deg = deg;
        coefficient = new Rational();
    }

    public Monomer(int deg, Rational coefficient){
        if (coefficient != null){
            this.deg = deg;
            this.coefficient = new Rational(coefficient.getNum(), coefficient.getDen());
        }
    }

    // Recopy Constructor
    public Monomer(Monomer m){
        if (m == null) {
            this.setDeg(0);
            this.setCoefficient(new Rational());
        }
        assert m != null;
        this.setDeg(m.deg);
        this.setCoefficient(new Rational(m.coefficient));
    }

    // Methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomer monomer = (Monomer) o;
        return deg == monomer.deg && Objects.equals(coefficient, monomer.coefficient);
    }

    @Override
    public String toString(){
        return "Deg " + this.getDeg() + " et de coefficient " + this.coefficient.toString();
    }

    public Monomer addition(Monomer m){
        assert equals(m);
        coefficient = coefficient.add(m.coefficient);
        return this;
    }

    public Monomer multiply(Monomer m){
        if (m == null) throw new AssertionError();
        Monomer temp = new Monomer();
        temp.setDeg(this.deg * m.deg);
        temp.setCoefficient(this.getCoefficient().multiply(m.getCoefficient()));
        return temp;
    }
}