package cn.leetcode.`974`

/**
 * @author huangsy
 * @date 2020/5/27 8:36
 */
class SubarraysDivByK {

    /*
    方法：前缀和
    假设 M = SUM[0,m], N = SUM[0,n] & m>n
    M-N % K == 0 可推导出 abs(M%K) == abs(N%K)
    则 SUM(n,m] % K == 0

    设 MOD(m) = abs(M%K)
    则 MOD(m+1) = abs( abs(M%K) + A(m+1) % K)
     */
    fun subarraysDivByK(A: IntArray, K: Int): Int {
        val m = IntArray(K)
        m[0] = 1
        var max = 0
        var mod = 0
        for (i in A) {
            mod = ((mod + i) % K + K) % K
            max += m[mod]
            m[mod]++
        }
        return max
    }
}