package com.tall.suanfa;

import android.text.TextUtils;

import java.util.NoSuchElementException;

/**
 * 二叉排序树
 * Created by tlf on 2018/12/18.
 */

public class SearchBinaryTree {
    //跟结点
    TreeNode root;


    /**
     * 添加结点
     */
    public TreeNode put(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        TreeNode node = root;
        TreeNode parent = null;
        //找到要放入的位置
        while (node != null) {

            parent = node;
            if (data > node.data) {
                node = node.rightChind;

            } else if (data < node.data) {
                node = node.leftChind;
            } else {
                return node;
            }
        }

        //创建一个结点放入
        TreeNode newNode = new TreeNode(data);
        if (data > parent.data) {
            parent.rightChind = newNode;
        } else {
            parent.leftChind = newNode;
        }
        newNode.parent = parent;

        return newNode;


    }


    /**
     * 中序遍历
     * LDR
     */

    public void midOrderTraverse(TreeNode root) {
        if (root == null) return;

        midOrderTraverse(root.leftChind);
        System.out.println(root.data);
        midOrderTraverse(root.rightChind);
    }


    /**
     * 查找一个结点
     */

    public TreeNode searchNode(int data) {
        if (root == null) return null;

        TreeNode node = root;
        while (node != null) {
            if (data == node.data) {
                return node;
            } else if (data > node.data) {
                node = node.rightChind;
            } else if (data < node.data) {
                node = node.leftChind;
            }
        }

        return null;

    }

    /**
     * 删除一个结点
     */
    public void delNode(TreeNode node) {
        if (node == null) {
            throw new NoSuchElementException();
        } else if (searchNode(node.data) == null) {
            throw new NoSuchElementException();
        } else {
            //先得到父亲，方便后面的操作
            TreeNode parent = node.parent;
            //1.叶子
            if (node.leftChind == null && node.rightChind == null) {
                //特殊情况：只有一个结点或者是空树
                if (parent == null) {
                    root = null;
                } else if (parent.leftChind == node) {
                    parent.leftChind = null;
                    node.parent = null;
                } else if (parent.rightChind == node) {
                    parent.rightChind = null;
                    node.parent = null;
                }

            } else if (node.leftChind != null && node.rightChind == null) {
                //2.只有左孩子
                if (parent == null) {//要删除的是根结点
                    node.leftChind.parent = null;
                    root = node.leftChind;
                    node.leftChind = null;

                } else {
                    if (node == parent.leftChind) {//要删除的是父亲的左边
                        node.leftChind.parent = parent;
                        parent.leftChind = node.leftChind;
                    } else {//要删除的是父亲的右边
                        node.leftChind.parent = parent;
                        parent.rightChind = node.leftChind;
                    }
                    node.leftChind = null;
                    node.parent = null;


                }

            } else if (node.leftChind == null && node.rightChind != null) {
                //3.只有右孩子
                if (parent == null) {//要删除的是根结点
                    node.rightChind.parent = null;
                    root = node.rightChind;
                    node.rightChind = null;
                } else {
                    if (node == parent.leftChind) {//要删除的是父亲的左边
                        node.rightChind.parent = parent;
                        parent.leftChind = node.rightChind;

                    } else {//要删除的是父亲的右边
                        node.rightChind.parent = parent;
                        parent.rightChind = node.rightChind;
                    }

                    node.parent = null;
                    node.rightChind = null;

                }

            } else {
                //4.有两个孩子
                if (node.rightChind.leftChind == null) {//如果被删除结点的右子树的左子树为空，则直接补上
                    node.rightChind.leftChind = node.leftChind;

                    if (node.parent == null) {
                        root = node.rightChind;

                    } else {
                        if (node.leftChind == node) {
                            parent.leftChind = node.rightChind;
                        } else {
                            parent.rightChind = node.rightChind;

                        }
                        node.parent = null;
                    }


                } else {//否则就补上被删除结点的右子树的左子树中最小的一个

                    TreeNode leftTreeNode = getMinLeftTreeNode(node.rightChind);
                    leftTreeNode.parent.leftChind = null;
                    leftTreeNode.leftChind = node.leftChind;
                    TreeNode leftP = leftTreeNode.parent;
                    leftP.leftChind = leftP.rightChind;
                    leftTreeNode.parent = parent;
                    if (parent == null) {
                        root = leftTreeNode;
                    } else {
                        if (parent.leftChind == node) {
                            parent.leftChind = leftTreeNode;
                        } else {
                            parent.rightChind = leftTreeNode;
                        }

                        node.parent = null;
                    }

                }

                node.leftChind = null;
                node.rightChind = null;

            }


        }
    }

    /**
     * 找到最小的结点
     *
     * @return
     */
    private TreeNode getMinLeftTreeNode(TreeNode node) {
        TreeNode curRoot = null;
        if (node == null) {
            return null;
        } else {
            curRoot = node;
            while (curRoot.leftChind != null) {
                curRoot = curRoot.leftChind;
            }
        }
        return curRoot;

    }


    /**
     * 结点
     */
    public static class TreeNode {
        int data;
        TreeNode leftChind;
        TreeNode rightChind;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
            this.leftChind = null;
            this.rightChind = null;
            this.parent = null;
        }
    }
}
