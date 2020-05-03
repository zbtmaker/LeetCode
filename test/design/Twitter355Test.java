package design;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/05/03
 */
public class Twitter355Test {
    private Twitter355 twitter355 = new Twitter355();

    @Test
    public void test1() {
        twitter355.follow(1, 2);
        twitter355.follow(1, 3);
        twitter355.follow(3, 2);
        twitter355.postTweet(2, 1);
    }

    @Test
    public void test2() {
        twitter355.postTweet(1, 5);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{5});
        twitter355.follow(1, 2);
        twitter355.postTweet(2, 6);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{6, 5});
        twitter355.unfollow(1, 2);
        twitter355.getNewsFeed(1);
    }

    @Test
    public void test3() {
        twitter355.postTweet(1, 5);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{5});
        twitter355.follow(1, 2);
        twitter355.postTweet(2, 6);
        twitter355.postTweet(2, 7);
        twitter355.postTweet(2, 8);
        twitter355.postTweet(2, 9);
        twitter355.postTweet(2, 10);
        twitter355.postTweet(2, 11);
        twitter355.postTweet(2, 12);
        twitter355.postTweet(2, 13);
        twitter355.postTweet(2, 14);
        twitter355.postTweet(2, 15);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{15, 14, 13, 12, 11, 10, 9, 8, 7, 6});
    }

    @Test
    public void test4() {
        twitter355.postTweet(1, 1);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{1});
        twitter355.follow(2, 1);
        Assert.assertArrayEquals(twitter355.getNewsFeed(2).toArray(new Integer[0]), new Integer[]{1});
        twitter355.unfollow(2, 1);
        Assert.assertArrayEquals(twitter355.getNewsFeed(2).toArray(new Integer[0]), new Integer[]{});
    }

    @Test
    public void test5() {
        twitter355.postTweet(3, 3);
        twitter355.postTweet(1, 1);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{1});


        twitter355.follow(2, 1);
        twitter355.follow(2, 3);
        Assert.assertArrayEquals(twitter355.getNewsFeed(2).toArray(new Integer[0]), new Integer[]{1, 3});
    }

    @Test
    public void test6() {
        twitter355.postTweet(1, 5);
        twitter355.unfollow(1, 1);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{5});
    }

    @Test
    public void test7() {
        twitter355.postTweet(1, 4);
        twitter355.postTweet(2, 5);
        twitter355.unfollow(1, 2);
        twitter355.follow(1, 2);
        List<Integer> list = twitter355.getNewsFeed(1);
        System.out.println(Arrays.toString(list.toArray(new Integer[0])));
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{5, 4});
    }

    @Test
    public void test8() {
        twitter355.postTweet(2, 5);
        twitter355.follow(1, 2);
        twitter355.follow(1, 2);
        List<Integer> list = twitter355.getNewsFeed(1);
        System.out.println(Arrays.toString(list.toArray(new Integer[0])));
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{5});
    }

    @Test
    public void test9() {
        twitter355.postTweet(1, 5);
        twitter355.postTweet(2, 3);
        twitter355.postTweet(1, 101);
        twitter355.postTweet(2, 13);
        twitter355.postTweet(2, 10);
        twitter355.postTweet(1, 2);
        twitter355.postTweet(1, 94);
        twitter355.postTweet(2, 505);
        twitter355.postTweet(1, 333);
        twitter355.postTweet(2, 22);
        twitter355.postTweet(1, 11);
        twitter355.postTweet(1, 205);
        twitter355.postTweet(2, 203);
        twitter355.postTweet(1, 201);
        twitter355.postTweet(2, 213);
        twitter355.postTweet(1, 200);
        twitter355.postTweet(2, 202);
        twitter355.postTweet(1, 204);
        twitter355.postTweet(2, 208);
        twitter355.postTweet(2, 233);
        twitter355.postTweet(1, 222);
        twitter355.postTweet(2, 211);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{222,204,200,201,205,11,333,94,2,101});
        twitter355.follow(1, 2);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{211,222,233,208,204,202,200,213,201,203});
        twitter355.unfollow(1, 2);
        Assert.assertArrayEquals(twitter355.getNewsFeed(1).toArray(new Integer[0]), new Integer[]{222,204,200,201,205,11,333,94,2,101});
    }
}
