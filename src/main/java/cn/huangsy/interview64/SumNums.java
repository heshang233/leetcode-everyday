package cn.huangsy.interview64;

/**
 * @author huangsy
 * @date 2020/6/2 8:45
 */
public class SumNums {

    public int sumNums(int n) {
        int sum = n;
        boolean flag = n>0 && (sum+=sumNums(n-1)) >0;
        return sum;
    }
}
