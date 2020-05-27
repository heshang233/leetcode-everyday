package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/5/27 8:36
 */
public class SubarraysDivByK {
    /*
    方法：前缀和
    假设 M = SUM[0,m], N = SUM[0,n] & m>n
    M-N % K == 0 可推导出 abs(M%K) == abs(N%K)
    则 SUM(n,m] % K == 0

    设 MOD(m) = abs(M%K)
    则 MOD(m+1) = abs( abs(M%K) + A(m+1) % K)
     */

    public int subarraysDivByK(int[] A, int K) {
        int[] m = new int[K];
        m[0] = 1;
        int max = 0;
        int mod = 0;
        for (int i : A) {
            mod = ((mod + i) % K + K ) % K;
            max += m[mod];
            m[mod] ++ ;
        }
        return max;
    }

    public static void main(String[] args) {
        SubarraysDivByK subarraysDivByK = new SubarraysDivByK();
        System.out.println(subarraysDivByK.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
