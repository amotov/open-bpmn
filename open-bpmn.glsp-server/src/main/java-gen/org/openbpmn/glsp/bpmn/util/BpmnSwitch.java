/**
 */
package org.openbpmn.glsp.bpmn.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.glsp.graph.GArgumentable;
import org.eclipse.glsp.graph.GBoundsAware;
import org.eclipse.glsp.graph.GCompartment;
import org.eclipse.glsp.graph.GEdge;
import org.eclipse.glsp.graph.GEdgeLayoutable;
import org.eclipse.glsp.graph.GLayouting;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GNode;
import org.eclipse.glsp.graph.GShapeElement;

import org.openbpmn.glsp.bpmn.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.openbpmn.glsp.bpmn.BpmnPackage
 * @generated
 */
public class BpmnSwitch<T> extends Switch<T> {
    /**
	 * The cached model package
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static BpmnPackage modelPackage;

    /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public BpmnSwitch() {
		if (modelPackage == null) {
			modelPackage = BpmnPackage.eINSTANCE;
		}
	}

    /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BpmnPackage.BPMNG_NODE: {
				BPMNGNode bpmngNode = (BPMNGNode)theEObject;
				T result = caseBPMNGNode(bpmngNode);
				if (result == null) result = caseGNode(bpmngNode);
				if (result == null) result = caseGShapeElement(bpmngNode);
				if (result == null) result = caseGEdgeLayoutable(bpmngNode);
				if (result == null) result = caseGLayouting(bpmngNode);
				if (result == null) result = caseGModelElement(bpmngNode);
				if (result == null) result = caseGBoundsAware(bpmngNode);
				if (result == null) result = caseGArgumentable(bpmngNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.BPMNG_EDGE: {
				BPMNGEdge bpmngEdge = (BPMNGEdge)theEObject;
				T result = caseBPMNGEdge(bpmngEdge);
				if (result == null) result = caseGEdge(bpmngEdge);
				if (result == null) result = caseGModelElement(bpmngEdge);
				if (result == null) result = caseGArgumentable(bpmngEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.ICON_GCOMPARTMENT: {
				IconGCompartment iconGCompartment = (IconGCompartment)theEObject;
				T result = caseIconGCompartment(iconGCompartment);
				if (result == null) result = caseGCompartment(iconGCompartment);
				if (result == null) result = caseGShapeElement(iconGCompartment);
				if (result == null) result = caseGLayouting(iconGCompartment);
				if (result == null) result = caseGModelElement(iconGCompartment);
				if (result == null) result = caseGBoundsAware(iconGCompartment);
				if (result == null) result = caseGArgumentable(iconGCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.TASK_GNODE: {
				TaskGNode taskGNode = (TaskGNode)theEObject;
				T result = caseTaskGNode(taskGNode);
				if (result == null) result = caseBPMNGNode(taskGNode);
				if (result == null) result = caseGNode(taskGNode);
				if (result == null) result = caseGShapeElement(taskGNode);
				if (result == null) result = caseGEdgeLayoutable(taskGNode);
				if (result == null) result = caseGLayouting(taskGNode);
				if (result == null) result = caseGModelElement(taskGNode);
				if (result == null) result = caseGBoundsAware(taskGNode);
				if (result == null) result = caseGArgumentable(taskGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.GATEWAY_GNODE: {
				GatewayGNode gatewayGNode = (GatewayGNode)theEObject;
				T result = caseGatewayGNode(gatewayGNode);
				if (result == null) result = caseBPMNGNode(gatewayGNode);
				if (result == null) result = caseGNode(gatewayGNode);
				if (result == null) result = caseGShapeElement(gatewayGNode);
				if (result == null) result = caseGEdgeLayoutable(gatewayGNode);
				if (result == null) result = caseGLayouting(gatewayGNode);
				if (result == null) result = caseGModelElement(gatewayGNode);
				if (result == null) result = caseGBoundsAware(gatewayGNode);
				if (result == null) result = caseGArgumentable(gatewayGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.EVENT_GNODE: {
				EventGNode eventGNode = (EventGNode)theEObject;
				T result = caseEventGNode(eventGNode);
				if (result == null) result = caseBPMNGNode(eventGNode);
				if (result == null) result = caseGNode(eventGNode);
				if (result == null) result = caseGShapeElement(eventGNode);
				if (result == null) result = caseGEdgeLayoutable(eventGNode);
				if (result == null) result = caseGLayouting(eventGNode);
				if (result == null) result = caseGModelElement(eventGNode);
				if (result == null) result = caseGBoundsAware(eventGNode);
				if (result == null) result = caseGArgumentable(eventGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.LABEL_GNODE: {
				LabelGNode labelGNode = (LabelGNode)theEObject;
				T result = caseLabelGNode(labelGNode);
				if (result == null) result = caseBPMNGNode(labelGNode);
				if (result == null) result = caseGNode(labelGNode);
				if (result == null) result = caseGShapeElement(labelGNode);
				if (result == null) result = caseGEdgeLayoutable(labelGNode);
				if (result == null) result = caseGLayouting(labelGNode);
				if (result == null) result = caseGModelElement(labelGNode);
				if (result == null) result = caseGBoundsAware(labelGNode);
				if (result == null) result = caseGArgumentable(labelGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.DATA_OBJECT_GNODE: {
				DataObjectGNode dataObjectGNode = (DataObjectGNode)theEObject;
				T result = caseDataObjectGNode(dataObjectGNode);
				if (result == null) result = caseBPMNGNode(dataObjectGNode);
				if (result == null) result = caseGNode(dataObjectGNode);
				if (result == null) result = caseGShapeElement(dataObjectGNode);
				if (result == null) result = caseGEdgeLayoutable(dataObjectGNode);
				if (result == null) result = caseGLayouting(dataObjectGNode);
				if (result == null) result = caseGModelElement(dataObjectGNode);
				if (result == null) result = caseGBoundsAware(dataObjectGNode);
				if (result == null) result = caseGArgumentable(dataObjectGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.DATA_STORE_GNODE: {
				DataStoreGNode dataStoreGNode = (DataStoreGNode)theEObject;
				T result = caseDataStoreGNode(dataStoreGNode);
				if (result == null) result = caseBPMNGNode(dataStoreGNode);
				if (result == null) result = caseGNode(dataStoreGNode);
				if (result == null) result = caseGShapeElement(dataStoreGNode);
				if (result == null) result = caseGEdgeLayoutable(dataStoreGNode);
				if (result == null) result = caseGLayouting(dataStoreGNode);
				if (result == null) result = caseGModelElement(dataStoreGNode);
				if (result == null) result = caseGBoundsAware(dataStoreGNode);
				if (result == null) result = caseGArgumentable(dataStoreGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.MESSAGE_GNODE: {
				MessageGNode messageGNode = (MessageGNode)theEObject;
				T result = caseMessageGNode(messageGNode);
				if (result == null) result = caseBPMNGNode(messageGNode);
				if (result == null) result = caseGNode(messageGNode);
				if (result == null) result = caseGShapeElement(messageGNode);
				if (result == null) result = caseGEdgeLayoutable(messageGNode);
				if (result == null) result = caseGLayouting(messageGNode);
				if (result == null) result = caseGModelElement(messageGNode);
				if (result == null) result = caseGBoundsAware(messageGNode);
				if (result == null) result = caseGArgumentable(messageGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.GROUP_GNODE: {
				GroupGNode groupGNode = (GroupGNode)theEObject;
				T result = caseGroupGNode(groupGNode);
				if (result == null) result = caseBPMNGNode(groupGNode);
				if (result == null) result = caseGNode(groupGNode);
				if (result == null) result = caseGShapeElement(groupGNode);
				if (result == null) result = caseGEdgeLayoutable(groupGNode);
				if (result == null) result = caseGLayouting(groupGNode);
				if (result == null) result = caseGModelElement(groupGNode);
				if (result == null) result = caseGBoundsAware(groupGNode);
				if (result == null) result = caseGArgumentable(groupGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.TEXT_ANNOTATION_GNODE: {
				TextAnnotationGNode textAnnotationGNode = (TextAnnotationGNode)theEObject;
				T result = caseTextAnnotationGNode(textAnnotationGNode);
				if (result == null) result = caseBPMNGNode(textAnnotationGNode);
				if (result == null) result = caseGNode(textAnnotationGNode);
				if (result == null) result = caseGShapeElement(textAnnotationGNode);
				if (result == null) result = caseGEdgeLayoutable(textAnnotationGNode);
				if (result == null) result = caseGLayouting(textAnnotationGNode);
				if (result == null) result = caseGModelElement(textAnnotationGNode);
				if (result == null) result = caseGBoundsAware(textAnnotationGNode);
				if (result == null) result = caseGArgumentable(textAnnotationGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.POOL_GNODE: {
				PoolGNode poolGNode = (PoolGNode)theEObject;
				T result = casePoolGNode(poolGNode);
				if (result == null) result = caseBPMNGNode(poolGNode);
				if (result == null) result = caseGNode(poolGNode);
				if (result == null) result = caseGShapeElement(poolGNode);
				if (result == null) result = caseGEdgeLayoutable(poolGNode);
				if (result == null) result = caseGLayouting(poolGNode);
				if (result == null) result = caseGModelElement(poolGNode);
				if (result == null) result = caseGBoundsAware(poolGNode);
				if (result == null) result = caseGArgumentable(poolGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BpmnPackage.LANE_GNODE: {
				LaneGNode laneGNode = (LaneGNode)theEObject;
				T result = caseLaneGNode(laneGNode);
				if (result == null) result = caseBPMNGNode(laneGNode);
				if (result == null) result = caseGNode(laneGNode);
				if (result == null) result = caseGShapeElement(laneGNode);
				if (result == null) result = caseGEdgeLayoutable(laneGNode);
				if (result == null) result = caseGLayouting(laneGNode);
				if (result == null) result = caseGModelElement(laneGNode);
				if (result == null) result = caseGBoundsAware(laneGNode);
				if (result == null) result = caseGArgumentable(laneGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>BPMNG Node</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMNG Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseBPMNGNode(BPMNGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>BPMNG Edge</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMNG Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseBPMNGEdge(BPMNGEdge object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Icon GCompartment</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon GCompartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseIconGCompartment(IconGCompartment object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Task GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseTaskGNode(TaskGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Gateway GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gateway GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGatewayGNode(GatewayGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Event GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseEventGNode(EventGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Label GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseLabelGNode(LabelGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Data Object GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Object GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseDataObjectGNode(DataObjectGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Data Store GNode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Store GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataStoreGNode(DataStoreGNode object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Message GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseMessageGNode(MessageGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Group GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGroupGNode(GroupGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Text Annotation GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Annotation GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseTextAnnotationGNode(TextAnnotationGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Pool GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pool GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePoolGNode(PoolGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Lane GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lane GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseLaneGNode(LaneGNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GArgumentable</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GArgumentable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGArgumentable(GArgumentable object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GModel Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGModelElement(GModelElement object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GBounds Aware</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GBounds Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGBoundsAware(GBoundsAware object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GShape Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GShape Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGShapeElement(GShapeElement object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GEdge Layoutable</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GEdge Layoutable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGEdgeLayoutable(GEdgeLayoutable object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GLayouting</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GLayouting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGLayouting(GLayouting object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GNode</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGNode(GNode object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GEdge</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GEdge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGEdge(GEdge object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GCompartment</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GCompartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGCompartment(GCompartment object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
    @Override
    public T defaultCase(EObject object) {
		return null;
	}

} //BpmnSwitch
