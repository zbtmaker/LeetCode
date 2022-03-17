package design;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zoubaitao
 * date 2022/03/16
 */
public class AllOne432Test extends TestCase {

    public void test1() {
        AllOne432 allOne = new AllOne432();
        allOne.inc("hello");
        allOne.inc("hello");
        Set<String> maxKeySet = Arrays.stream(new String[]{"hello"}).collect(Collectors.toSet());
        Set<String> minKeySet = Arrays.stream(new String[]{"hello"}).collect(Collectors.toSet());
        Assert.assertTrue(maxKeySet.contains(allOne.getMaxKey()));
        Assert.assertTrue(minKeySet.contains(allOne.getMinKey()));
        allOne.inc("leet");
        minKeySet = Arrays.stream(new String[]{"leet"}).collect(Collectors.toSet());
        Assert.assertTrue(maxKeySet.contains(allOne.getMaxKey()));
        Assert.assertTrue(minKeySet.contains(allOne.getMinKey()));
    }

    public void test2() {
        AllOne432 allOne = new AllOne432();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        Set<String> maxKeySet = Arrays.stream(new String[]{"hello"}).collect(Collectors.toSet());
        Assert.assertTrue(maxKeySet.contains(allOne.getMaxKey()));
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        maxKeySet = Arrays.stream(new String[]{"leet", "code"}).collect(Collectors.toSet());
        Assert.assertTrue(maxKeySet.contains(allOne.getMaxKey()));
    }

    public void test3() {
        AllOne432 allOne = new AllOne432();
        allOne.inc("hello");
        Set<String> maxKeySet = Arrays.stream(new String[]{"hello"}).collect(Collectors.toSet());
        Set<String> minKeySet = Arrays.stream(new String[]{"hello"}).collect(Collectors.toSet());
        Assert.assertTrue(maxKeySet.contains(allOne.getMaxKey()));
        Assert.assertTrue(minKeySet.contains(allOne.getMinKey()));
        allOne.inc("leet");
        maxKeySet = Arrays.stream(new String[]{"hello", "leet"}).collect(Collectors.toSet());
        minKeySet = Arrays.stream(new String[]{"hello", "leet"}).collect(Collectors.toSet());
        Assert.assertTrue(maxKeySet.contains(allOne.getMaxKey()));
        Assert.assertTrue(minKeySet.contains(allOne.getMinKey()));
    }

    public void test4() {
        AllOne432 allOne = new AllOne432();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        Set<String> minKeySet = Arrays.stream(new String[]{"a"}).collect(Collectors.toSet());
        Assert.assertTrue(minKeySet.contains(allOne.getMinKey()));
        allOne.dec("a");
        minKeySet = Arrays.stream(new String[]{"c"}).collect(Collectors.toSet());
        Set<String> maxKeySet = Arrays.stream(new String[]{"c"}).collect(Collectors.toSet());
        Assert.assertTrue(maxKeySet.contains(allOne.getMaxKey()));
        Assert.assertTrue(minKeySet.contains(allOne.getMinKey()));
    }
}
