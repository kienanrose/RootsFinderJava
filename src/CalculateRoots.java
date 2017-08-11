import java.util.ArrayList;
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

                if ((abs(result) < pow(10.0, -4.0)) && isArgumentNew(roots, argument)) {
                    rootsFound++;
                    roots.add(setPrecision(argument));
                    offset = resetOffset();
                    printResult(result, argument);
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
            if(offset < pow(10, -4)){
                offset = resetOffset();
            }

            change = !change;
        }
    }

    /**
     * Just take degree input from a user
     *
     * @return degree in Int
     */
    Double getDegree() {
        System.out.println("Insert degree: ");
        try {
            return new Scanner(System.in).nextDouble();
        } catch (Exception e) {
            System.out.println("You need to insert numbers (duh)");
            return getDegree();
        }
    }

    /**
     * Just take the factors from a user
     *
     * @param degree so we know how many inputs to take
     * @return a list of factors
     */
    List<Double> getFactors(Double degree) {

        System.out.println("Insert factors: ");
        List<Double> factors = new ArrayList<>(degree.intValue());

        for (int i = 0; i <= degree; i++) {
            try {
                factors.add(new Scanner(System.in).nextDouble());
            } catch (Exception e) {
                System.out.println("You need to insert numbers (duh)");
                return getFactors(degree);
            }
        }
        return factors;
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

    private boolean isArgumentNew(List<Double> list, Double argument){//roots argument
        int temp = 0;
        for(int i = 0; i <= list.size() - 1; i++){
            if(abs(list.get(i) - argument) > pow(10, -2)){
                temp++;
            }
        }
        return temp == list.size();
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
        return Double.parseDouble(String.format("%.4f", argument));
    }

    private static void printResult(Double value, Double argument) {
        System.out.println("f(" + argument + ") = " + value);
    }


}
