package com.tall.suanfa;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        int[] array = new int[]{1, 3, 5, 2, 8, 6, 4, 5, 99, 2};
      //  bubbleSort(array);
        selectSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }


    /**
     * 冒泡
     *
     * @param array
     */
    public void bubbleSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;

                }

            }
            if (flag) {
                break;
            }
        }

    }

    /**
     * 麻将对象使用冒泡排序
     *
     * @param array
     */
    public void bubbleSort(Cards[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if ((array[j + 1].compareTo(array[j]) > 1)) {
                    Cards temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;

                }

            }
            if (flag) {
                break;
            }
        }

    }

    /**
     * 选择排序
     *
     * @param array
     */
    public void selectSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }

        }

    }


}