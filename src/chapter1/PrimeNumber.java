package chapter1;

public class PrimeNumber {
    /**
     * 判断一个整数是否是素数（除了1和本身以外，不能被其它数整除）
     * @param N
     * @return
     */
    public static boolean isPrime(int N) {
        if (N < 2)
            return false;
        for (int i = 2; i * i <= N; i++) {
            if (N % 2 == 0)
                return false;
        }
        return true;
    }
}
