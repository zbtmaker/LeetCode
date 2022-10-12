package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/10/10
 */
public class CanReach1871 {

    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if (s.charAt(len - 1) != '0') {
            return false;
        }

        List<Integer> zeroIndexes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                zeroIndexes.add(i);
            }
        }

        return dfs(zeroIndexes, minJump, maxJump, len - 1);
    }

    /**
     * 这个题目的难题在于什么时候更新最小指针问题，最大指针这个好办，最大指针永远
     * 都可以取最大的，但是最小指针
     *
     * @param zeroIndexes
     * @param minJump
     * @param maxJump
     * @param target
     * @return
     */
    private boolean dfs(List<Integer> zeroIndexes, int minJump, int maxJump, int target) {
        int minIndex = minJump, maxIndex = maxJump;
        for (int i = 1; i < zeroIndexes.size(); i++) {
            if (minIndex <= target && maxIndex >= target) {
                return true;
            }
            int zeroIndex = zeroIndexes.get(i);
            if (minIndex <= zeroIndex && maxIndex >= zeroIndex) {
                if (minIndex <= zeroIndex + 1 && zeroIndex + 1 <= maxIndex) {
                    minIndex = zeroIndex + 1;
                } else {
                    minIndex = zeroIndex + minJump;
                }

                int nextMaxIndex = zeroIndex + maxJump;
                maxIndex = Math.max(maxIndex, nextMaxIndex);
            }

        }
        return minIndex <= target && minIndex >= target;
    }

    private boolean window(String s, int minJump, int maxJump) {
        int left = 0, right = 0,len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if(i > right ) {
                return false;
            }
            if(s.charAt(i) == '0') {
                right = i + maxJump;
                left = i + 1;
            }

        }
        return left <= len - 1 && right >= len - 1;
    }
}
