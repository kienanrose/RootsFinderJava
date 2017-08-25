package com.korsak.rootsfinder;

import java.util.List;

class Complex {

    private Double realPart;
    private Double imaginaryPart;

    /**
     * Complex has both real and imaginary parts
     *
     * @param realPart
     * @param imaginaryPart
     */
    Complex(Double realPart, Double imaginaryPart) {
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
        return imaginaryPart;
    }

    void setImaginaryPart(Double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    Double getRealPart() {
        return realPart;
    }

    void setRealPart(Double realPart) {
        this.realPart = realPart;
    }

    /**
     * Get a product of a multiplication
     *
     * @param factors a list of your factors
     * @return product of multiplication
     */
    Complex multiply(List<Complex> factors) {
        Double realPart = this.realPart;
        Double imaginaryPart = this.imaginaryPart;

        for (Complex product : factors) {
            realPart *= product.getRealPart();
            imaginaryPart *= product.getImaginaryPart();
        }
        return new Complex(realPart, imaginaryPart);
    }

    /**
     * @param products
     * @return
     */
    Complex add(List<Complex> products) {
        Double realPart = this.realPart;
        Double imaginaryPart = this.imaginaryPart;

        for (Complex product : products) {
            realPart += product.getRealPart();
            imaginaryPart += product.getImaginaryPart();
        }
        return new Complex(realPart, imaginaryPart);
    }
}
