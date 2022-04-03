package string;


/**
 * @author zoubaitao
 * date 2022/04/03
 */
public class ReverseWords557 {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < strArr.length; i++) {
            String str = StringUtils.reverse(strArr[i]);
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}
