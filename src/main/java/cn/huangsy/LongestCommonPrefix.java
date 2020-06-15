package cn.huangsy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @author huangsy
 * @date 2020/6/15 9:10
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }

        Vector<Character> vector = new Vector<Character>();
        for (char c : strs[0].toCharArray()) {
            vector.add(c);
        }
        for (int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int j = 0;
            while (j < vector.size()) {
                if (j >= chars.length || chars[j] != vector.get(j)) {
                    while (j < vector.size()) {
                        vector.remove(j);
                    }
                    break;
                }
                j++;
            }
        }

        for (int i = 0; i < vector.size(); i++) {
            result = result.concat(vector.get(i).toString());
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"aa","a"}));
    }
}
