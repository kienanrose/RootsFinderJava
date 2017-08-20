package com.korsak.rootsfinder;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.pow;


/**
 * It`s purpose is to find roots of polynomial equations
 */
class CalculateRoots {

    /**
     * @param factors a list with our factors
     * @return list of roots
     */
    List<Double> getRoots(List<Double> factors) {
        int degree = factors.size() - 1;
        List<Double> roots = new ArrayList<>();
        int rootsFound = 0;
        Double value, temp;


        // check for roots in integers [-1000,1000]
        for (Double i = -1000.0; i <= 1000.0; i++) {
            value = evaluate(factors, i);
            if (value == 0.0) {
                rootsFound++;
                roots.add(i);
                //factors = hornersMethod(factors, i);
            }

            temp = evaluate(factors, i + 1);
            if (temp * value < 0) {
                //root is somewhere in here
                System.out.println("yo theres a root between " + i + " and " + (i + 1));
                roots.add(tep(factors, rootsFound, degree, i));
                if(roots.size() == degree) return roots;
            }
        }
        return roots;
    }

    private Double tep(List<Double> factors, int rootsFound, int degree, Double argument) {
        Double result, offset, temp;
        boolean change = true;
        offset = 0.5;
        while (true) {
            do {
                result = evaluate(factors, argument);

                if ((abs(result) == 0.0)) {
                    rootsFound++;
                }

                if (rootsFound == degree) return argument;

                if (change) {
                    argument += offset;
                    argument = setPrecision(argument);
                } else {
                    argument -= offset;
                    argument = setPrecision(argument);
                }

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
        return Double.parseDouble(String.format("%.6f", argument));
    }
}
