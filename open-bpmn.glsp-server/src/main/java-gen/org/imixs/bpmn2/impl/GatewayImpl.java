/**
 */
package org.imixs.bpmn2.impl;

import org.eclipse.emf.ecore.EClass;

import org.imixs.bpmn2.Bpmn2Package;
import org.imixs.bpmn2.Gateway;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class GatewayImpl extends FlowElementImpl implements Gateway {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GatewayImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Bpmn2Package.Literals.GATEWAY;
    }

} //GatewayImpl