import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCases {

    private int testsPassed = 0;
    private int testsFailed = 0;

    private int getTestsPassed() {
        return this.testsPassed;
    }

    private void setTestsPassed() {
        this.testsPassed++;
    }

    private int getTestsFailed() {
        return this.testsFailed;
    }

    private void setTestsFailed() {
        this.testsFailed++;
    }


    public static void main(String[] args) {

        TestCases testCases = new TestCases();

        List<Double> f_1 = new ArrayList<>(Arrays.asList(4.0, 8.0));
        List<Double> f_2 = new ArrayList<>(Arrays.asList(2.0, -3.0, 1.0));
        List<Double> f_3 = new ArrayList<>(Arrays.asList(18.0, -11.0, -8.0, 1.0));

        List<Double> r_1 = new ArrayList<>(Collections.singletonList(-0.5));
        List<Double> r_2 = new ArrayList<>(Arrays.asList(1.0, 2.0));
        List<Double> r_3 = new ArrayList<>(Arrays.asList(1.0, 2.0, 9.0));


        test(f_1, r_1);
        test(f_2, r_2);
        test(f_3, r_3);

        System.out.println("Tests passed: " + testCases.getTestsPassed());
        System.out.println("Tests failed: " + testCases.getTestsFailed());
    }

    private static void test(List<Double> testCase, List<Double> expectedResult) {
        CalculateRoots calculateRoots = new CalculateRoots();
        TestCases testCases = new TestCases();
        List<Double> results = calculateRoots.getRoots(testCase);
        if (results == expectedResult) testCases.setTestsPassed();
        else testCases.setTestsFailed();
    }
}
