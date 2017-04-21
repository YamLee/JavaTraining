package com.yamlee.datastructure.graph;

/**
 * Edge for graph
 *
 * @author yamlee
 */
public class Edge {
    private Vertex arrowHeadVertex;
    private Vertex arrowTailVertex;


    public Vertex getArrowHeadVertex() {
        return arrowHeadVertex;
    }

    public void setArrowHeadVertex(Vertex arrowHeadVertex) {
        this.arrowHeadVertex = arrowHeadVertex;
    }

    public Vertex getArrowTailVertex() {
        return arrowTailVertex;
    }

    public void setArrowTailVertex(Vertex arrowTailVertex) {
        this.arrowTailVertex = arrowTailVertex;
    }
}
