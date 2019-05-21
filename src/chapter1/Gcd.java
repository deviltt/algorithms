package chapter1;

/**
 * 求两个整数的最大公约数
 */
public class Gcd {
    private static int gcd(int p, int q) {
        if (p < 0 || q < 0)
            return -1;
        while (p % q != 0) {
            int temp = p % q;
            p = q;
            q = temp;
        }
        return q;
    }

    /**
     * 用递归的方法寻找两个非负整数的最大公约数
     *
     * @param p
     * @param q
     * @return
     */
    private static int EuclidGcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return EuclidGcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println(EuclidGcd(24,32));
    }
}
