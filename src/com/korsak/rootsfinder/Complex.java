package com.korsak.rootsfinder;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class Complex {

    private Double realPart;
    private Double imaginaryPart;

    /**
     * Complex has both real and imaginary parts
     *
     * @param realPart      a real number
     * @param imaginaryPart an imaginary number
     */
    private Complex(Double realPart, Double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
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
        for (Complex factor : factors) {
            multiplyTwoComplex(factor);
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

    private void multiplyTwoComplex(Complex input) {
        setRealPart((this.realPart * input.realPart) - (this.imaginaryPart * input.imaginaryPart));
        setImaginaryPart((this.realPart * input.imaginaryPart) + (input.realPart * this.imaginaryPart));
        //return new Complex((this.realPart * input.realPart) - (this.imaginaryPart * input.imaginaryPart),
        //        (this.realPart * input.imaginaryPart) + (input.realPart * this.imaginaryPart));
    }

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
        return new Complex(realPart, imaginaryPart);
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
        return realPart + " + " + imaginaryPart + "i";
    }
}