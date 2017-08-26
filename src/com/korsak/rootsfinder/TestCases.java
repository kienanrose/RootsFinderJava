package com.korsak.rootsfinder;

import java.util.Arrays;
import java.util.List;

public class TestCases {

    public static void main(String[] args) {

        List<Complex> f_1 = Arrays.asList(new Complex(4.0, true), new Complex(8.0, true));
        List<Complex> f_2 = Arrays.asList(new Complex(2.0, true), new Complex(-3.0, true),
                new Complex(1.0, true));
        List<Complex> f_3 = Arrays.asList(new Complex(18.0, true), new Complex(-11.0, true),
                new Complex(-8.0, true), new Complex(1.0, true));
        List<Complex> f_4 = Arrays.asList(new Complex(720.0, true), new Complex(-1764.0, true),
                new Complex(1624.0, true), new Complex(-735.0, true), new Complex(175.0, true),
                new Complex(-21.0, true), new Complex(1.0, true));

        List<Complex> f_5 = Arrays.asList(new Complex(58.275, true), new Complex(-14.135, true),
                new Complex(-6.17, true), new Complex(1.0, true));
        List<Complex> f_6 = Arrays.asList(new Complex(), new Complex(), new Complex(), new Complex(),
                new Complex(6.5, true), new Complex(-5.1, true), new Complex(1.0, true));
        List<Complex> f_7 = Arrays.asList(new Complex(4.0, true), new Complex(), new Complex(1.0, true));
        List<Complex> f_8 = Arrays.asList(new Complex(5.0, true), new Complex(-4.0, true), new Complex(1.0, true));
        List<Complex> f_9 = Arrays.asList(new Complex(168.0, true), new Complex(4.0, true), new Complex(-95.0, true),
                new Complex(55.0, true), new Complex(-13.0, true), new Complex(1.0, true));



        test(f_1, 1);
        test(f_2, 2);
        test(f_3, 3);
        test(f_4, 4);
        test(f_5, 5);
        test(f_6, 6);
        test(f_7, 7);
        test(f_8, 8);
        test(f_9, 9);
    }

    private static void test(List<Complex> testCase, int test) {
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
