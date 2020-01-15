package string;

public class CountAndSay38 {
    private String initialStr = "1";

    public String countAndSay(int n) {
        if (n == 1) {
            return initialStr;
        }
        for (int i = 1; i < n; i++) {

            int count = 1;
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < initialStr.length()) {
                char start = initialStr.charAt(j);
                int k = j + 1;
                while (k < initialStr.length() && initialStr.charAt(k) == start) {
                    count++;
                    k++;
                }
                sb.append(count).append(start);
                count = 1;
                j = k;
            }
            initialStr = sb.toString();
        }
        return initialStr;
    }

}
