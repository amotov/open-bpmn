/**
 */
package org.openbpmn.glsp.bpmn;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.openbpmn.glsp.bpmn.BpmnPackage
 * @generated
 */
public interface BpmnFactory extends EFactory {
    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    BpmnFactory eINSTANCE = org.openbpmn.glsp.bpmn.impl.BpmnFactoryImpl.init();

    /**
	 * Returns a new object of class '<em>BPMNG Node</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>BPMNG Node</em>'.
	 * @generated
	 */
    BPMNGNode createBPMNGNode();

    /**
	 * Returns a new object of class '<em>BPMNG Edge</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>BPMNG Edge</em>'.
	 * @generated
	 */
    BPMNGEdge createBPMNGEdge();

    /**
	 * Returns a new object of class '<em>Icon GCompartment</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon GCompartment</em>'.
	 * @generated
	 */
    IconGCompartment createIconGCompartment();

    /**
	 * Returns a new object of class '<em>Task GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task GNode</em>'.
	 * @generated
	 */
    TaskGNode createTaskGNode();

    /**
	 * Returns a new object of class '<em>Gateway GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gateway GNode</em>'.
	 * @generated
	 */
    GatewayGNode createGatewayGNode();

    /**
	 * Returns a new object of class '<em>Event GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event GNode</em>'.
	 * @generated
	 */
    EventGNode createEventGNode();

    /**
	 * Returns a new object of class '<em>Label GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Label GNode</em>'.
	 * @generated
	 */
    LabelGNode createLabelGNode();

    /**
	 * Returns a new object of class '<em>Data Object GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Object GNode</em>'.
	 * @generated
	 */
    DataObjectGNode createDataObjectGNode();

    /**
	 * Returns a new object of class '<em>Data Store GNode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Store GNode</em>'.
	 * @generated
	 */
	DataStoreGNode createDataStoreGNode();

				/**
	 * Returns a new object of class '<em>Message GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message GNode</em>'.
	 * @generated
	 */
    MessageGNode createMessageGNode();

    /**
	 * Returns a new object of class '<em>Group GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group GNode</em>'.
	 * @generated
	 */
    GroupGNode createGroupGNode();

    /**
	 * Returns a new object of class '<em>Text Annotation GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Annotation GNode</em>'.
	 * @generated
	 */
    TextAnnotationGNode createTextAnnotationGNode();

    /**
	 * Returns a new object of class '<em>Pool GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pool GNode</em>'.
	 * @generated
	 */
    PoolGNode createPoolGNode();

    /**
	 * Returns a new object of class '<em>Lane GNode</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lane GNode</em>'.
	 * @generated
	 */
    LaneGNode createLaneGNode();

    /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    BpmnPackage getBpmnPackage();

} //BpmnFactory
