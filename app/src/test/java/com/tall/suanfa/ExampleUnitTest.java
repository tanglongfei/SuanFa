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
     * 二叉排序树测试
     */
    @Test
    public void SearchTest() throws Exception {

        SearchBinaryTree tree = new SearchBinaryTree();
        tree.put(2);
        tree.put(1);
        tree.put(4);
        tree.put(5);
        tree.put(3);
        tree.put(9);
        tree.put(8);



        SearchBinaryTree.TreeNode node = tree.searchNode(9);
        tree.delNode(node);
        tree.midOrderTraverse(tree.root);
    }

    /**
     * 平衡二叉树测试
     */
    @Test
    public void AVLBTest() throws Exception {
        AVLBTree tree = new AVLBTree();

        tree.insertElement(3);
        tree.insertElement(2);
        tree.insertElement(5);
        tree.insertElement(4);
        tree.insertElement(7);
        tree.insertElement(6);


        tree.showAVL(tree.root);
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