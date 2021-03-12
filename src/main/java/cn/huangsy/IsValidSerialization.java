package cn.huangsy;

import java.util.Stack;

/**
 * @author huangsy
 * @date 2021/3/12 8:43
 */
public class IsValidSerialization {

    public boolean isValidSerialization(String preorder) {


        for (String s : preorder.split(",")) {
            if (s.equals("#")) {

            }
        }

        if (preorder.toCharArray().length < 5) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        boolean left = true;
        for (char c : preorder.toCharArray()) {
            if (c == ',') {
                continue;
            }

            if (c == '#') {
                if (left) {
                    left = false;
                    continue;
                } else {
                    if (stack.empty()) {
                        return false;
                    }

                }
            } else {
                stack.push(c);
            }
        }


        return false;
    }
}
