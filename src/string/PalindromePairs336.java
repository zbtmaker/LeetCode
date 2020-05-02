package string;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/05/01
 */
public class PalindromePairs336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length <= 1) {
            return new LinkedList<>();
        }
        return palindromePairsBySuffixAndPrefix(words);
    }

    /**
     * 暴力算法解决问题，每次都采用拼接的方式将字符串拼接到一起之后再判断这个字符
     * 是否是回文。这种方式的time complexity O(N^3)。空间复杂度为O(1)。提交的时候
     * 发现时间超了。需要优化的是时间复杂度，我们可以将时间复杂度优化到O(N^2)
     *
     * @param words
     * @return
     */
    private List<List<Integer>> palindromePairsByBruteForce(String[] words) {
        List<List<Integer>> palindromePairs = new LinkedList<>();
        List<Integer> palindromePair;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isPalindrome(words[i] + words[j])) {
                    palindromePair = new LinkedList<>();
                    palindromePair.add(i);
                    palindromePair.add(j);
                    palindromePairs.add(palindromePair);
                }
            }
        }
        return palindromePairs;
    }

    /**
     * 判断字符串是否是回文
     *
     * @param str
     * @return
     */
    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 参考官网文章：https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode/
     * 1、如果我们将word翻转之后能够在words找到一个word的翻转后的字符reverseWord，那么这两个字符互为回文对。
     * 2、找到每一个字符的前缀和后缀，假设字符串的字符为"exempt"，"xempt"是一个有效的前缀，"mpt"则是一个有效的也是一个有效的前缀。从我们的理解来说可能这个
     * 更像是一个后缀，但是我们是将这个字符串翻转之后，"e"是回文字符串，那么如果我们能够在剩余的字符串中找到"xempt"那么我们就可以将这个前缀"tmpxe"和回文"e"以后"exmpt"组成
     * 回文串。如果给定一个字符串,发现0,i是回文，那么此时我们将i + 1，word.length-1的字符串定义为回文后缀反转之后就能组成一个回文对。
     *
     * @param words
     * @return
     */
    private List<List<Integer>> palindromePairsBySuffixAndPrefix(String[] words) {
        List<List<Integer>> palindromePairs = new LinkedList<>();
        Map<String, Integer> wordMapIndex = new HashMap<>(words.length);

        for (int i = 0; i < words.length; i++) {
            wordMapIndex.put(words[i], i);
        }
        for (String word : words) {
            //1、判断反转字符串是否存在words数组中
            String reverseWord = new StringBuilder(word).reverse().toString();
            Integer wordIndex = wordMapIndex.get(word);
            Integer reverseWordIndex = wordMapIndex.get(reverseWord);
            if (wordMapIndex.containsKey(reverseWord)
                    && !wordIndex.equals(reverseWordIndex)) {
                palindromePairs.add(Arrays.asList(wordIndex, wordIndex));
            }

            //2、判断后缀是否存在与字符数组words中
            List<String> suffixWords = suffixWords(word);
            for (String suffixWord : suffixWords) {
                Integer suffixWordIndex = wordMapIndex.get(new StringBuilder(suffixWord).reverse().toString());
                if (suffixWordIndex != null) {
                    palindromePairs.add(Arrays.asList(suffixWordIndex, wordIndex));
                }
            }

            //3、判断前缀是否存在于字符数组words中
            List<String> prefixWords = prefixWords(word);
            for (String prefixWord : prefixWords) {
                Integer prefixWordIndex = wordMapIndex.get(new StringBuilder(prefixWord).reverse().toString());
                if (prefixWordIndex != null) {
                    palindromePairs.add(Arrays.asList(wordIndex, prefixWordIndex));
                }
            }

        }
        return palindromePairs;
    }

    private List<String> prefixWords(String word) {
        List<String> prefix = new LinkedList<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (isPalindrome(word, i, len - 1)) {
                prefix.add(word.substring(0, i));
            }
        }
        return prefix;
    }

    private List<String> suffixWords(String word) {
        List<String> suffix = new LinkedList<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (isPalindrome(word, 0, i)) {
                suffix.add(word.substring(i + 1));
            }
        }
        return suffix;
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
