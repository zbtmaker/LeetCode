package bit;


/**
 * @author baitao zou
 * date 2020/11/22
 */
public class ToHex405 {
    /**
     * 总移位次数
     */
    private static final int SHIFT_COUNT = 8;

    /**
     * 每次移位的比特位
     */
    private static final int SHIFT = 4;

    public String toHex(int num) {
        String[] hexArr = new String[SHIFT_COUNT];
        for (int i = 0; i < SHIFT_COUNT; i++) {
            hexArr[SHIFT_COUNT - i - 1] = toChar((num & 15));
            num >>>= SHIFT;
        }
        StringBuilder sb = new StringBuilder(SHIFT_COUNT);
        int j = 0;
        while (j < SHIFT_COUNT && hexArr[j].equals("0")) {
            j++;
        }
        for (int k = j; k < SHIFT_COUNT; k++) {
            sb.append(hexArr[k]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private String toChar(int num) {
        switch (num) {
            case 10:
                return "a";
            case 11:
                return "b";
            case 12:
                return "c";
            case 13:
                return "d";
            case 14:
                return "e";
            case 15:
                return "f";
            default:
                return String.valueOf(num);
        }
    }
}
