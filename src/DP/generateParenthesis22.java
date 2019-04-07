package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\11 0011.
 */
public class generateParenthesis22 {
    public static void main(String[] args){
        List<String> list = new generateParenthesis22().generateParenthesis(3);
        for(String str : list){
            System.out.println(str);
        }
    }
    /**
     *
     * 之前使用回溯的方式行不通，主要是没有找对回溯中的范式，下面我们使用DP的方式来解决，其实这里可以使用递归的方式来解决，
     * 因为这个题目使用while循环会好些。
     * 我们从下往上进行分析；
     * 当n = 1 时 : ()
     * 当n = 2 时 : (())  ()()
     * 当n = 3 时 : ((()))  (())()
     *              (())()  (()())
     *              ()(())
     *              ()()()
     * 从上面的结构来看，其实3的结果依赖2的结果，因此这样我们采用自底向上的方式逐步的求解，首先我们
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        if(n <= 0){
            return result;
        }
        List<List<String>> lists = new ArrayList<>();
        List<String> tmpArray = new ArrayList<>();
        tmpArray.add("()");
        lists.add(tmpArray);
        for(int i = 2;i <= n;i ++){
            List<List<String>> tmpLists = new ArrayList<>();
            for(int j = 0;j < lists.size();j++){
                List<String> list = lists.get(j);
                for(int m = 0;m<list.size();m ++){
                    for(int k = m;k < list.size();k ++){
                        List<String> tmpList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for(int l = 0;l < list.size();l ++){
                            if(l < m || l > k){
                                tmpList.add(list.get(l));
                            }else if(l == m && l == k){
                                sb.append('(').append(list.get(l)).append(')');
                                tmpList.add(sb.toString());
                            }else if(l == m){
                                sb.append('(').append(list.get(l));
                            }else if(l == k){
                                sb.append(list.get(l)).append(')');
                                tmpList.add(sb.toString());
                            }
                        }
                        tmpLists.add(tmpList);
                    }
                }
                list.add("()");
                tmpLists.add(new ArrayList<>(list));
            }
            lists = tmpLists;
        }

        for(List<String> tmp : lists){
            StringBuilder sb = new StringBuilder();
            for(String str : tmp){
                sb.append(str);
            }
            result.add(sb.toString());
        }
        return result;
    }



    private void append(LinkedList<String> list,List<String> result){
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        result.add(sb.toString());
    }
}
