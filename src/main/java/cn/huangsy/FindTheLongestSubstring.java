package cn.huangsy;

import java.util.Arrays;

/**
 * @author huangsy
 * @date 2020/5/20 8:49
 */
public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        int[] x = new int[128];
        x['a'] = 1;
        x['e'] = 2;
        x['i'] = 4;
        x['o'] = 8;
        x['u'] = 16;

        int[] n = new int[32];
        Arrays.fill(n, -1);
        n[0] = 0;
        int m = 0,t = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            t ^= x[chars[i]];
            if (n[t] == -1) {
                n[t] = i + 1;
            } else {
                m = Math.max(m, i + 1 - n[t]);
            }

        }
        return m;
    }

    public static void main(String[] args) {
        FindTheLongestSubstring findTheLongestSubstring = new FindTheLongestSubstring();
        System.out.println(findTheLongestSubstring.findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(findTheLongestSubstring.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(findTheLongestSubstring.findTheLongestSubstring("bcbcbc"));
    }

}
