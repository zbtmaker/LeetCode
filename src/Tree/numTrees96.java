package Tree;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class numTrees96 {
    public static void main(String[] args){
        int n = 4;
        int num = new numTrees96().numTrees(n);
        System.out.println(num);
    }

    /**
     * 这个问题虽然是一个树的生成问题，但是其实这个问题是一个动态规划问题，因为
     * 当我们的 n增加时，我们可以得到我们的n的通式为Num(n) = Num(i-1)* Num(n-i) + Num(i+1-1)*Num(n-i-1)....+Num(n-1)*Num(n-n)
     * 其实这个通项公式主要是通过归纳法总结出来的,对于n=3来说，主要是当123
     * 当1是root是后面的23有两个元素，有两种子树
     * 当2是root时，左子树为2，右子树为3，此时只有一种子树结构
     * 当3是root时，左子树为12，此时12可以得到两种子树结构
     * 综上所述，当n = 3时此时树的种类为所有可能中心节点的可能之和（2 + 1 + 2）
     * 当n = 4时，情况是一样的。此题主要是在草稿纸上画出所有的可能，就能归纳出后面的公式
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n <= 0){
            return 0;
        }
        int[] aux = new int[n+1];
        aux[0] = 1;
        for(int i = 1;i<=n;i++){
            for(int k = 1;k<=i;k++){
                aux[i] = aux[i] + aux[k-1] * aux[i - k];
            }
        }
        return aux[n];
    }
}
