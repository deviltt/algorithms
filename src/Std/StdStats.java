package Std;

/**
 * 还差几个关于StdDraw的方法
 */
public final class StdStats {
    private StdStats() {
    }

    public static double max(double[] a) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (Double.isNaN(a[i])) {   //如果是一个非数值
                return Double.NaN;
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static double max(double[] a, int lo, int hi) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = lo; i < hi; i++) {
            if (Double.isNaN(a[i])) {
                return Double.NaN;
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static double min(double[] a) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (Double.isNaN(a[i])) {   //如果是一个非数值
                return Double.NaN;
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }


    public static double min(double[] a, int lo, int hi) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = lo; i < hi; i++) {
            if (Double.isNaN(a[i])) {
                return Double.NaN;
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static int min(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static double mean(double[] a) {
        if (a.length == 0) {
            return Double.NaN;
        }
        double sum = sum(a);
        return sum / a.length;
    }

    public static double mean(double[] a, int lo, int hi) {
        int length = hi - lo;
        if (length == 0) {
            return Double.NaN;
        }

        double sum = sum(a, lo, hi);
        return sum / length;
    }

    public static double mean(int[] a) {
        if (a.length == 0) {
            return Double.NaN;
        }
        int sum = sum(a);
        return 1.0 * sum / a.length;
    }

    /**
     * 方差计算公式
     *
     * @param a
     * @return
     */
    public static double var(double[] a) {
        if (a.length == 0) {
            return Double.NaN;
        }
        double avg = mean(a);
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (a.length - 1);
    }

    public static double var(double[] a, int lo, int hi) {
        int length = hi - lo;
        if (length == 0) {
            return Double.NaN;
        }
        double avg = mean(a, lo, hi);
        double sum = 0;
        for (int i = lo; i < hi; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (length - 1);
    }

    public static double var(int[] a) {
        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (a.length - 1);
    }


    public static double varp(double[] a) {
        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / a.length;
    }

    public static double varp(double[] a, int lo, int hi) {
        int length = hi - lo;
        if (length == 0) return Double.NaN;

        double avg = mean(a, lo, hi);
        double sum = 0.0;
        for (int i = lo; i < hi; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / length;
    }

    public static double stddev(double[] a) {
        return Math.sqrt(var(a));
    }

    public static double stddev(int[] a) {
        return Math.sqrt(var(a));
    }

    public static double stddev(double[] a, int lo, int hi) {
        return Math.sqrt(var(a, lo, hi));
    }

    public static double stddevp(double[] a) {
        return Math.sqrt(varp(a));
    }

    public static double stddevp(double[] a, int lo, int hi) {
        return Math.sqrt(varp(a, lo, hi));
    }

    private static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    private static double sum(double[] a, int lo, int hi) {
        double sum = 0;
        for (int i = lo; i < hi; i++) {
            sum += a[i];
        }
        return sum;
    }

    private static double sum(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }


}
