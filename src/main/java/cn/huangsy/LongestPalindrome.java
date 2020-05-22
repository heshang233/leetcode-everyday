package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/5/21 8:34
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length()<2) {
            return s;
        }
        char[] chars = s.toCharArray();

        int maxlength = 1;
        int maxstart = 0;
        for (int i = 1; i < chars.length-1; i++) {

            int m = i-1;
            int n = i+1;
            while (m>=0 && n<chars.length && chars[m] == chars[n]) {
                maxlength = Math.max(maxlength, n-m+1);
                m --;
                n ++;
            }

            if (m!=i-1 && n!=i+1 && maxlength<= n-m-1) {
                maxstart = m+1;
            }

            m = i;
            n = i+1;
            while (m>=0 && n<chars.length && chars[m] == chars[n]) {
                maxlength = Math.max(maxlength, n-m+1);
                m --;
                n ++;
            }
            if (m!=i && n!=i+1 && maxlength<= n-m-1) {
                maxstart = m+1;
            }
        }

        return s.substring(maxstart, maxstart + maxlength);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("cbbd"));
        System.out.println(longestPalindrome.longestPalindrome("ccc"));
    }
}
