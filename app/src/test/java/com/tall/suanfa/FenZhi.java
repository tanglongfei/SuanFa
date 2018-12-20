package com.tall.suanfa;

import org.junit.Test;

import java.util.TreeMap;

/**
 * 分治法
 * <p>
 * Created by tlf on 2018/12/19.
 */

public class FenZhi {

    @Test
    public void test() throws Exception {
        int[] array = new int[]{3, 4, 4, 44, 32, 21, 77, 88, 21};
        // int i = binarySearch(array, 9);
        //System.out.println(i);
        quickSort(array, 0, 8);
        for (int i : array) {
            System.out.println(i);

        }
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

    /**
     * 快速排序
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) return;
        int x = array[begin];
        int low = begin;
        int high = end;

        //由于会从两头取数据，需要一个方向
        boolean direction = true;
        L:
        while (low < high) {
            if (direction) {//从右往左找
                for (int i = high; i > low; i--) {
                    if (array[i] <= x) {
                        array[low++] = array[i];
                        high = i;
                        direction = !direction;
                        continue L;

                    }

                }
                //假如全程没有进入上方的if的话，指针重合
                high = low;

            } else {//从左往右找
                for (int i = low; i < high; i++) {
                    if (array[i] >= x) {
                        array[high--] = array[i];
                        low = i;
                        direction = !direction;
                        continue L;

                    }

                }
                //假如全程没有进入上方的if的话，指针重合
                low = high;

            }

        }

        array[low] = x;
        quickSort(array, begin, low - 1);
        quickSort(array, low + 1, end);


    }


    /**
     * 归并排序
     */
    public static void mergeSort(int array[],int left,int right){
        if(left==right){
            return;
        }else{
            int mid=(left+right)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid+1,right);
        }
    }

    /**
     * 归并算法
     * 1  2  5  9 === 3  4  10  11
     */
    public static void merge(int[] array,int left,int mid,int right){
        int leftSize=mid-left;
        int rightSize=right-mid+1;
        //生成数组
        int[] leftArray=new int[leftSize];
        int[] rightArray=new int[rightSize];
        //填充数据
        for(int i=left;i<mid;i++){
            leftArray[i-left]=array[i];
        }
        for(int i=mid;i<=right;i++){
            rightArray[i-mid]=array[i];
        }
        //合并
        int i=0;
        int j=0;
        int k=left;
        while(i<leftSize && j<rightSize){
            if(leftArray[i]<rightArray[j]){
                array[k]=leftArray[i];
                k++;i++;
            }else{
                array[k]=rightArray[j];
                k++;j++;
            }
        }
        while(i<leftSize){
            array[k]=leftArray[i];
            k++;i++;
        }
        while(j<rightSize){
            array[k]=rightArray[j];
            k++;j++;
        }
    }







}
