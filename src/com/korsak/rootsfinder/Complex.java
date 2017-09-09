package com.korsak.rootsfinder;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class Complex {

    /**
     * Complex has both real and imaginary parts
     *
     * @param realPart      a real number
     * @param imaginaryPart an imaginary number
     */
    Complex(Double realPart, Double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    Complex(Complex argument) {
        this.setRealPart(argument.realPart);
        this.setImaginaryPart(argument.imaginaryPart);
    }

    private Double realPart;
    private Double imaginaryPart;

    public static void main(String[] args) {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(3.0, 4.0);
        Complex c = new Complex(5.0, 6.0);

        a.multiply(b, c);
        System.out.println(a.toString());

        //multiplication works
    }

    /**
     * Sets both real and imaginary parts to 0
     */
    Complex() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    /**
     * Complex is either fully real or fully imaginary
     *
     * @param input non-zero part
     * @param real  if imaginary part = 0 -> true, else if real part = 0 -> false
     */
    Complex(Double input, boolean real) {
        if (real) {
            this.realPart = input;
            this.imaginaryPart = 0.0;
        } else {
            this.realPart = 0.0;
            this.imaginaryPart = input;
        }
    }

    Double getImaginaryPart() {
        return this.imaginaryPart;
    }

    void setImaginaryPart(Double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    Double getRealPart() {
        return this.realPart;
    }

    void setRealPart(Double realPart) {
        this.realPart = realPart;
    }

    /**
     * Get a product of a multiplication
     *
     * @param factors a container of Copmlex objects
     * @return product of multiplication
     */
    Complex multiply(Complex... factors) {
        Double real;
        Double imaginary;
        for (Complex factor : factors) {
            real = (this.realPart * factor.realPart) - (this.imaginaryPart * factor.imaginaryPart);
            imaginary = (this.realPart * factor.imaginaryPart) + (this.imaginaryPart * factor.realPart);
            setRealPart(real);
            setImaginaryPart(imaginary);
        }
        return this;
    }
/*
    Complex multiply(Complex... factors){
        int size = factors.length;
        if(size == 0) return this;

        multiplyTwoComplex(factors[size - 1]);

        //System.arraycopy(factors, 0, factors, 0, size - 2);
        Complex[] nFactors = new Complex[size - 1];
        for(int i = 0; i <= size - 2; i++){
            nFactors[i] = factors[i];
        }

        return multiply(nFactors);

        //return multiply(factors);
    }
*/

    /*Complex multiply(Complex... factors) {
        Double realPart = 1.0;
        Double imaginaryPart = 1.0;

        for (Complex product : factors) {
            realPart *= product.getRealPart();
            imaginaryPart *= product.getImaginaryPart();
        }
        return new Complex(realPart, imaginaryPart);
    }*/

    /**
     * @param products a container of Complex objects
     * @return a result of adding products
     */
    Complex add(Complex... products) {
        Double realPart = this.realPart;
        Double imaginaryPart = this.imaginaryPart;
        for (Complex product : products) {
            realPart += product.getRealPart();
            imaginaryPart += product.getImaginaryPart();
        }
        this.setRealPart(realPart);
        this.setImaginaryPart(imaginaryPart);

        return this;
    }

    /**
     * The module of a given complex number
     *
     * @return a module of a given Complex
     */
    Double module(Complex argument) {
        return sqrt(pow(argument.getRealPart(), 2) + pow(argument.getImaginaryPart(), 2));
    }

    @Override
    public String toString() {
        String r = getRealPart().toString();
        String i = getImaginaryPart().toString();
        String sign = " + ";
        String is = "i";

        if(getImaginaryPart() < 0) sign = " ";
        else if(getImaginaryPart() == 0){
            i = "";
            is = "";
            sign = "";
        }
        if(getRealPart() == 0) r = "";

        return r + sign + i + is;
    }
}