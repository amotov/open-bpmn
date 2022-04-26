/**
 */
package org.openbpmn.dc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.openbpmn.dc.DcPackage
 * @generated
 */
public interface DcFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DcFactory eINSTANCE = org.openbpmn.dc.impl.DcFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Bounds</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bounds</em>'.
     * @generated
     */
    Bounds createBounds();

    /**
     * Returns a new object of class '<em>Font</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Font</em>'.
     * @generated
     */
    Font createFont();

    /**
     * Returns a new object of class '<em>Point</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Point</em>'.
     * @generated
     */
    Point createPoint();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    DcPackage getDcPackage();

} //DcFactory
