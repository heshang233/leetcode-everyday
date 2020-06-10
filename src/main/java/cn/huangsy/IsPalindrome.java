package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/6/10 9:09
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x<0 || (x%10 == 0 && x!=0)) {
            return false;
        }
        int m = 0;
        while (x>m) {
            m = m*10 + (x % 10);
            x = x / 10;
        }
        return m == x || m/10 == x;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(-121));
        System.out.println(isPalindrome.isPalindrome(121));
        System.out.println(isPalindrome.isPalindrome(10));
        System.out.println(isPalindrome.isPalindrome(1032301));
        System.out.println(isPalindrome.isPalindrome(1112011));
        System.out.println(isPalindrome.isPalindrome(0));

    }
}
