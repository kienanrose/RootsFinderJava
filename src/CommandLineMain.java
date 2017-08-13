import java.util.Arrays;
import java.util.List;

public class CommandLineMain {

    public static void main(String[] args) {

        while(true) {

            CalculateRoots calculateRoots = new CalculateRoots();
            Double degree = calculateRoots.getDegree();
            List<Double> factors = calculateRoots.getFactors(degree);
            System.out.println(Arrays.toString(calculateRoots.hornersMethod(factors, -2.0).toArray()));

        }
    }
}
//        System.out.println("Roots: " + Arrays.toString(calculateRoots.getRoots(factors).toArray()));
