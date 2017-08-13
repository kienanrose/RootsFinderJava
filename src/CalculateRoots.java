import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        Double result;
        int degree = factors.size() - 1;
        Double offset = resetOffset();
        Double argument = 0.0;
        List<Double> roots = new ArrayList<>();
        Double temp;
        boolean change = true;
        int rootsFound = 0;

        while (true) {
            do {
                result = evaluate(factors, argument);

                if ((abs(result) == 0.0)) {
                    rootsFound++;
                    roots.add(setPrecision(argument));
                    offset = resetOffset();
//                    printResult(result, argument);
                    factors = hornersMethod(factors, argument);
                }

                if (rootsFound == degree) return roots;

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
            if (offset < pow(10, -6)) {
                degree--;
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

    private Double resetOffset() {
        return 10.0;
    }

    /**
     * Round up Doubles to 3 decimal places
     *
     * @param argument what needs to be rounded up
     * @return the result
     */
    private static Double setPrecision(Double argument) {
        return Double.parseDouble(String.format("%.6f", argument));
    }

//    private static void printResult(Double value, Double argument) {
//        System.out.println("f(" + argument + ") = " + value);
//    }


}
