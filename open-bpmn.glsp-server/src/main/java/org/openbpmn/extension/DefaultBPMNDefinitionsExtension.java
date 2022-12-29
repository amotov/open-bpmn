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
import java.util.Set;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import org.eclipse.glsp.graph.GModelElement;
import org.openbpmn.bpmn.BPMNModel;
import org.openbpmn.bpmn.BPMNTypes;
import org.openbpmn.bpmn.elements.BPMNProcess;
import org.openbpmn.bpmn.elements.Signal;
import org.openbpmn.bpmn.elements.core.BPMNElement;
import org.openbpmn.bpmn.exceptions.BPMNInvalidReferenceException;
import org.openbpmn.bpmn.exceptions.BPMNInvalidTypeException;
import org.openbpmn.bpmn.exceptions.BPMNMissingElementException;
import org.openbpmn.glsp.jsonforms.DataBuilder;
import org.openbpmn.glsp.jsonforms.SchemaBuilder;
import org.openbpmn.glsp.jsonforms.UISchemaBuilder;
import org.openbpmn.glsp.jsonforms.UISchemaBuilder.Layout;
import org.openbpmn.glsp.model.BPMNGModelState;
import org.w3c.dom.Element;

import com.google.inject.Inject;

/**
 * This is the Default Root extension providing the JSONForms shemata on the
 * BPMN definitions level. This includes general diagram properties and sets
 * like signal or message elements.
 *
 * @author rsoika
 *
 */
public class DefaultBPMNDefinitionsExtension extends AbstractBPMNElementExtension {

    private static Logger logger = Logger.getLogger(DefaultBPMNDefinitionsExtension.class.getName());

    @Inject
    protected BPMNGModelState modelState;

    public DefaultBPMNDefinitionsExtension() {
        super();
    }

    @Override
    public boolean handlesElementTypeId(final String elementTypeId) {

        return BPMNTypes.PROCESS_TYPE_PUBLIC.equals(elementTypeId);
    }

    /**
     * This Extension is for the default public process only
     */
    @Override
    public boolean handlesBPMNElement(final BPMNElement bpmnElement) {
        if (bpmnElement instanceof BPMNProcess) {
            return ((BPMNProcess) bpmnElement).isPublicProcess();
        }
        return false;
    }

    /**
     * This Helper Method generates a JSON Object with the BPMNElement properties.
     * <p>
     * This json object is used on the GLSP Client to generate the EMF JsonForms
     */
    @Override
    public void buildPropertiesForm(final BPMNElement bpmnElement, final DataBuilder dataBuilder,
            final SchemaBuilder schemaBuilder, final UISchemaBuilder uiSchemaBuilder) {

        Element definitions = modelState.getBpmnModel().getDefinitions();
        dataBuilder //
                .addData("name", bpmnElement.getName()) //
                .addData("documentation", bpmnElement.getDocumentation()) //
                .addData("targetNamespace", definitions.getAttribute("targetNamespace")) //
                .addData("exporter", definitions.getAttribute("exporter")) //
                .addData("exporterVersion", definitions.getAttribute("exporterVersion"));

        schemaBuilder. //
                addProperty("name", "string", null). //
                addProperty("targetNamespace", "string", null). //
                addProperty("exporter", "string", null). //
                addProperty("exporterVersion", "string", null). //
                addProperty("documentation", "string", "Model description.");

        Map<String, String> multilineOption = new HashMap<>();
        multilineOption.put("multi", "true");
        uiSchemaBuilder. //
                addCategory("General"). //
                addLayout(Layout.HORIZONTAL). //
                addElements("name"). //
                addLayout(Layout.HORIZONTAL). //
                addElement("documentation", "Documentation", multilineOption). //
                // Category Definitions...
                addCategory("Definitions"). //
                addLayout(Layout.VERTICAL). //
                addElements("targetNamespace", "exporter", "exporterVersion"); //

        // Signal List
        addSignals(modelState.getBpmnModel(), dataBuilder, schemaBuilder, uiSchemaBuilder);

    }

    @Override
    public void updatePropertiesData(final JsonObject json, final BPMNElement bpmnElement,
            final GModelElement gNodeElement) {
        Element definitions = modelState.getBpmnModel().getDefinitions();
        // check custom features
        Set<String> features = json.keySet();
        for (String feature : features) {
            if ("name".equals(feature)) {
                bpmnElement.setName(json.getString(feature));
                continue;
            }
            if ("documentation".equals(feature)) {
                bpmnElement.setDocumentation(json.getString(feature));
                continue;
            }
            if ("targetNamespace".equals(feature)) {
                definitions.setAttribute(feature, json.getString(feature));
                continue;
            }
            if ("exporter".equals(feature)) {
                definitions.setAttribute(feature, json.getString(feature));
                continue;
            }
            if ("exporterVersion".equals(feature)) {
                definitions.setAttribute(feature, json.getString(feature));
                continue;
            }

            // Signals...
            if ("signals".equals(feature)) {
                logger.info("...update feature = " + feature);
                JsonArray signalSetValues = json.getJsonArray(feature);
                for (JsonValue laneValue : signalSetValues) {
                    // update signal properties
                    JsonObject signalData = (JsonObject) laneValue;

                    String id = signalData.getString("id", null);
                    Signal signal = (Signal) modelState.getBpmnModel().findElementById(id);
                    if (signal != null) {
                        signal.setName(signalData.getString("name"));
                    } else {
                        // signal did not yet exist in definition list - so we create a new one
                        int i = modelState.getBpmnModel().getSignals().size() + 1;
                        try {
                            modelState.getBpmnModel().addSignal("signal_" + i, "Signal " + i);
                            modelState.reset();
                        } catch (BPMNInvalidReferenceException | BPMNMissingElementException
                                | BPMNInvalidTypeException e) {
                            logger.warning("Unable to add new signal: " + e.getMessage());
                        }

                    }
                }
            }
        }
    }

    /**
     * Adds the Signal set schema properties
     *
     * @param eventDefinitions
     * @param dataBuilder
     * @param schemaBuilder
     * @param uiSchemaBuilder
     */
    private void addSignals(final BPMNModel model, final DataBuilder dataBuilder, final SchemaBuilder schemaBuilder,
            final UISchemaBuilder uiSchemaBuilder) {

        Map<String, String> multilineOption = new HashMap<>();
        multilineOption.put("multi", "true");

        if (model.getSignals().size() > 0) {
            Map<String, String> arrayDetailOption = new HashMap<>();
            // GENERATED | DEFAULT | HorizontalLayout
            arrayDetailOption.put("detail", "VerticalLayout");

            uiSchemaBuilder. //
                    addCategory("Signals"). //
                    addLayout(Layout.VERTICAL);

            JsonObjectBuilder layoutBuilder = Json.createObjectBuilder().add("type", "VerticalLayout");
            JsonArrayBuilder controlsArrayBuilder = Json.createArrayBuilder();
            controlsArrayBuilder //
                    .add(Json.createObjectBuilder() //
                            .add("type", "Control") //
                            .add("scope", "#/properties/name")//
                    );
            layoutBuilder.add("elements", controlsArrayBuilder);
            JsonObjectBuilder detailBuilder = Json.createObjectBuilder(). //
                    add("detail", layoutBuilder.build());

            uiSchemaBuilder.addElementWithOptions("signals", "Signals", detailBuilder.build());

            // Schema builder
            schemaBuilder.addArray("signals");
            schemaBuilder.addProperty("name", "string", null, null);

            /*
             * create the data structure for the signals - each signal is represented as a
             * separate object
             */
            dataBuilder.addArray("signals");
            for (Signal bpmnSignal : model.getSignals()) {
                dataBuilder.addObject();
                dataBuilder.addData("name", bpmnSignal.getName());
                // the id is used to find the signal in the bpmn model later
                dataBuilder.addData("id", bpmnSignal.getId());
            }
        }

    }

}
