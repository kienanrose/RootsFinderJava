package com.korsak.rootsfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLineMain {

    public static void main(String[] args) {

        CommandLineMain commandLineMain = new CommandLineMain();
        CalculateRoots calculateRoots = new com.korsak.rootsfinder.CalculateRoots();
        int degree = commandLineMain.getDegree();
        List<Complex> factors = commandLineMain.getFactors(degree);
        long startTime = System.currentTimeMillis();
        System.out.println("Roots: " + Arrays.toString(calculateRoots.getRoots(factors).toArray()));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    /**
     * Just take degree input from a user
     *
     * @return degree in Int
     */
    private int getDegree() {
        System.out.println("Insert degree: ");
        try {
            return new Scanner(System.in).nextInt();
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
    private List<Complex> getFactors(int degree) {

        System.out.println("Insert factors: ");
        List<Complex> factors = new ArrayList<>(degree);
/*
        for (int i = 0; i <= degree; i++) {
            try {
                factors.add(new Scanner(System.in).nextDouble());
            } catch (Exception e) {
                System.out.println("You need to insert numbers (duh)");
                return getFactors(degree);
            }
        }*/

        for (Complex factor : factors) {
            try {
                factor.setRealPart(new Scanner(System.in).nextDouble());
                factor.setImaginaryPart(new Scanner(System.in).nextDouble());
            } catch (Exception e) {
                System.out.println("You need to insert numbers (duh)");
                return getFactors(degree);
            }
        }
        return factors;
    }
}
