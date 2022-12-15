package org.openbpmn.bpmn;



/**
 * The BPMNTypes provides constants defining the visual elements contained in a BPMNDiagram.  
 * @author rsoika
 *
 */
public class BPMNTypes {

    // Process Types
    public static final String PROCESS_TYPE_PUBLIC = "Public";
    public static final String PROCESS_TYPE_PRIVATE = "Private";
    public static final String PROCESS_TYPE_NONE = "None";
    
    // Task
    public static final String USER_TASK = "userTask";
    public static final String SCRIPT_TASK = "scriptTask";
    public static final String SERVICE_TASK = "serviceTask";
    public static final String SEND_TASK = "sendTask";
    public static final String MANUAL_TASK = "manualTask";
    public static final String BUSINESSRULE_TASK = "businessRuleTask";
    public static final String RECEIVE_TASK = "receiveTask";
    
    public static final String TASK = "task";
    
    // Event
    public static final String EVENT = "event";
    public static final String START_EVENT = "startEvent";
    public static final String END_EVENT= "endEvent";
    public static final String CATCH_EVENT = "intermediateCatchEvent";
    public static final String THROW_EVENT = "intermediateThrowEvent";
    public static final String BOUNDARY_EVENT = "boundaryEvent";
    
    // Event Definitions
    public static final String EVENT_DEFINITION_CONDITIONAL = "conditionalEventDefinition";
    public static final String EVENT_DEFINITION_COMPENSATION = "compensationEventDefinition";
    public static final String EVENT_DEFINITION_TIMER = "timerEventDefinition";
    public static final String EVENT_DEFINITION_SIGNAL = "signalEventDefinition";
    public static final String EVENT_DEFINITION_ESCALATION = "escalationEventDefinition";
    public static final String EVENT_DEFINITION_MESSAGE = "messageEventDefinition";
    public static final String EVENT_DEFINITION_LINK = "linkEventDefinition";
    public static final String EVENT_DEFINITION_ERROR = "errorEventDefinition";
    public static final String EVENT_DEFINITION_TERMINATE = "terminateEventDefinition";
    public static final String EVENT_DEFINITION_CANCEL = "cancelEventDefinition";
   
    // Multiple Event Definitions
    public static final String MULTIPLE_EVENT_DEFINITIONS = "multipleEventDefinition";
    
    // Gateway
    public static final String GATEWAY = "gateway"; 
    public static final String EXCLUSIVE_GATEWAY = "exclusiveGateway";
    public static final String INCLUSIVE_GATEWAY = "inclusiveGateway";
    public static final String EVENTBASED_GATEWAY = "eventBasedGateway";
    public static final String PARALLEL_GATEWAY = "parallelGateway";
    public static final String COMPLEX_GATEWAY = "complexGateway";
    
    // others  
    public static final String DATAOBJECT = "dataObject";
    public static final String POOL = "pool";
    public static final String LANE = "lane";
    public static final String SEQUENCE_FLOW = "sequenceFlow";
    public static final String MESSAGE_FLOW = "messageFlow";
    public static final String ASSOCIATION = "association";
    public static final String BPMNLABEL = "BPMNLabel";
    public static final String EXTENSION = "extension";
}

