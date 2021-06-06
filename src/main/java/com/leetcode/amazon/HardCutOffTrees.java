package com.leetcode.amazon;
import java.util.*;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * 675. Cut Off Trees for Golf Event (Hard)
 * You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:
 * 0 means the cell cannot be walked through.
 * 1 represents an empty cell that can be walked through.
 * A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.
 * In one step, you can walk in any of the four directions: north, east, south, and west.
 * If you are standing in a cell with a tree, you can choose whether to cut it off.
 * You must cut off the trees in order from shortest to tallest.
 * When you cut off a tree, the value at its cell becomes 1 (an empty cell).
 * Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees.
 * If you cannot cut off all the trees, return -1.
 * You are guaranteed that no two trees have the same height, and there is at least one tree needs to be cut off.
 * Runtime: 723 ms, faster than 80.17% of Java online submissions for Cut Off Trees for Golf Event.
 * Memory: 117.5 MB, less than 74.46% of Java online submissions for Cut Off Trees for Golf Event.
 */
public class HardCutOffTrees {

    public final static void main(String[] args) {
        HardCutOffTrees tester = new HardCutOffTrees();
        List<List<Integer>> forest = new ArrayList<List<Integer>>();
        Integer[] arr1 = {1, 2, 3};
        forest.add(Arrays.asList(arr1));
        Integer[] arr2 = {0, 0, 4};
        forest.add(Arrays.asList(arr2));
        Integer[] arr3 = {7, 6, 5};
        forest.add(Arrays.asList(arr3));
        System.out.println(tester.cutOffTree(forest)); // must be 6
    }

    class Cell implements Comparable<Cell> {
        int x, y;
        int height;

        public Cell(int x, int y, int tree) {
            this.x = x;
            this.y = y;
            this.height = tree;
        }

        public int compareTo(Cell cell) {
            return this.height <= cell.height ? -1 : 1;
        }

        public boolean equals(Cell cell) {
            return this.x == cell.x && this.y == cell.y;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Cell> heightQueue = new PriorityQueue<Cell>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1)
                    heightQueue.add(new Cell(i, j, forest.get(i).get(j)));
            }
        }

        int sumPath = 0;
        if (forest.get(0).get(0) == 0)
            return -1;

        Cell source = new Cell(0, 0, forest.get(0).get(0));
        while (!heightQueue.isEmpty()) {
            Cell dest = heightQueue.poll();
            int toDestPath = getMinPath(forest, source, dest);
            if (toDestPath == -1)
                return -1;

            sumPath += toDestPath;
            source = dest;
        }

        return sumPath;
    }

    final int[][] direction4 = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // getMinPath is BFS
    private int getMinPath(List<List<Integer>> forest, Cell source, Cell dest) {
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[forest.size()][forest.get(0).size()];
        queue.add(source);
        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) { // process 1 batch
                Cell cell = queue.poll();
                if (cell.equals(dest)) {
                    return path;
                }

                for (int k = 0; k < 4; k++) {
                    int x = cell.x + direction4[k][0];
                    int y = cell.y + direction4[k][1];
                    if (isValidCell(x, y, forest.size(), forest.get(0).size())
                            && !isVisited[x][y]
                            && forest.get(x).get(y) != 0) {
                        queue.add(new Cell(x, y, forest.get(x).get(y)));
                        isVisited[x][y] = true;
                    }
                }
            }
            path++;
        }

        return -1;
    }

    private boolean isValidCell(int x, int y, int N, int M) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
