package com.korsak.rootsfinder;

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

    public Double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(Double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public Double getRealPart() {
        return realPart;
    }

    public void setRealPart(Double realPart) {
        this.realPart = realPart;
    }
}
