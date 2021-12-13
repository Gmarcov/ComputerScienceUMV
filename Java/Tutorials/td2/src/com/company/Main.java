package com.company;

public class Main {

    public static void main(String[] args){
        // TD2
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(4, -7);
        Rational r3 = new Rational(r2);

        System.out.println(r2 + "  " + r1);
        System.out.println(r2.multiply(r1));
        System.out.println(r1.subtract(r2));
        System.out.println(r2 + " copy de r2" + r3);

        // TD3
        Monomer m1 = new Monomer(3, r1);
        Monomer m2 = new Monomer(m1);
        System.out.println(m1 + " et " + m2);
        System.out.println(m1.getCoefficient().hashCode() + " et " + m2.getCoefficient().hashCode());
    }

}