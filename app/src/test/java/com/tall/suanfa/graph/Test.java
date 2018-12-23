package com.tall.suanfa.graph;

import static com.tall.suanfa.graph.Graph.MAX_WEIGHT;

/**
 * Created by tlf on 2018/12/23.
 */

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Graph graph = new Graph(5);
        int[] v0 = new int[]{0, 1, 1, MAX_WEIGHT, MAX_WEIGHT};
        int[] v1 = new int[]{MAX_WEIGHT, 0, MAX_WEIGHT, 1, MAX_WEIGHT};
        int[] v2 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT, MAX_WEIGHT};
        int[] v3 = new int[]{1, MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT};
        int[] v4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 1, MAX_WEIGHT, 0};

        graph.matrix[0] = v0;
        graph.matrix[1] = v1;
        graph.matrix[2] = v2;
        graph.matrix[3] = v3;
        graph.matrix[4] = v4;

        graph.dfs();

    }
}
