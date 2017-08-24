package com.korsak.rootsfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/**
 * It`s purpose is to find roots of polynomial equations
 */
class CalculateRoots {

    /**
     * @param factors a list with our factors
     * @return list of roots
     */
    List<Root> getRoots(List<Double> factors) {
        int degree = factors.size() - 1;
        List<Root> roots = new ArrayList<>();
        switch (degree){
            case 0:
                return new ArrayList<>();
            case 1:
                return new ArrayList<>(Collections.singletonList(linear(factors)));
            case 2:
                return quadratic(factors);
        }

        int rootsFound = 0;
        Double value, temp;
        Root root = new Root();

        // check for roots in integers [-1000,1000]
        for (Double i = -500.0; i <= 500.0; i += 0.01) {
            value = evaluate(factors, i);
            if (value == 0.0) {
                rootsFound++;
                root = new Root(setPrecision(i), 0.0);
                roots.add(root);
                if(root.getImaginaryPart() == 0.0) {
                    factors = hornersMethod(factors, root.getRealPart());
                }
                root = new Root();
                i--;
            }

            temp = evaluate(factors, i + 0.01);
            if (temp * value < 0) {
                // a root is somewhere in here
                root.setRealPart(setPrecision(newtonsMethod(factors, rootsFound, degree, i)));
                roots.add(root);
                if(root.getImaginaryPart() == 0.0 ) {
                    factors = hornersMethod(factors, root.getRealPart());
                }
                root = new Root();
                i--;

                if (roots.size() == degree) return roots;
            }
        }
        return roots;
    }

    private Root linear(List<Double> factors){
        return new Root(((-factors.get(0)) / (factors.get(1))), 0.0);
    }

    private List<Root> quadratic(List<Double> factors) {
        Root root_1 = new Root();
        Root root_2 = new Root();
        Double x_1;
        Double x_2;
        Double y_1;
        Double y_2;

        Double delta = pow(factors.get(1), 2) - 4 * factors.get(0) * factors.get(2);
        Double denominator = 2 * factors.get(2);
        if(delta >= 0) {
            x_1 = ((-factors.get(1) - sqrt(delta)) /  denominator);
            x_2 = ((-factors.get(1) + sqrt(delta)) / denominator);

            root_1.setRealPart(x_1);
            root_2.setRealPart(x_2);
        } else {
            delta = - delta;
            x_1 = ((-factors.get(1))/denominator);
            x_2 = x_1;
            root_1.setRealPart(x_1);
            root_2.setRealPart(x_2);
            y_1 = (-sqrt(delta)/denominator);
            y_2 = -y_1;
            root_1.setImaginaryPart(y_1);
            root_2.setImaginaryPart(y_2);
        }

        return new ArrayList<>(Arrays.asList(root_1, root_2));
    }


    private Double newtonsMethod(List<Double> factors, int rootsFound, int degree, Double argument) {
        Double result, offset, temp;
        boolean change = true;
        offset = 0.005;
        while (true) {
            do {
                result = evaluate(factors, argument);

                if ((abs(result) == 0.0)) {
                    rootsFound++;
                }

                if (rootsFound == degree) return argument;

                if (change) argument += offset;
                else argument -= offset;

                temp = evaluate(factors, argument);

            } while (abs(result) > abs(temp));

            offset /= 2;

            if (offset < pow(10, -8)) {
                return argument;
            }
            change = !change;
        }
    }


    /**
     * It executes the horners method on a list of Doubles
     *
     * @param factors input list
     * @param root    input root
     * @return result of horner's method
     */
    private List<Double> hornersMethod(List<Double> factors, Double root) {
        int i = factors.size() - 1;
        List<Double> resultOfDivision = new ArrayList<>();
        Double temp = 0.0;
        double di = factors.get(i); //fuck java

        resultOfDivision.add(di);
        temp += root * factors.get(i) + factors.get(i - 1);
        resultOfDivision.add(temp);

        while (i > 1) {
            i--;
            temp = root * temp + factors.get(i - 1);
            resultOfDivision.add(temp);
        }

        // change order of resultOfDivision
        List<Double> result = new ArrayList<>();
        for (int j = resultOfDivision.size() - 1; j >= 0; j--) {
            result.add(resultOfDivision.get(j));
        }
        result.remove(0);
        return result;
    }

    /**
     * Evaluate the equation with a for loop
     *
     * @param factors  a list with our factors
     * @param argument of the function
     * @return value of the function
     */
    private Double evaluate(List<Double> factors, Double argument) {

        Double value = 0.0;
        int degree = factors.size() - 1;

        for (int i = 0; i <= degree; i++) {
            value += factors.get(i) * pow(argument, i);
        }
        return value;
    }

    /**
     * Round up Doubles to 3 decimal places
     *
     * @param argument what needs to be rounded up
     * @return the result
     */
    private Double setPrecision(Double argument) {
        return Double.parseDouble(String.format(Locale.US, "%.3f", argument));
    }
}
