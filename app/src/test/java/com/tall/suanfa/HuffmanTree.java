package com.tall.suanfa;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 哈夫曼树
 * Created by tlf on 2018/12/17.
 */

public class HuffmanTree {
    TreeNode root;

    /**
     * 创建哈夫曼树
     *
     * @param list
     * @return
     */
    public TreeNode createHuffManTree(ArrayList<TreeNode> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            TreeNode left = list.get(list.size() - 1);
            TreeNode right = list.get(list.size() - 2);
            TreeNode parent = new TreeNode("p", left.weight + right.weight);
            parent.leftChind = left;
            parent.rightChind = right;
            left.parent = parent;
            right.parent = parent;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }

        root = list.get(0);
        return list.get(0);


    }


    public void showHuffman(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        //linkedlist 使用add时作为list使用
        //使用offer pop 等时作为队列使用
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            System.out.println(node.data);
            if (node.leftChind != null) {
                list.offer(node.leftChind);
            }

            if (node.rightChind != null) {
                list.offer(node.rightChind);
            }

        }

    }


    @Test
    public void test() throws Exception {
        ArrayList<TreeNode> list = new ArrayList<>();

        TreeNode<String> node1 = new TreeNode<>("2", 2);
        TreeNode<String> node2 = new TreeNode<>("4", 4);
        TreeNode<String> node3 = new TreeNode<>("7", 7);
        TreeNode<String> node4 = new TreeNode<>("9", 9);
        TreeNode<String> node5 = new TreeNode<>("20", 20);
        TreeNode<String> node6 = new TreeNode<>("30", 30);
        TreeNode<String> node7 = new TreeNode<>("30", 30);
        TreeNode<String> node8 = new TreeNode<>("70", 70);

        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        list.add(node7);
        list.add(node8);
        HuffmanTree tree = new HuffmanTree();
        tree.createHuffManTree(list);
        System.out.println("----------------");
        System.out.println(tree.root.weight);
        System.out.println("----------------");
        tree.showHuffman(tree.root);
        System.out.println("----------------");

        getCode(node1);

    }

    /**
     * 编码
     *
     * @param node
     */
    public void getCode(TreeNode node) {
        TreeNode tNode = node;
        Stack<String> stack = new Stack<>();
        while (tNode != null && tNode.parent != null) {

            //left 0 right 1
            if (tNode.parent.leftChind == tNode) {
                stack.push("0");
            } else if (tNode.parent.rightChind == tNode) {
                stack.push("1");
            }

            tNode = tNode.parent;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


    public static class TreeNode<T> implements Comparable<TreeNode<T>> {
        T data;
        int weight;
        TreeNode leftChind;
        TreeNode rightChind;
        TreeNode parent;

        public TreeNode(T data, int weight) {
            this.data = data;
            this.weight = weight;
            leftChind = null;
            rightChind = null;
            parent = null;
        }

        @Override
        public int compareTo(@NonNull TreeNode<T> o) {
            if (this.weight > o.weight) {
                return -1;
            } else if (this.weight < o.weight) {
                return 1;
            }
            return 0;
        }
    }
}