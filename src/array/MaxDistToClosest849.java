package array;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class MaxDistToClosest849 {
    public int maxDistToClosest(int[] seats) {
        return byAuxArray(seats);
    }

    private int byBruteForce(int[] seats) {
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int left = i - 1;
                int right = i + 1;
                int distance = 1;
                if (i == 0) {
                    while (right < seats.length) {
                        if (seats[right] == 1) {
                            break;
                        }
                        distance++;
                        right++;
                    }
                } else if (i == seats.length - 1) {
                    while (left < seats.length) {
                        if (seats[left] == 1) {
                            break;
                        }
                        distance++;
                        left--;
                    }
                } else {
                    while (left >= 0 && right < seats.length) {
                        if (seats[left] == 1 || seats[right] == 1) {
                            break;
                        }
                        distance++;
                        left--;
                        right++;
                    }
                }

                if (distance > max) {
                    max = distance;
                }
            }
        }
        return max;
    }

    /**
     * 通过两个辅助数组解决这个问题，一个leftArr记录当前节点到左边1的距离，
     * 一个rightArr记录节点到右边1的距离。最后遍历一遍leftArr和rightArr
     * 最终得出结论。注意边界条件处理
     *
     * @return
     */
    private int byAuxArray(int[] seats) {
        int len = seats.length;
        int[] leftArr = new int[len], rightArr = new int[len];
        // 计算leftArr;
        int leftOneIndex = -1;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                leftOneIndex = i;
                continue;
            }
            leftArr[i] = i - leftOneIndex;
        }

        // 计算rightArr
        int rightOneIndex = len;
        for (int j = len - 1; j > -1; j--) {
            if (seats[j] == 1) {
                rightOneIndex = j;
                continue;
            }
            rightArr[j] = rightOneIndex - j;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                continue;
            }
            if (i == 0) {
                max = Math.max(rightArr[i], max);
            } else if (i == len - 1) {
                max = Math.max(leftArr[i], max);
            } else {
                max = Math.max(Math.min(rightArr[i], leftArr[i]), max);
            }
        }
        return max;
    }

}
