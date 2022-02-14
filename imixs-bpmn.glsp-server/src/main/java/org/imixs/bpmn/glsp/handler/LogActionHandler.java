/********************************************************************************
 * Copyright (c) 2020-2021 EclipseSource and others.
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
package org.imixs.bpmn.glsp.handler;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.glsp.server.actions.AbstractActionHandler;
import org.eclipse.glsp.server.actions.Action;
import org.imixs.bpmn.glsp.action.LogAction;

public class LogActionHandler extends AbstractActionHandler<LogAction> {
   // private static Logger LOG = Logger.getLogger(LogActionHandler.class);

   private static Logger logger = Logger.getLogger(LogActionHandler.class.getName());

   @Override
   protected List<Action> executeAction(final LogAction action) {
      logger.info(action.getMessage());
      return Collections.emptyList();
   }

   // private static Level toLevel(final Severity severity) {
   // return Level.toLevel(severity.toString(), Level.DEBUG);
   // }

}