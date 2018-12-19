package com.tall.suanfa;

import org.junit.Test;

/**
 * 分治法
 * <p>
 * Created by tlf on 2018/12/19.
 */

public class FenZhi {

    @Test
    public void test() throws Exception {
        int[] array = new int[]{1, 2, 4, 5, 6, 7, 8, 9};
        int i = binarySearch(array, 9);
        System.out.println(i);
    }


    /**
     * 二分查找
     * 必须是排好序的组
     */
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (key < midVal) {//取左边
                high = mid - 1;
            } else if (key > midVal) {//取右边
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }






}
