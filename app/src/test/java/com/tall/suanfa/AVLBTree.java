package com.tall.suanfa;


import java.util.LinkedList;

/**
 * 平衡二叉树
 * Created by tlf on 2018/12/17.
 */

public class AVLBTree<E extends Comparable<E>> {

    Node<E> root;
    int size = 0;
    private static final int LH = 1;
    private static final int RH = -1;
    private static final int EH = 0;


    /**
     * 左旋
     *
     * @param x 根结点
     */
    private void left_rotate(Node<E> x) {
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
     *
     * @param y 根结点
     */
    private void right_rotate(Node<E> y) {

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

    /**
     * 左平衡
     * 节点t的不平衡是因为左子树过深
     */
    private void leftBalance(Node<E> t) {
        Node<E> tl = t.left;
        switch (tl.balance) {
            case LH://如果插入的是左孩子的左子树，直接右旋
                right_rotate(t);
                tl.balance = EH;
                t.balance = EH;
                break;
            case RH://如果插入的是左孩子的右子树
                Node<E> tlr = tl.right;
                switch (tlr.balance) {
                    case LH:
                        t.balance = RH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;
                    case RH:
                        t.balance = EH;
                        tl.balance = LH;
                        tlr.balance = EH;
                        break;
                    case EH:
                        t.balance = EH;
                        tl.balance = LH;
                        tlr.balance = EH;
                        break;
                }

                left_rotate(t.left);
                right_rotate(t);
                break;

        }
    }

    /**
     * 右平衡
     * 节点t的不平衡是因为右子树过深
     *
     * @param t
     */
    private void rightBalance(Node<E> t) {
        Node<E> tr = t.right;
        switch (tr.balance) {
            case RH://新的节点插入到t的右孩子的右子树中
                left_rotate(t);
                t.balance = EH;
                tr.balance = EH;
                break;
            case LH://新的节点插入到t的右孩子的左子树中
                Node<E> trl = tr.left;
                switch (trl.balance) {
                    case RH:
                        t.balance = LH;
                        tr.balance = EH;
                        trl.balance = EH;
                        break;
                    case LH:
                        t.balance = EH;
                        tr.balance = RH;
                        trl.balance = EH;

                        break;
                    case EH:
                        t.balance = EH;
                        tr.balance = EH;
                        trl.balance = EH;
                        break;


                }

                right_rotate(t.right);
                left_rotate(t);
                break;

        }
    }


    /**
     * 添加元素
     */
    public boolean insertElement(E element) {
        Node<E> t = root;
        if (t == null) {
            root = new Node<>(element, null);
            size = 1;
            root.balance = 0;
            return true;
        } else {
            //找到要插入的位置
            int cmp = 0;
            Node<E> parent = null;
            Comparable<? super E> e = element;

            while (t != null) {
                parent = t;
                cmp = e.compareTo(parent.element);
                if (cmp < 0) {
                    t = t.left;
                } else if (cmp > 0) {
                    t = t.right;
                } else {
                    return false;
                }
            }

            //开始插入数据
            Node<E> child = new Node<>(element, parent);
            if (cmp < 0) {
                parent.left = child;
            } else {
                parent.right = child;
            }


            //节点已经在树上，开始检查平衡性，回溯查找
            while (parent != null) {
                cmp = e.compareTo(parent.element);
                if (cmp < 0) {
                    //加到左边
                    parent.balance++;
                } else {
                    //加到右边
                    parent.balance--;
                }
                if (parent.balance == 0) {//如果插入后还是平衡树，不用调整
                    break;
                }
                if (Math.abs(parent.balance) == 2) {
                    //出现了平衡问题，需要修正
                    fixAfterInsertion(parent);
                    break;
                } else {
                    parent = parent.parent;
                }
            }

        }
        size++;
        return true;
    }

    /**
     * 修正
     * @param parent
     */
    private void fixAfterInsertion(Node<E> parent) {
        if (parent.balance == 2) {
            leftBalance(parent);
        } else if (parent.balance == -2) {
            rightBalance(parent);
        }
    }


    public void showAVL(Node root){
        LinkedList<Node> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()){
            Node node = list.pop();
            System.out.println(node.element);
            if (node.left!=null){
                list.offer(node.left);
            }
            if (node.right!=null){
                list.offer(node.right);
            }

        }
    }


    /**
     * 结点
     *
     * @param <E>
     */
    private class Node<E extends Comparable<E>> {
        E element;
        int balance = 0;//平衡因子
        Node<E> left;
        Node<E> right;
        Node<E> parent;


        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", balance=" + balance +
                    ", left=" + left +
                    ", right=" + right +
                    ", parent=" + parent +
                    '}';
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }


}
