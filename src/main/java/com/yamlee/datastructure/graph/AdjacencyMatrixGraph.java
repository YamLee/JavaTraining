package com.yamlee.datastructure.graph;

/**
 * AdjacencyMatrixGraph Data Structure
 *
 * @author yamlee
 */
public class AdjacencyMatrixGraph implements Graph {
    private Vertex[] mVertices;
    private Edge[][] mEdges;
    private int length;

    @Override
    public Graph createGraph(Vertex[] vertices, Edge[] edges) {
        if (vertices == null || edges == null) {
            throw new IllegalArgumentException("vertices or edges can not be null!");
        }
        length = vertices.length;
        mVertices = vertices;
        mEdges = new Edge[length][length];
        return this;
    }

    @Override
    public void destroyGraph() {

    }

    @Override
    public int locateVex(Vertex vertex) {
        return 0;
    }

    @Override
    public Vertex getVex(String value) {
        return null;
    }

    @Override
    public void putVex(Vertex vertex, String value) {

    }

    @Override
    public Vertex firstAdjVex(Vertex vertex) {
        return null;
    }

    @Override
    public Vertex nextAdjVex(Vertex vertex, Vertex firstAdjVex) {
        return null;
    }

    @Override
    public boolean insertVex(Vertex vertex) {
        return false;
    }

    @Override
    public boolean deleteVex(Vertex vertex) {
        return false;
    }

    @Override
    public boolean insertEdge(Edge edge) {
        return false;
    }

    @Override
    public boolean deleteEdge(Edge edge) {
        return false;
    }

    @Override
    public void dfsTraverse() {

    }

    @Override
    public void bfsTraverse() {

    }
}
