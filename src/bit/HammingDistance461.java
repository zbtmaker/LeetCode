package bit;

/**
 * Created by Administrator on 2019\3\30 0030.
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        return HammingWeight.hammingWeightRight(num);
    }
}
