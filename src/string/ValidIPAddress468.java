package string;

/**
 * @author zoubaitao
 * date 2022/03/09
 */
public class ValidIPAddress468 {

    public String validIPAddress(String queryIP) {
        String[] addr = queryIP.split("\\.");
        if (addr.length == 4 && queryIP.charAt(queryIP.length() - 1) != '.') {
            return parseIPv4(addr) ? "IPv4" : "Neither";
        }
        addr = queryIP.split(":");
        if (addr.length == 8 && queryIP.charAt(queryIP.length() - 1) != ':') {
            return parseIPv6(addr) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    private boolean parseIPv4(String[] addr) {
        for (String s : addr) {
            if (s.length() == 0 || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1)) {
                return false;
            }
            int res = 0;
            for (char ch : s.toCharArray()) {
                if (ch < '0' || ch > '9') {
                    return false;
                }
                res = res * 10 + (ch - '0');
            }
            if (res > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean parseIPv6(String[] addr) {
        for (String s : addr) {
            if (s.length() == 0 || s.length() > 4) {
                return false;
            }
            for (char ch : s.toCharArray()) {
                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
