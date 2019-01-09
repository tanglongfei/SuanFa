package com.tall.suanfa.graph;

import org.junit.*;
import org.junit.Test;

/**
 * 图论相关算法
 * Created by tlf on 2019/1/2.
 */

public class SuanFa {

    public static final int I = 100;
    public static int[][] d = new int[][]{
            {0, 2, 1, 5},
            {2, 0, 4, I},
            {1, 4, 0, 3},
            {5, I, 3, 0}
    };

    public static int[][] p = new int[][]{
            {0, 1, 2, 3},
            {0, 1, 2, 3},
            {0, 1, 2, 3},
            {0, 1, 2, 3}
    };

    @Test
    public void test() throws Exception {
        floyd();

        printArray(p);
        printShortPath();
    }


    /**
     * Floyd算法（弗洛伊德）
     * 用于计算有权节点之间的最短路径
     * 三层循环，里面两层为遍历二维数组，最外面一层为遍历支点
     */
    public static void floyd() {
        for (int k = 0; k < d.length; k++) {
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d.length; j++) {
                    if (d[i][j]>d[i][k]+d[k][j]){

                        d[i][j] = d[i][k]+d[k][j];
                        //记录路径
                        p[i][j] = p[i][k];
                    }
                }

            }


        }

    }


    /**
     * 打印邻接矩阵
     *
     * @param array
     */
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println("----------------------");


    }

    /**
     * 绘制路径
     */
    public static void printShortPath(){
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                System.out.println("V"+i+"->V"+j+" weight:"+d[i][j]+" path:"+i);
                int k=p[i][j];//取到当前位置是第几次推出来的
                while(k!=j){
                    System.out.println("->"+k);
                    k=p[k][j];
                }
                System.out.println();
            }
        }
    }

}
