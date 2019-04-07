package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\9 0009.
 */
public class CompareVersionNumbers165 {
    public static void main(String[] args){
        String version1 = "1.0";
        String version2 = "1.0.0";
        /*List<String> list = new CompareVersionNumbers165().split(version1);
        System.out.println(list);*/
        int i = new CompareVersionNumbers165().compareVersion(version1,version2);
        System.out.println(i);
    }
    /**
     * 借助String中的split方法以及Integer的parseInt方法，以及String中的compareTo方法
     * 的思路。
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        List<String> strs1 = split(version1);
        List<String> strs2 = split(version2);
        int len1 = strs1.size();
        int len2 = strs2.size();

        int lim = Math.min(len1,len2);
        int k = 0;
        while(k<lim){
            int num1 = Integer.parseInt(strs1.get(k));
            int num2 = Integer.parseInt(strs2.get(k));
            if(num1 != num2){
                return num1 < num2 ? -1 : 1;
            }
            k++;
        }
        if(len1 > len2){
            while(k<len1){
                int num1 = Integer.parseInt(strs1.get(k));
                if(num1 > 0){
                    return 1;
                }
                k++;
            }

        }else if(len2 > len1){
            while(k < len2){
                int num2 = Integer.parseInt(strs2.get(k));
                if(num2 > 0){
                    return -1;
                }
                k++;
            }

        }
        return 0;
    }

    /**
     * 不知道为什么String的split方法不能实现split(".")，因此自己实现了一个
     * @param str
     * @return
     */
    private List<String> split(String str){
        List<String> list = new ArrayList<String>();
        int from = 0;
        int i = 0;
        while(i<str.length()){
            if(str.charAt(i) == '.'){
                list.add(str.substring(from,i));
                from = i + 1;
            }
            i++;
        }
        list.add(str.substring(from,i));
        return list;
    }
}
