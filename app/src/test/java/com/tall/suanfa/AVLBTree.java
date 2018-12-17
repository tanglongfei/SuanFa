package com.tall.suanfa;

/**
 * 平衡二叉树
 * Created by tlf on 2018/12/17.
 */

public class AVLBTree<E extends Comparable<E>> {

    Node<E> root;
    int size;

    /**
     * 结点
     *
     * @param <E>
     */
    public class Node<E extends Comparable<E>> {
        E element;
        int balance = 0;//平衡因子
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    /**
     * 左旋
     *
     * @param x 根结点
     */
    public void left_rotate(Node<E> x) {
        if (x != null) {
            //先取到Y
            Node<E> y = x.right;
            //1.把y的左孩子变成x的右孩子
            x.right = y.left;

            if (y.left != null) {
                y.left.parent = x;
            }
            //2.把y移到x的位置
            y.parent = x.parent;
            if (x.parent == null) {
                root = y;
            } else {
                if (x.parent.left == x) {
                    x.parent.left = y;
                } else if (x.parent.right == x) {
                    x.parent.right = y;
                }
            }
            //3.x作为y的左孩子
            y.left = x;
            x.parent = y;

        }
    }

    /**
     * 右旋
     * @param y 根结点
     */
    public void right_rotate(Node<E> y) {

        if (y != null) {
            //先取到x
            Node<E> x = y.left;
            //1.将x的右孩子变成y的左孩子
            y.left = x.right;
            if (x.right != null) {
                x.right.parent = y;
            }
            //2.将x移到y的位置
            x.parent = y.parent;
            if (y.parent == null) {
                root = x;

            } else {
                if (y.parent.left == y) {
                    y.parent.left = x;
                } else if (y.parent.right == y) {
                    y.parent.right = x;
                }
            }
            x.right = y;
            y.parent = x;

        }
    }


}
