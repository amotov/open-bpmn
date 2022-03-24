package org.imixs.bpmn.glsp.elements.event.edit;

import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.operations.Operation;

/**
 * The ApplyEventEditOperation is an {@link Action} that directly manipulates
 * the EventNode model representation on server side.
 * <p>
 * Each operation is uniquely defined by its KIND
 * <p>
 * The Operations are handled by the {@link ApplyEventEditOperationHandler}. The
 * operation handler is responsible of processing the operation and updates the
 * model representation accordingly.
 * <p>
 * The expression is a string that describes with attribute should be updated:
 * <p>
 * ATTRIBUTE_NAME:NEW_VALUE
 *
 */
public class ApplyEventEditOperation extends Operation {

    public static final String DOCUMENTATION_PREFIX = "documentation:";
    public static final String NAME_PREFIX = "name:";

    private String id;
    private String expression;

    public ApplyEventEditOperation() {
        super("applyEventEdit");
    }

    public ApplyEventEditOperation(final String nodeId, final String expression) {
        this();
        this.id = nodeId;
        this.expression = expression;
    }

    public String getId() {
        return id;
    }

    public void setId(final String nodeId) {
        this.id = nodeId;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(final String expression) {
        this.expression = expression;
    }

}