package com.korsak.rootsfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCases {

    public static void main(String[] args) {

        List<Double> f_1 = new ArrayList<>(Arrays.asList(4.0, 8.0));
        List<Double> f_2 = new ArrayList<>(Arrays.asList(2.0, -3.0, 1.0));
        List<Double> f_3 = new ArrayList<>(Arrays.asList(18.0, -11.0, -8.0, 1.0));
        List<Double> f_4 = new ArrayList<>(Arrays.asList(720.0, -1764.0, 1624.0, -735.0, 175.0, -21.0, 1.0));
        List<Double> f_5 = new ArrayList<>(Arrays.asList(58.275, -14.135, -6.17, 1.0));
        //List<Double> f_6 = new ArrayList<>(Arrays.asList(-996004.0, 0.0, 1.0));
        List<Double> f_7 = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 6.5, -5.1, 1.0));
        List<Double> f_8 = new ArrayList<>(Arrays.asList(4.0, 0.0, 1.0));
        List<Double> f_9 = new ArrayList<>(Arrays.asList(5.0, -4.0, 1.0));


        test(f_1, 1);
        test(f_2, 2);
        test(f_3, 3);
        test(f_4, 4);
        test(f_5, 5);
        //test(f_6, 6);
        test(f_7, 7);
        test(f_8, 8);
        test(f_9, 9);
    }

    private static void test(List<Double> testCase, int test) {
        com.korsak.rootsfinder.CalculateRoots calculateRoots = new com.korsak.rootsfinder.CalculateRoots();
        long startTime = System.currentTimeMillis();
        List<Complex> results = calculateRoots.getRoots(testCase);
        System.out.println("Test(" + test + ") " + (System.currentTimeMillis() - startTime) + " ms (execution time)");

        for (Complex complex : results) {
            System.out.print("x = ");
            if (complex.getImaginaryPart() == 0.0) {
                System.out.print(complex.getRealPart());
            } else if (complex.getRealPart() == 0.0) {
                System.out.print(complex.getImaginaryPart() + " i");
            } else {
                System.out.print(complex.getRealPart() + " + " + complex.getImaginaryPart() + " i");
            }
            System.out.println();
        }
    }
}
