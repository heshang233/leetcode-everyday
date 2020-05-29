package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/5/28 8:40
 */
public class DecodeString {

    public static final char start = '[';
    public static final char end = ']';
    public int i = 0;

    public String decodeString(String s) {
        return decode(s.toCharArray());
    }

    private String decode(char[] chars) {
        String x = "";
        while (true && i < chars.length) {
            if (chars[i] <= 47 || chars[i] >= 58) {
                if (chars[i] == start) {
                    int n = getNumber(chars, i-1);
                    i ++;
                    String m = decode(chars);
                    for (int j = 0; j < n; j++) {
                        x = x.concat(m);
                    }
                } else if (chars[i] == end) {
                    break;
                } else {
                    x = x.concat(Character.toString(chars[i]));
                }
            }
            i++;
        }
        return x;
    }

    private int getNumber(char[] chars, int i) {
        int n = 0;
        int w = 1;
        while (i >= 0 && chars[i] > 47 && chars[i] < 58) {
            n += (chars[i] - 48 )* w;
            i--;
            w *= 10;
        }
        return n;
    }

    public static void main(String[] args) {
        /**
         * s = "3[a]2[bc]", 返回 "aaabcbc".
         * s = "3[a2[c]]", 返回 "accaccacc".
         * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
         */
        DecodeString decodeString = new DecodeString();
//        System.out.println(decodeString.decodeString("3[a]2[bc]"));
//        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
