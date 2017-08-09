import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class CalculateRoots {


    public static void main(String[] args) {

        int degree = getDegree();
        List<Double> factors = getFactors(degree);

        System.out.println("Roots: " + Arrays.toString(getRoots(factors).toArray()));


    }

    private static List<Double> getRoots(List<Double> factors) {
        Double result;
        int degree = factors.size() - 1;
        Double offset = 100.0;
        Double argument = -10000.0;
        List<Double> roots = new ArrayList<>();
        Double temp;
        boolean change = true;
        int rootsFound = 0;

        while (true) {
            do {
                result = evaluate(factors, argument);

                if (result == 0) {
                    rootsFound++;
                    roots.add(setPrecision(argument));
                }                           // return setPrecision(argument);

                if (change) {
                    argument += offset;
                    argument = setPrecision(argument);
                } else {
                    argument -= offset;
                    argument = setPrecision(argument);
                }

                temp = evaluate(factors, argument);

            } while (abs(result) >= abs(temp));

            printResult(result, argument);
            offset /= 2;

            change = !change;

            if (rootsFound == degree) return roots;
        }
    }


    private static int getDegree() {

        System.out.println("Insert degree: ");

        Scanner degree = new Scanner(System.in);
        return degree.nextInt();
    }

    private static List<Double> getFactors(int degree) {

        System.out.println("Insert factors: ");

        List<Double> factors = new ArrayList<>(degree);
        for (int i = 0; i <= degree; i++) {
            factors.add(new Scanner(System.in).nextDouble());
        }
        return factors;
    }

    private static void printResult(Double result, Double input) {
        System.out.println("f(" + input + ") = " + result);
    }

    private static Double evaluate(List<Double> factors, Double argument) {

        Double value = 0.0;
        int degree = factors.size() - 1;

        for (int i = 0; i <= degree; i++) {
            value += factors.get(i) * pow(argument, i);
        }

        return setPrecision(value);
    }

    private static Double setPrecision(Double argument){
        return Double.parseDouble(String.format("%.3f", argument));
    }

}
