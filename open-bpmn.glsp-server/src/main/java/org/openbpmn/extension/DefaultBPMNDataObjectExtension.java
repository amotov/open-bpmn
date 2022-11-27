/********************************************************************************
 * Copyright (c) 2022 Imixs Software Solutions GmbH and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package org.openbpmn.extension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.json.JsonObject;

import org.eclipse.glsp.graph.GLabel;
import org.eclipse.glsp.graph.GModelElement;
import org.openbpmn.bpmn.BPMNModel;
import org.openbpmn.bpmn.elements.BPMNBaseElement;
import org.openbpmn.bpmn.elements.BPMNDataObject;
import org.openbpmn.glsp.bpmn.LabelGNode;
import org.openbpmn.glsp.jsonforms.DataBuilder;
import org.openbpmn.glsp.jsonforms.SchemaBuilder;
import org.openbpmn.glsp.jsonforms.UISchemaBuilder;
import org.openbpmn.glsp.jsonforms.UISchemaBuilder.Layout;
import org.openbpmn.glsp.utils.BPMNBuilderHelper;
import org.openbpmn.model.BPMNGModelState;

import com.google.inject.Inject;

/**
 * This is the Default DataObject extension providing the JSONForms shemata.
 *
 * @author rsoika
 *
 */
public class DefaultBPMNDataObjectExtension extends AbstractBPMNElementExtension {

    @Inject
    protected BPMNGModelState modelState;

    public DefaultBPMNDataObjectExtension() {
        super();
    }

    @Override
    public boolean handlesElementTypeId(final String elementTypeId) {
        return BPMNModel.DATAOBJECT.equals(elementTypeId);
    }

    /**
     * This Extension is for BPMNActivities only
     */
    @Override
    public boolean handlesBPMNElement(final BPMNBaseElement bpmnElement) {
        return (bpmnElement instanceof BPMNDataObject);
    }

    /**
     * This Helper Method generates a JSON Object with the BPMNElement properties.
     * <p>
     * This json object is used on the GLSP Client to generate the EMF JsonForms
     */
    @Override
    public void buildPropertiesForm(final BPMNBaseElement bpmnElement, final DataBuilder dataBuilder,
            final SchemaBuilder schemaBuilder, final UISchemaBuilder uiSchemaBuilder) {

        dataBuilder //
                .addData("name", bpmnElement.getName()) //
                .addData("documentation", bpmnElement.getDocumentation());

        schemaBuilder. //
                addProperty("name", "string", null). //
                addProperty("documentation", "string", null);

        Map<String, String> multilineOption = new HashMap<>();
        multilineOption.put("multi", "true");
        uiSchemaBuilder. //
                addCategory("General"). //
                addLayout(Layout.HORIZONTAL). //
                addElements("name"). //
                addLayout(Layout.VERTICAL). //
                addElement("documentation", "Data", multilineOption);

    }

    @Override
    public void updatePropertiesData(final JsonObject json, final BPMNBaseElement bpmnElement,
            final GModelElement gNodeElement) {

        // default update of name and documentation
        Set<String> features = json.keySet();
        for (String feature : features) {

            if ("name".equals(feature)) {
                bpmnElement.setName(json.getString(feature));
                // Update Label...
                Optional<GModelElement> label = modelState.getIndex().get(gNodeElement.getId() + "_bpmnlabel");
                if (!label.isEmpty()) {
                    LabelGNode lgn = (LabelGNode) label.get();
                    GLabel glabel = BPMNBuilderHelper.findCompartmentHeader((lgn));
                    if (glabel != null) {
                        glabel.setText(json.getString(feature));
                    }
                }
                continue;
            }
            if ("documentation".equals(feature)) {
                bpmnElement.setDocumentation(json.getString(feature));
                continue;
            }

        }

    }

}