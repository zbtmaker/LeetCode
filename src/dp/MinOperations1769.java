package dp;

/**
 * @author Baitao Zou
 * date 2021/03/19
 */
public class MinOperations1769 {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        //用来统计左右两边需要移动的次数
        int[] leftArr = new int[len], rightArr = new int[len];
        //用来统计左右两边元素为1的个数
        int[] leftCount = new int[len], rightCount = new int[len];
        //最终结果
        int[] result = new int[len];
        leftCount[0] = (boxes.charAt(0) - '0');
        rightCount[len - 1] = (boxes.charAt(len - 1) - '0');
        //计算左边元素向右移动需要移动的次数
        for (int i = 1; i < len; i++) {
            int ch = boxes.charAt(i) - '0';
            leftCount[i] = leftCount[i - 1] + ch;
            leftArr[i] = leftCount[i - 1] + leftArr[i - 1];
        }
        //计算右边元素移动需要移动的次数
        for (int j = len - 2; j > -1; j--) {
            int ch = boxes.charAt(j) - '0';
            rightCount[j] = rightCount[j + 1] + ch;
            rightArr[j] = rightArr[j + 1] + rightCount[j + 1];
        }
        result[0] = rightArr[0];
        result[len - 1] = leftArr[len - 1];
        //对于每一个1 ≤ k ≤ len-2,左边移动的次数+右边移动的次数
        for (int k = 1; k < len - 1; k++) {
            result[k] = leftArr[k] + rightArr[k];
        }
        return result;
    }
}
