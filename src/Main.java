import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CalculateRoots calculateRoots = new CalculateRoots();

        Double degree = calculateRoots.getDegree();
        List<Double> factors = calculateRoots.getFactors(degree);

        System.out.println("Roots: " + Arrays.toString(calculateRoots.getRoots(factors).toArray()));

    }
}
