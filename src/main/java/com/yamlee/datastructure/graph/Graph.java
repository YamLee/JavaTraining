package com.yamlee.datastructure.graph;

/**
 * Abstract Graph Interface
 * Created by yamlee on 21/04/2017.
 *
 * @author yamlee
 */
public interface Graph {
    Graph createGraph(Vertex[] vertices, Edge[] edges);

    void destroyGraph();

    /**
     * locate vertex position
     *
     * @param vertex
     * @return int value stand for locate position
     */
    int locateVex(Vertex vertex);

    Vertex getVex(String value);

    void putVex(Vertex vertex, String value);

    Vertex firstAdjVex(Vertex vertex);

    Vertex nextAdjVex(Vertex vertex, Vertex firstAdjVex);

    boolean insertVex(Vertex vertex);

    boolean deleteVex(Vertex vertex);

    boolean insertEdge(Edge edge);

    boolean deleteEdge(Edge edge);

    /**
     * Depth-First-Search
     */
    void dfsTraverse();

    /**
     * Breadth-First-Search
     */
    void bfsTraverse();
}
