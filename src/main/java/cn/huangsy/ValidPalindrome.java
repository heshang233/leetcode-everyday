package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/5/19 8:35
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] == chars[j]) {
                i ++;
                j --;
                continue;
            }
            return isValid(chars, i, j - 1) || isValid(chars, i + 1, j);
        }
        return true;
    }

    private boolean isValid(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] == chars[j]) {
                i ++;
                j --;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(validPalindrome.validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println(validPalindrome.validPalindrome("deeee"));
    }
}
