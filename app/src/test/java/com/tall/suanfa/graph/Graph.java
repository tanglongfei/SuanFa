package com.tall.suanfa.graph;


import java.util.LinkedList;

/**
 * 图
 * Created by tlf on 2018/12/23.
 */

public class Graph {
    public int[] vertices;//顶点集
    public int[][] matrix;//图边的信息
    public int verticesSize;

    public static final int MAX_WEIGHT = Integer.MAX_VALUE;


    public boolean[] isVisited;

    public Graph(int verticesSize) {
        this.verticesSize = verticesSize;
        vertices = new int[verticesSize];
        matrix = new int[verticesSize][verticesSize];
        isVisited = new boolean[verticesSize];
        for (int i = 0; i < verticesSize; i++) {
            vertices[i] = i;
        }

    }

    /**
     * 计算v1到v2的权重（路径长度）
     */

    public int getWeight(int v1, int v2) {
        int weight = matrix[v1][v2];
        return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
    }


    /**
     * 获取顶点
     */
    public int[] getVertices() {
        return vertices;
    }

    /**
     * 获取出度
     */
    public int getOutDegree(int v) {
        int count = 0;
        for (int i = 0; i < verticesSize; i++) {
            if (matrix[v][i] != 0 && matrix[v][i] != MAX_WEIGHT) {
                count++;
            }
        }

        return count;

    }

    /**
     * 获取出度
     */
    public int getInDegree(int v) {
        int count = 0;
        for (int i = 0; i < verticesSize; i++) {
            if (matrix[i][v] != 0 && matrix[i][v] != MAX_WEIGHT) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取第一个邻接点
     */
    public int getFirstNeightBor(int v) {

        for (int i = 0; i < verticesSize; i++) {
            if (matrix[v][i] > 0 && matrix[v][i] != MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 获取顶点v的邻接点index之后下一个邻接点
     */
    public int getNextNeightBor(int v, int index) {
        for (int i = index + 1; i < verticesSize; i++) {
            if (matrix[v][i] > 0 && matrix[v][i] != MAX_WEIGHT) {
                return i;
            }
        }

        return -1;
    }


    /**
     * 所有顶点深度优先遍历（类似二叉树的前序遍历）
     */
    public void dfs() {
        for (int i = 0; i < verticesSize; i++) {
            isVisited[i] = false;
        }

        for (int i = 0; i < verticesSize; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                System.out.println("viested vertice" + i);
                dfs(i);
            }
        }
    }

    /**
     * 一个顶点深度优先遍历
     *
     * @param i
     */
    private void dfs(int i) {
        isVisited[i] = true;
        int v = getFirstNeightBor(i);
        //内循环为的是同一行中是否有下一个可达顶点
        while (v != -1) {
            if (!isVisited[v]) {
                System.out.println("viested vertice" + v);
                dfs(v);
            }
            v = getNextNeightBor(i, v);
        }
    }


    /**
     * 所有顶点都进行广度优先
     */
    public void bfs() {
        for (int i = 0; i < verticesSize; i++) {
            isVisited[i] = false;
        }

        for (int i = 0; i < verticesSize; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                System.out.println("viested vertice" + i);
                bfs(i);
            }
        }
    }


    /**
     * 一个顶点进行广度优先
     */
    public void bfs(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        //找到第一个邻接点
        int fn = getFirstNeightBor(i);
        if (fn == -1) {
            return;
        }
        if (!isVisited[fn]) {
            isVisited[fn] = true;
            System.out.println("viested vertice" + fn);
            queue.offer(fn);
        }

        //开始把后面的邻接点都入队
        int next = getNextNeightBor(i, fn);
        while (next != -1) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                System.out.println("viested vertice" + next);
                queue.offer(next);
            }
            next = getNextNeightBor(i, next);
        }

        //从队列中取出来一个，重复之前的操作
        while (!queue.isEmpty()) {
            Integer point = queue.poll();
            bfs(point);
        }

    }


}
