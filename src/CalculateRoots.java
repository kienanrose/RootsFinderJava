import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class CalculateRoots {


    public static void main(String[] args) {

        int degree = getDegree();
        List<Double> factors = getFactors(degree);

        printResult(evaluate(factors, -2.0), -2.0);

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

    private static Double evaluate(List<Double> factors, Double value) {
        Double result;

        result = factors.get(0) + factors.get(1) * value + factors.get(2) * pow(value, 2);

        return result;
    }

}
