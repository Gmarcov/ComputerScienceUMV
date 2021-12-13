package com.company;

public class Rational {
    private int num;
    private int den;

    // Getters & Setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }

    // Constructors
    public Rational(){
        num = 1;
        den = 1;
    }

    public Rational(int num){
        this.num = num;
        this.den = 1;
    }

    public Rational(int num, int den){
        this.num = num;
        this.den = den;
    }

    // recopy constructor
    public Rational(Rational r){
        this(r.num, r.den);
    }

    // Methods
    private static int func(int a, int b){
        if (b == 0) return a;
        else return func(b, a % b);
    }

    public boolean isValid(){
        return den != 0;
    }

    public boolean normalForm(){
        return func(this.num, this.den) == 1;
    }

    @Override
    public String toString(){
        if (this.isValid()){
            if (this.num % this.den == 0) return "0";
            if (this.num % this.den == 1) return "1";
            if (this.den == 1) return this.num + "";
            if (this.den < 0) {
                this.num = -this.num;
                this.den = -this.den;
            }
            return this.num + "/" + this.den;
        }
        return "Rational non Valid (den = 0)";
    }

    // Opposite & Inverse
    public Rational opp(){
        return new Rational(-this.num, this.den);
    }

    public Rational inv(){
        return new Rational(this.den, this.num);
    }

    // Operators Methods
    public Rational add(Rational r){
        if (r == null) return this;
        Rational temp = new Rational();
        temp.setNum(this.num * r.den + this.den * r.num);
        temp.setDen(this.den * r.den);
        return temp;
    }

    public Rational multiply(Rational r){
        if (r == null) return this;
        Rational temp = new Rational();
        temp.setNum(this.num * r.num);
        temp.setDen(this.den * r.den);
        return temp;
    }

    public Rational subtract(Rational r){
        if (r == null) return this;
        return this.add(r.opp());
    }

    public Rational div(Rational r){
        if (r == null) return this;
        return this.multiply(r.inv());
    }

}