import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
 * individually calculate the fuel needed for the mass of each module (your puzzle input),
 * then add together all the fuel values.
 */
public class Day1 {

    public static void main(String[] args) {
        try {
            Stream<String> input = InputReader.readAllLines("src/input/day1a.txt");
            int sum = input.mapToInt(Integer::valueOf)
//                    .map(i -> Math.floorDiv(i, 3) -2)
                    .map(Day1::calcFuelB)
                    .sum();
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int calcFuel(int mass) {
        return Math.floorDiv(mass, 3) - 2;
    }

    public static int calcFuelB(int mass) {
        int a = calcFuel(mass);

        if(a > 0) {
            int b = calcFuelB(a);
            if(b >= 1) {
                a += b;
            }
        }
        return a;
    }
}
