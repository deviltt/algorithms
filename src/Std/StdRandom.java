package Std;

import java.util.Random;

public class StdRandom {
    private static Random random;   //用于生成随机数
    private static long seed;   //一般使用系统时间作为种子

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    /**
     * 构造器私有化，防止外部类通过无参构造函数的方法创建该类的实例
     */
    private StdRandom() {
    }

    /**
     * 设置种子
     *
     * @param s the seed
     */
    public static void setSeed(long s) {
        seed = s;
        random = new Random(seed);
    }

    /**
     * 获取种子
     *
     * @return the seed
     */
    public static long getSeed() {
        return seed;
    }

    /**
     * 随机生成[0-1)之间的双精度随机数
     *
     * @return [0-1)
     */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     * 生成[0-n)之间的随机整数
     *
     * @param n 生成随机数的范围基数
     * @return 返回一个[0-n)之间的任意一个整数
     */
    public static int uniform(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument must be positive: " + n);
        }
        return random.nextInt(n);
    }

    /**
     * @return 返回[0-1)之间的任意一个双精度数
     */
    @Deprecated
    public static double random() {
        return uniform();
    }

    /**
     * @param a 左区间(包含)
     * @param b 右区间(不包含)
     * @return 返回[a, b)之间的随机整数
     */
    public static int uniform(int a, int b) {
        if (b <= a || (b - a >= Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("invalid range: [" + a + "," + b + ")");
        }
        return a + uniform(b - a);
    }

    public static double uniform(double a, double b) {
        if (!(a < b)) {
            throw new IllegalArgumentException("invalid range: [" + a + "," + b + ")");
        }
        return a + uniform() * (b - a);
    }

    /**
     * @param p 概率
     * @return 如果随机生成的数比设定的概率小，则返回真
     */
    public static boolean bernoulli(double p) {
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("probability p must be between 0.0 and 1.0: " + p);
        }
        return uniform() < p;
    }

    public static boolean bernoulli() {
        return bernoulli(0.5);
    }

    public static void shuffle(Object[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);  //随机数的范围在[i, n-1)
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(double[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);  //随机数的范围在[i, n-1)
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);  //随机数的范围在[i, n-1)
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(char[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);  //随机数的范围在[i, n-1)
            char temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * 对某一段进行随机排序
     *
     * @param a
     * @param lo
     * @param hi
     */
    public static void shuffle(Object[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);
        for (int i = lo; i < hi; i++) {
            int r = i + uniform(hi - i);    //在i和hi-1之间
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(double[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);
        for (int i = lo; i < hi; i++) {
            int r = i + uniform(hi - i);    //在i和hi-1之间
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);
        for (int i = lo; i < hi; i++) {
            int r = i + uniform(hi - i);    //在i和hi-1之间
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * 返回一个[0, n)之间的随机排列的数组
     *
     * @param n
     * @return
     */
    public static int[] permutation(int n) {
        if (n < 0) throw new IllegalArgumentException("argument is negative");
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        shuffle(perm);
        return perm;
    }



    private static void validateSubarrayIndices(int lo, int hi, int length) {
        if (lo < 0 || hi > length || lo > hi) {
            throw new IllegalArgumentException("subarray indices out of bounds: [" + lo + ", " + hi + ")");
        }
    }

    private static void validateNotNull(Object x) {
        if (x == null) {
            throw new IllegalArgumentException("argument is null");
        }
    }
}
