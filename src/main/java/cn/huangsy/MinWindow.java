package cn.huangsy;

import java.util.Arrays;

public class MinWindow {

    public String minWindow(String s, String t) {

        int[] tArray = new int[64];
        int[] sArray = new int[64];
        for (int i = 0; i < t.length(); i++) {
            tArray[t.charAt(i)-'A'] ++;
        }

        int left = 0, right = -1;
        int[] minArray = new int[]{-1, s.length()+1};
        while (left <= s.length() -t.length()) {
            int flag = 0;
            while (flag<64) {
                if (sArray[flag] < tArray[flag]) {
                    break;
                }
                flag ++;
            }
            if (right - left + 1 < t.length()) {
                if (right < s.length()) {
                    sArray[s.charAt(++right)-'A']++;
                }
            } else if (right - left + 1 == t.length()) {
                if (flag==64) {
                    if (right - left < minArray[1]-minArray[0]) {
                        minArray[0] = left;
                        minArray[1] = right;
                    }
                    break;
                } else {
                    if (right + 1 < s.length()) {
                        sArray[s.charAt(++right)-'A']++;
                    } else {
                        sArray[s.charAt(left++)-'A']--;
                    }
                }
            } else {
                if (flag==64) {
                    if (right - left < minArray[1]-minArray[0]) {
                        minArray[0] = left;
                        minArray[1] = right;
                    }
                    sArray[s.charAt(left++)-'A']--;
                } else {
                    if (right + 1 < s.length()) {
                        sArray[s.charAt(++right)-'A']++;
                    } else {
                        sArray[s.charAt(left++)-'A']--;
                    }
                }
            }
        }
        return minArray[0] == -1 ? "" : s.substring(minArray[0], minArray[1] + 1);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow.minWindow("ab", "b"));
        System.out.println(minWindow.minWindow("ab", "a"));
        System.out.println(minWindow.minWindow("bbaac", "aba"));
    }
}
