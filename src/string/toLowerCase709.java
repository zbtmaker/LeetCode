package string;

import org.junit.Test;

/**
 * Created by Administrator on 2019\2\7 0007.
 */
public class toLowerCase709 {
    @Test
    public void test(){
        String str = new toLowerCase709().toLowerCase("Hello");
        System.out.println(str);


    }
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                sb.append((char)(str.charAt(i)+32));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
