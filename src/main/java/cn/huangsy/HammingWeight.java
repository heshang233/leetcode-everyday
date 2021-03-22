package cn.huangsy;

/**
 * @author huangsy
 * @date 2021/3/22 15:57
 */
public class HammingWeight {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n == 0) {
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
