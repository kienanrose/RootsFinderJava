package com.korsak.rootsfinder;

import java.util.List;

class Root {

    private Double realPart;
    private Double imaginaryPart;

    Root(Double realPart, Double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    Root(){
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    Root(Double input, boolean real){
        if(real) {
            this.realPart = input;
            this.imaginaryPart = 0.0;
        } else{
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

    Root multiply(List<Root> products) {
        /*
        TODO this
         */
        return null;
    }

    Root add(List<Root> products) {
        /*
        TODO this
         */
        return null;
    }
}
