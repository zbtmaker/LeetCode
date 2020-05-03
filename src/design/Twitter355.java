package design;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * 1、postTweet(userId, tweetId): 创建一条新的推文
 * 2、getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * 3、follow(followerId, followeeId): 关注一个用户
 * 4、unfollow(followerId, followeeId): 取消关注一个用户
 * 链接：https://leetcode-cn.com/problems/design-twitter
 *
 * @author baitao zou
 * date 2020/05/02
 */
public class Twitter355 {
    /**
     * 关注的人集合，这里每个用户关注的人用一个Set存储起来，主要是考虑到用户关联的用户是不会重复的。
     */

    private final Map<Integer, Set<Integer>> followerMap;

    /**
     * 当一个followerId关注一个followeeId时，我们需要将followerId添加到followeeId的集合中。
     * 为什么要这么做主要是当followeeId发布tweet时，我们需要将这个tweet的tweetId保存到followerId
     * 的tweetMap当中。其实我们也可以不这个做，但是我想，在实际的项目中，在followee发布tweet的时候去
     * 更新关注他的人的tweet，这样就能保证follower在getNewsFeed的时候能够直接返回，而不用先查询所有
     * 关注的人，然后将所有关注人发送的tweet放到一个集合中排序后再返回前10条。
     */
    private final Map<Integer, Set<Integer>> followeeMap;

    /**
     * 每个用户的朋友圈，
     * key:userId, value:tweetId集合
     */
    private final Map<Integer, LinkedList<Node>> tweetMap;

    /**
     * 每个userId自己生成的tweet集合，
     * key:userId, value:tweetId 链表
     */
    private final Map<Integer, LinkedList<Node>> selfTweetMap;

    /**
     * 每个用户需要存储的朋友圈tweetId的数量
     */
    private static final int CAPACITY = 10;

    /**
     * 用来记录用户生成post tweet的先后次序，其实讲道理是可以根据System时间的。但是
     * 对于分布式场景和并发场景似乎有些不妥
     */
    private static long time = 1;

    private class Node implements Comparable<Node> {
        private int userId;
        private int tweetId;
        private long timestamp;

        public Node(int userId, int tweetId, long timestamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }


        @Override
        public int compareTo(Node o) {
            return this.timestamp < o.timestamp ? 1 : -1;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter355() {
        followerMap = new HashMap<>();
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
        selfTweetMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     * 当一个用户发布了tweet，
     * 1、将这个tweetId添加到tweetMap中
     * 2、将tweetId添加到selfTweetMap中
     * 3、从followeeMap找到所有关注了userId的用户
     * 4、更新每一个followee的tweetMap链表
     */
    public void postTweet(int userId, int tweetId) {
        //更新用户自己的tweet
        LinkedList<Node> tweetList = tweetMap.get(userId);
        if (tweetList == null) {
            tweetList = new LinkedList<>();
        }
        if (tweetList.size() >= CAPACITY) {
            tweetList.removeLast();
        }
        Node tweetNode = new Node(userId, tweetId, time++);
        tweetList.addFirst(tweetNode);
        tweetMap.put(userId, tweetList);

        LinkedList<Node> selfTweets = selfTweetMap.get(userId);
        if (selfTweets == null) {
            selfTweets = new LinkedList<>();

        }
        if (selfTweets.size() >= CAPACITY) {
            selfTweets.removeLast();
        }
        selfTweets.addFirst(tweetNode);
        selfTweetMap.put(userId, selfTweets);
        //更新关注了该用户的tweet
        Set<Integer> followeeSet = followeeMap.get(userId);
        if (followeeSet == null) {
            return;
        }
        for (Integer followeeId : followeeSet) {
            LinkedList<Node> followeeTweet = tweetMap.get(followeeId);
            if (followeeTweet == null) {
                followeeTweet = new LinkedList<>();
            }
            if (followeeTweet.size() >= CAPACITY) {
                followeeTweet.removeLast();
            }
            followeeTweet.addFirst(tweetNode);
            tweetMap.put(followeeId, followeeTweet);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Node> tweets = tweetMap.get(userId);
        if (tweets == null) {
            return new LinkedList<>();
        }
        return tweets.stream().map(node -> node.tweetId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     * 1、判断followerId、followeeId是否是同一个人，是则返回
     * 2、将followeeId添加到followerId的followerMap中，表示followerId关注了谁
     * 3、将followerId添加到followeeId的followeeMap中，表示followeeId被谁关注了
     * 4、将followeeId的selfTweetMap的tweets集合添加到followerId的tweetMap中，这样followerId就能
     * 看到followeeId的tweet了。
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        //1、添加followeeId添加到关注人集合中
        Set<Integer> followSet = followerMap.get(followerId);
        if (followSet == null) {
            followSet = new HashSet<>();
        }
        if (followSet.contains(followeeId)) {
            return;
        }
        followSet.add(followeeId);
        followerMap.put(followerId, followSet);

        //2、添加followerId添加到被关注人集合中
        Set<Integer> followeeSet = followeeMap.get(followeeId);
        if (followeeSet == null) {
            followeeSet = new HashSet<>();
        }
        followeeSet.add(followerId);
        followeeMap.put(followeeId, followeeSet);

        //3、将followeeId的tweet添加到followerId对应的tweetMap中
        LinkedList<Node> followeeSelfTweets = selfTweetMap.get(followeeId);
        if (followeeSelfTweets == null) {
            return;
        }

        //将被关注人的tweetId添加到followerId的tweetMap中
        LinkedList<Node> followerTweets = tweetMap.get(followerId);
        if (followerTweets == null) {
            followerTweets = new LinkedList<>(followeeSelfTweets);
        } else {
            followerTweets.addAll(followeeSelfTweets);
            Collections.sort(followerTweets);
            LinkedList<Node> tmp = new LinkedList<>();
            int size = Math.min(CAPACITY, followerTweets.size());
            Iterator<Node> iterator = followerTweets.iterator();
            for (int i = 0; i < size; i++) {
                tmp.add(iterator.next());
            }
            followerTweets = tmp;
        }
        tweetMap.put(followerId, followerTweets);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     * 1、判断followerId、followeeId是否是同一个人，是则返回
     * 2、从followerMap中找到followerId关注的人集合，判断followeeId是否是存在followerSet中，不存在，则返回，存在，则删除
     * 3、从followeeMap中找到followeeId被关注人集合，判断followerId是否存在于followeeSet中，不存在，则返回，存在，则删除
     * 4、从tweetMap中找到followerId的tweet集合，然后将followeeId的tweet全部删除
     * 5、将followerId自己的tweet添加到followerId的tweetMap对应的tweets集合中，然后排序后取前10位
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        //删除followerId
        if (followerMap.containsKey(followerId)) {
            Set<Integer> followerSet = followerMap.get(followerId);
            if (followerSet != null && followerSet.contains(followeeId)) {
                followerSet.remove(followeeId);
            } else {
                return;
            }
        }

        //删除关注人的tweetId
        LinkedList<Node> tweets = tweetMap.get(followerId);
        LinkedList<Node> tweetsTmp = new LinkedList<>();
        if (tweets != null) {
            for (Node tweet : tweets) {
                if (tweet.userId == followeeId || tweet.userId == followerId) {
                    continue;
                }
                tweetsTmp.add(tweet);
            }
            LinkedList<Node> selfTweets = selfTweetMap.get(followerId);
            if (selfTweets != null && selfTweets.size() > 0) {
                tweetsTmp.addAll(selfTweetMap.get(followerId));
                Collections.sort(tweetsTmp);
                LinkedList<Node> tmp = new LinkedList<>();
                Iterator<Node> iterator = tweetsTmp.iterator();
                int size = Math.min(CAPACITY, tweetsTmp.size());
                for (int i = 0; i < size; i++) {
                    tmp.add(iterator.next());
                }
                tweetsTmp = tmp;
            }
            tweetMap.put(followerId, tweetsTmp);
        }

        //将followeeId对应的followerId删除
        if (followeeMap.containsKey(followeeId)) {
            Set<Integer> followeeSet = followeeMap.get(followeeId);
            if (followeeSet != null) {
                followeeSet.remove(followerId);
            }
        }
    }
}
