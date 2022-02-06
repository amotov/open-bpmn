/********************************************************************************
 * Copyright (c) 2019-2021 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package org.imixs.emfcloud.bpmn2.handler;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.glsp.graph.GNode;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.graph.builder.impl.GArguments;
import org.eclipse.glsp.server.model.GModelState;
import org.eclipse.glsp.server.utils.GModelUtil;
import org.imixs.emf.bpmn2.Bpmn2Package;
import org.imixs.emfcloud.bpmn2.util.ModelTypes;
import org.imixs.emfcloud.bpmn2.util.WorkflowBuilder.TaskNodeBuilder;

public abstract class CreateTaskHandler extends CreateWorkflowNodeOperationHandler {

   private final Function<Integer, String> labelProvider;
   private final String elementTypeId;

   public CreateTaskHandler(final String elementTypeId, final Function<Integer, String> labelProvider) {
      super(elementTypeId);
      this.elementTypeId = elementTypeId;
      this.labelProvider = labelProvider;
   }

   protected String getElementTypeId() { return elementTypeId; }

   protected TaskNodeBuilder builder(final Optional<GPoint> point, final GModelState modelState) {
      int nodeCounter = GModelUtil.generateId(Bpmn2Package.Literals.TASK_NODE, "task", modelState);
      String name = labelProvider.apply(nodeCounter);
      String taskType = ModelTypes.toNodeType(getElementTypeId());
      return new TaskNodeBuilder(getElementTypeId(), name, taskType, 0) //
         .position(point.orElse(null))
         .addArguments(GArguments.cornerRadius(5))
         .addCssClass("task");
   }

   @Override
   protected GNode createNode(final Optional<GPoint> point, final Map<String, String> args) {
      return builder(point, modelState).build();
   }

}