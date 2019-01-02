package com.tall.suanfa.dp;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by tlf on 2018/12/25.
 */

public class DPTest {


    @Test
    public void test() throws Exception {
        String x = "ABCCDDE";
        String y = "ACDDBAC";
      //  getLCS(x,y);



        String str="ababcabcbababcabacaba";
        String dest="ababcaba";
        int[] array=kmpNext(dest);
        for (int i : array) {
            System.out.print(i);
        }

        System.out.println();

        System.out.println(kmp(str,dest,array));
    }


    /**
     * 动态规划的思想
     * 斐波那契数列
     * 1 1 2 3 5 8 13 ·····
     *
     * @param n
     * @return
     */
    public static double f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {

            return f(n - 1) + f(n - 2);
        }

    }


    public static double f1(int n) {
        double[] array = new double[n];
        array[0] = 1;
        array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n - 1];


    }


    /**
     * LCS算法
     * 最长公共子序列
     */
    public static void getLCS(String x, String y) {

        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();

        int[][] array = new int[x.length() + 1][y.length() + 1];
        //先把第一行和第一列填0
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            array[i][0] = 0;
        }

        //使用动态规划的方式填入数据
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    //如果相等，左上角加1填入
                    array[i][j] = array[i - 1][j - 1] + 1;

                } else {
                    array[i][j] = max(array[i - 1][j], array[i][j - 1]);

                }

            }
        }

        //打印
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }

            System.out.println();
        }

        //从后往前找结果
        Stack result = new Stack();
        int i = x.length()-1;
        int j = y.length()-1;

        while ((i>=0)&&(j>=0)){

            if (s1[i]==s2[j]){
                result.push(s1[i]);
                i--;
                j--;
            }else {
                //注意数组和string中的位置有一位差
                if (array[i+1][j+1-1]>array[i+1-1][j+1]){

                    j--;
                }else {
                    i--;
                }

            }

        }
        System.out.println("---------------");

        while (!result.isEmpty()){
            System.out.println(result.pop()+" ");
        }



    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;

    }




    /**
     *KMP算法
     */
    public static int[] kmpNext(String dest){
        int[] next=new int[dest.length()];
        next[0]=0;
        //开始推出next
        for(int i=1,j=0;i<dest.length();i++){
            //3
            while(j>0 && dest.charAt(j) != dest.charAt(i)){
                j=next[j-1];
            }
            //1
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            //2
            next[i]=j;
        }
        return next;
    }


    public static int kmp(String str,String dest,int[] next){
        for(int i=0,j=0;i<str.length();i++){
            while(j>0 && str.charAt(i) != dest.charAt(j)){
                j=next[j-1];
            }
            if(str.charAt(i)==dest.charAt(j)){
                j++;
            }
            if(j==dest.length()){//结束
                return i-j+1;
            }
        }
        return 0;
    }

}
