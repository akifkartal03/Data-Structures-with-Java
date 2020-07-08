package com.Akif;
import java.util.*;

/**
 * A class for calling Dijkstras algorithm from book.
 */
public class DijkstrasAlgorithm {

  /** Dijkstras Shortest-Path algorithm.
      @param graph The weighted graph to be searched
      @param start The start vertex
      @param pred Output array to contain the predecessors
                  in the shortest path
      @param dist Output array to contain the distance
                  in the shortest path
   */
  public static void dijkstrasAlgorithm(GraphADT graph,
                                        int start,
                                        int[] pred,
                                        double[] dist) {
    int numV = graph.getNumV();
    HashSet < Integer > vMinusS = new HashSet < Integer > (numV);
    // Initialize V-S.
    for (int i = 0; i < numV; i++) {
      if (i != start) {
        vMinusS.add(i);
      }
    }
    // Initialize pred and dist.
    for (int v : vMinusS) {
      pred[v] = start;
      Edge edge = graph.getEdge(start, v);
      if (edge!=null)
          dist[v] = edge.getWeight();
      else
        dist[v] = Double.POSITIVE_INFINITY;
    }
    // Main loop
    while (vMinusS.size() != 0) {
      // Find the value u in V-S with the smallest dist[u].
      double minDist = Double.POSITIVE_INFINITY;
      int u = -1;
      for (int v : vMinusS) {
        if (dist[v] < minDist) {
          minDist = dist[v];
          u = v;
        }
      }
      // Remove u from vMinusS.
      vMinusS.remove(u);
      // Update the distances.
      for (int v : vMinusS) {
        if (graph.isEdge(u, v)) {
          double weight = graph.getEdge(u, v).getWeight();
          if (dist[u] + weight < dist[v]) {
            dist[v] = dist[u] + weight;
            pred[v] = u;
          }
        }
      }
    }
  }
}
