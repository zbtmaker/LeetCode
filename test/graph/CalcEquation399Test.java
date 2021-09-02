package graph;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/03/15
 */
public class CalcEquation399Test extends TestCase {

    private final CalcEquation399 equation = new CalcEquation399();

    public void test1() {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        queries.add(Arrays.asList("a", "x"));
        queries.add(Arrays.asList("x", "a"));
        double[] result = equation.calcEquation(equations, values, queries);
        Assert.assertArrayEquals(result, new double[]{6.0, 0.5, -1.0, 1.0, -1.0, -1.0, -1.0}, 0);
    }

    public void test2() {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));
        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x9"));
        queries.add(Arrays.asList("x9", "x9"));
        double[] result = equation.calcEquation(equations, values, queries);
        Assert.assertArrayEquals(result, new double[]{360.0, 1 / 120.0, 20.0, 1.0, -1.0, -1.0}, 0);
    }
}
