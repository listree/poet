package com.leet.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/count-pairs-of-nodes/
 * 1782. Count Pairs Of Nodes (Hard)
 * You are given an undirected graph defined by an integer n, the number of nodes, and a 2D integer array edges,
 * the edges in the graph, where edges[i] = [ui, vi] indicates that there is an undirected edge between ui and vi.
 * You are also given an integer array queries.
 * Let incident(a, b) be defined as the number of edges that are connected to either node a or b.
 * The answer to the jth query is the number of pairs of nodes (a, b) that satisfy both of the following conditions:
 * a < b and incident(a, b) > queries[j]
 * Return an array answers such that answers.length == queries.length and answers[j] is the answer of the jth query.
 * Note that there can be multiple edges between the same two nodes.
 * TODO: ??? Time Limit Exceeded ???
 */
public class HardCountPairs {

    public final static void main(String[] args) {
        HardCountPairs ha = new HardCountPairs();
        int n = 5; // 4;
        int[][] edges =  {{1,5},{1,5},{3,4},{2,5},{1,3},{5,1},{2,3},{2,5}}; //{{1,2},{2,4},{1,3},{2,3},{2,1}};
        int[] queries = {1, 2, 3, 4, 5};
        int[] counts =  ha.countPairs(n, edges, queries);
        for( int x : counts)
            System.out.print(x + ",");
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[][] incidents = new int[n+1][n+1];
        int[] counts = new int[queries.length];

        // calculate incidents
        for(int[] edge: edges) {
            int x = Math.min(edge[0], edge[1]);
            int y = Math.max(edge[0], edge[1]);
            for( int k = 1; k <= n; k++) {
                if( x < k )
                    incidents[x][k]++;
                else if( k < x )
                    incidents[k][x]++;
                if( y < k )
                    incidents[y][k]++;
                else if( k < y )
                    incidents[k][y]++;
            }
            incidents[x][y]--;
        }

        List<Integer> sorted = new LinkedList<Integer>();
        for( int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                sorted.add(incidents[i][j]);
            }
        }
        Collections.sort(sorted);

        // count
        for( int i = 0; i < queries.length; i++) {
            counts[i] = sorted.size() - findFirstGreaterIndex(sorted, 0, sorted.size() - 1, queries[i]);
        }
        return counts;
    }

    int findFirstGreaterIndex(List<Integer> sorted, int start, int end, int x) {

        if( sorted.get(start) > x )
            return start;

        if( sorted.get(end) <= x )
            return end + 1;

        if( start == end )
            return start;

        int mid = ( start + end ) / 2;

        if( sorted.get(mid) > x ) {
            return findFirstGreaterIndex(sorted, start, mid, x);
        } else {
            return findFirstGreaterIndex(sorted, mid+1, end, x);
        }

    }

}
