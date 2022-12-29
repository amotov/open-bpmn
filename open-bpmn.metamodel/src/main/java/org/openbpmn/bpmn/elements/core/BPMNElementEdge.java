package org.openbpmn.bpmn.elements.core;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openbpmn.bpmn.BPMNModel;
import org.openbpmn.bpmn.BPMNNS;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The BPMNElementEdge is the abstract super class for all BPMN edge types
 * (SequenceFlow, MessageFlow, Association).
 * <p>
 * The BPMNElementEdge provides general attributes like the source and target
 * ref and also the wayPoint attribute.
 * <p>
 * A BPMNElementEdge extends the AbstractBPMNElement
 * 
 * @author rsoika
 */
public abstract class BPMNElementEdge extends BPMNElement {
    private static Logger logger = Logger.getLogger(BPMNElementEdge.class.getName());
    protected String type = null;
    
    protected String sourceRef = null;
    protected String targetRef = null;
    protected Element bpmnEdge = null;
    protected Set<BPMNPoint> wayPoints = null;

    public BPMNElementEdge(BPMNModel model, Element node) {
       super(model,node);
    }
    
    public BPMNElementEdge(BPMNModel model, Element node, String _type) {
        super(model, node);
        this.type = _type;
        
        wayPoints = new LinkedHashSet<BPMNPoint>();

        this.sourceRef = this.getAttribute("sourceRef");
        if (sourceRef.isEmpty()) {
            logger.warning("Missing sourceRef!");
        }

        this.targetRef = this.getAttribute("targetRef");
        if (targetRef.isEmpty()) {
            logger.warning("Missing targetRef!");
        }

        // find the BPMNShape element. If not defined create a new one
       
            bpmnEdge = (Element) model.findBPMNPlaneElement("BPMNEdge", getId());
            if (bpmnEdge == null) {
                // create shape element
                createBPMNEdge();
            } else {
                // parse waypoints (di:waypoint)
                Set<Element> wayPoints = BPMNModel.findChildNodesByName(bpmnEdge, BPMNNS.DI.prefix + ":waypoint");
                for (Element wayPoint : wayPoints) {
                    NamedNodeMap wayPointattributeMap = wayPoint.getAttributes();
                    BPMNPoint point = new BPMNPoint(wayPointattributeMap.getNamedItem("x").getNodeValue(), //
                            wayPointattributeMap.getNamedItem("y").getNodeValue());
                    getWayPoints().add(point);
                }
            }
        
    }


    public Element getBpmnEdge() {
        return bpmnEdge;
    }

    public void setBpmnEdge(Element bpmnEdge) {
        this.bpmnEdge = bpmnEdge;
    }

    /**
     * Returns the BPMN sub type
     * 
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Set the BPMN sub type
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the sourc ref ID
     * 
     * @return
     */
    public String getSourceRef() {
        return sourceRef;
    }

    /**
     * Returns the Connected BPMN source element
     * 
     * @return
     */
    public BPMNElementNode getSourceElement() {
        return this.model.findElementNodeById(sourceRef);
    }

    public void setSourceRef(String sourceRef) {
        this.sourceRef = sourceRef;
    }

    /**
     * Returns the target ref id
     * 
     * @return
     */
    public String getTargetRef() {
        return targetRef;
    }

    public void setTargetRef(String targetRef) {
        this.targetRef = targetRef;
    }

    /**
     * Returns the Connected BPMN target element
     * 
     * @return
     */
    public BPMNElementNode getTargetElement() {
        return this.model.findElementNodeById(targetRef);
    }

    public Set<BPMNPoint> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(Set<BPMNPoint> wayPoints) {
        this.wayPoints = wayPoints;
    }

    /**
     * Adds a new waypoint to the BPMNEdge element
     * 
     * <pre>
     * {@code
     * <bpmndi:BPMNEdge id="BPMNEdge_SequenceFlow_1" 
     *      bpmnElement="SequenceFlow_1" 
     *      sourceElement="BPMNShape_StartEvent_1" 
     *      targetElement="BPMNShape_ManualTask_1"> 
     *      <di:waypoint x="138.0" y="100.0"/>
     *      <di:waypoint x="214.0" y="100.0"/> 
     *      <bpmndi:BPMNLabel id="BPMNLabel_3"/>
     * </bpmndi:BPMNEdge>
     * }
     * </pre>
     */
    public void addWayPoint(BPMNPoint wayPoint) {
        // update shape
        if (this.bpmnEdge != null) {
            Element diwayPoint = model.createElement(BPMNNS.DI, "waypoint");
            diwayPoint.setAttribute("x", wayPoint.getX() + "");
            diwayPoint.setAttribute("y", wayPoint.getY() + "");
            this.bpmnEdge.appendChild(diwayPoint);
        } else {
            logger.warning("missing bpmnShape for SequenceFlow: " + this.getId());
        }
        this.wayPoints.add(wayPoint);
    }

    /**
     * Creates the default waypoints if no waypoints are defined. This is useful in
     * case of a backend creation of edges.
     * 
     * @param wayPoint
     */
    public void addDefaultWayPoints() {
        // Waypoint exist?
        if (this.getWayPoints().size() > 0) {
            return;
        }

        BPMNElementNode sourceElement = this.getSourceElement();
        BPMNElementNode targetElement = this.getTargetElement();
        if (sourceElement != null && targetElement != null) {
            addWayPoint(sourceElement.bounds.getCenter());
            addWayPoint(targetElement.bounds.getCenter());
        }
    }

    /**
     * Removes all wayPoints form this BPMNSequenceFlow
     */
    public void clearWayPoints() {
        NodeList childList = bpmnEdge.getChildNodes();
        List<Node> deletionList = new ArrayList<Node>();
        // find all di:waypoint
        for (int i = 0; i < childList.getLength(); i++) {
            Node child = childList.item(i);
            if ((BPMNNS.DI.prefix + ":waypoint").equals(child.getNodeName()) && child.hasAttributes()) {
                // collect node....
                deletionList.add(child);
            }
        }
        // remove nodes from Edge element...
        for (Node element : deletionList) {
            bpmnEdge.removeChild(element);
        }
        // reset wayPoints
        wayPoints.clear();
    }

    /**
     * Creates a BPMNEdge node for this element
     * <p>
     * <bpmndi:BPMNBPMNEdge id="BPMNBPMNEdge_1" bpmnElement="StartEvent_1">
     */
    protected void createBPMNEdge() {
        if (bpmnEdge != null) {
            BPMNModel.getLogger().warning("bpmnShape already exits");
        }
        if (model.getBpmnPlane() == null) {
            BPMNModel.getLogger().warning("Missing bpmnPlane in current diagram context");
        }
        if (this.getId() != null) {
            bpmnEdge = model.createElement(BPMNNS.BPMNDI, "BPMNEdge");
            bpmnEdge.setAttribute("id", BPMNModel.generateShortID("BPMNEdge"));
            bpmnEdge.setAttribute("bpmnElement", this.getId());
            model.getBpmnPlane().appendChild(bpmnEdge);
        } else {
            BPMNModel.getLogger().warning("Missing ID attribute!");
        }
    }

}
