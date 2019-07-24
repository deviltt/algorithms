package chapter1;

import Std.StdIn;
import Std.StdOut;

import java.util.Arrays;

public class BinarySearch {
    /**
     * @param key 要查找的整数值
     * @param a   给定的数组
     * @return 返回key所在的索引位置
     */
    public static int rank(int key, int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[]{3, 2, 5, 8, 0, 1};
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index=rank(key, whitelist);
            if (index < 0)
                StdOut.println(key);
            else
                StdOut.println(index);
        }
    }
}
