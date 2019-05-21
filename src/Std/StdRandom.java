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
     * @param s the seed
     */
    public static void setSeed(long s) {
        seed = s;
        random = new Random(seed);
    }

    /**
     * 获取种子
     * @return the seed
     */
    public static long getSeed(){
        return seed;
    }

    /**
     *  随机生成[0-1)之间的双精度随机数
     * @return [0-1)
     */
    public static double uniform(){
        return random.nextDouble();
    }

    /**
     *  生成[0-n)之间的随机整数
     * @param n 生成随机数的范围基数
     * @return 返回一个[0-n)之间的任意一个整数
     */
    public static int uniform(int n){
        if (n<=0){
            throw new IllegalArgumentException("argument must be positive: "+n);
        }
        return random.nextInt(n);
    }

    /**
     *
     * @return 返回[0-1)之间的任意一个双精度数
     */
    public static double random(){
        return uniform();
    }
}
