package cn.huangsy;

import java.util.Stack;

/**
 * @author huangsy
 * @date 2021/3/11 14:06
 */
public class Calculate {

    public static final char space = 32;
    public static final char add = 43;
    public static final char sub = 45;
    public static final char mul = 42;
    public static final char div = 47;

    public int calculate(String s) {

        Stack<String> stack = new Stack<String>();
        String number = "";
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == space) {
                continue;
            }
            if (c == add || c == sub) {
                if (!stack.isEmpty()) {
                    number = stack.pop().concat(number);
                }
                stack.push(number);
                number = "";
                stack.push(String.valueOf(c));
            } else if (c == mul || c == div) {
                String nextNumber = "";
                int j = i + 1;
                for (; j < chars.length; j++) {
                    char next = chars[j];
                    if (next == space) {
                        continue;
                    }
                    if (next == add || next == sub || next == mul || next == div) {
                        break;
                    } else {
                        nextNumber = nextNumber.concat(String.valueOf(next));
                    }

                }

                if (c == mul) {
                    number = String.valueOf(Integer.valueOf(number) * Integer.valueOf(nextNumber));
                } else {
                    number = String.valueOf(Integer.valueOf(number) / Integer.valueOf(nextNumber));
                }

                i = j - 1;

            } else {
                number = number.concat(String.valueOf(c));
            }

            if (i == chars.length - 1) {
                if (!stack.isEmpty()) {
                    number = stack.pop().concat(number);
                }
                stack.push(number);
            }
        }

        if (stack.empty()) {
            return Integer.valueOf(number);
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += Integer.parseInt(stack.pop());
        }
        return sum;
    }


    public int calculateN(String s) {

        char preCal = '+';
        Stack<Integer> stack = new Stack<Integer>();

        int number = 0;
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c > '/') {
                number = number * 10 + Integer.parseInt(String.valueOf(c));
            }

            if ((c != space && c < '0') || i == chars.length - 1) {
                switch (preCal) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }
                number = 0;
                preCal = c;
            }
        }



        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculateN(" 3+5 / 2 "));
        System.out.println(calculate.calculateN("3+2*2"));
        System.out.println(calculate.calculateN(" 3/2 "));
        System.out.println(calculate.calculateN("1 + 1"));
    }
}
