package org.openbpmn.bpmn.elements;

import java.util.logging.Logger;

import org.openbpmn.bpmn.BPMNModel;
import org.w3c.dom.Element;

public class BPMNMessageFlow extends BPMNBaseFlow {
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(BPMNMessageFlow.class.getName());

    public BPMNMessageFlow(BPMNModel model, Element node, BPMNProcess _bpmnProcess) {
        super(model, node, _bpmnProcess);
    }

    
}