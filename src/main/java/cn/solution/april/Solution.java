package cn.solution.april;

/**
 * @author huangsy
 * @date 2021/4/1 8:37
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/clumsy-factorial/
     * @param N
     * @return
     */
    public int clumsy(int N) {

        int[] X = {1,2,2,-1};
        return N>4?N+X[N%4]:(N>2?N+3:N);
//        if (N==1) {
//            return 1;
//        }
//        if (N<=3) {
//            return N*(N-1);
//        }
//
//        return N*(N-1)/(N-2) + clumsy(N - 3, '-');
    }

    private int clumsy(int n, char symbol) {
        switch (symbol) {
            case '+':
                if (n<=1) {
                    return -n;
                }
                if (n>=3) {
                    return - n*(n-1)/(n-2) + clumsy(n-3, '-');
                }
                return - n*(n-1);
            default:
                if (n<=1) {
                    return n;
                }
                return n + clumsy(n-1, '+');
        }
    }

}
