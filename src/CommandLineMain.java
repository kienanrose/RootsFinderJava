import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLineMain {

    public static void main(String[] args) {

        CommandLineMain commandLineMain = new CommandLineMain();
        CalculateRoots calculateRoots = new CalculateRoots();
        Double degree = commandLineMain.getDegree();
        List<Double> factors = commandLineMain.getFactors(degree);
        System.out.println("Roots: " + Arrays.toString(calculateRoots.getRoots(factors).toArray()));
    }

    /**
     * Just take degree input from a user
     *
     * @return degree in Int
     */
    private Double getDegree() {
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
    private List<Double> getFactors(Double degree) {

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
}
