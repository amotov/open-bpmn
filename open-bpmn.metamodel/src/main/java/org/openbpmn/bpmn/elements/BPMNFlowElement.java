package org.openbpmn.bpmn.elements;

import org.w3c.dom.Node;

/**
 * The FlowElement is the abstract super class for all elements that can appear
 * in a Process flow, which are FlowNodes consisting of Activities ,
 * Choreography Activities, Gateways , and Events , Data Objects , Data
 * Associations , and Sequence Flows.
 * 
 * @author rsoika
 *
 */
public abstract class BPMNFlowElement extends BPMNBaseElement {

    protected String type = null;
    protected Node bpmnShape = null;
    protected BPMNBounds bounds = null;


    public BPMNFlowElement(String type, Node node) {
        super(node);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Node getBpmnShape() {
        return bpmnShape;
    }

    public void setBpmnShape(Node bpmnShape) {
        this.bpmnShape = bpmnShape;
    }
    
    public BPMNBounds getBounds() {
        if (bounds == null) {
            // lazy loading of bounds from a given bpmnShape
            bounds = new BPMNBounds(this.bpmnShape);
        }
        return bounds;
    }
}