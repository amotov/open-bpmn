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
import {
  and, computeLabel, ControlProps, isDescriptionHidden, isEnumControl, optionIs, OwnPropsOfEnum, RankedTester, rankWith
} from '@jsonforms/core';
import { withJsonFormsEnumProps } from '@jsonforms/react';
import { VanillaRendererProps, withVanillaControlProps } from '@jsonforms/vanilla-renderers';
import merge from 'lodash/merge';
import React, { useState } from 'react';

/***********************
 * This is a custom renderer for selectItems represented as RadioBottons or CheckBoxes.
 * The control can handle single String values (Radrio Button) or Arrays of Strings (Checkboxes).
 * <p>
 * In addition the renderer support label|value pairs separated by a | char.
 * <p>
 * The layout can be customized by the option 'orientation=horizontal|vertical'. 
 */

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export const SelectItemGroup = ({
  classNames,
  id,
  label,
  options,
  required,
  description,
  errors,
  data,
  uischema,
  visible,
  config,
  enabled,
  path,
  handleChange
}: ControlProps & VanillaRendererProps & OwnPropsOfEnum) => {
  const [isFocused, setFocus] = useState(false);
  const isValid = errors.length === 0;
  const appliedUiSchemaOptions = merge({}, config, uischema.options);
  const showDescription = !isDescriptionHidden(
    visible,
    description,
    isFocused,
    appliedUiSchemaOptions.showUnfocusedDescription
  );

  let groupStyle: { [x: string]: any } = {};
  // compute flexDirection based on the optional option 'orientation=vertical|horizontal'
  groupStyle = {
    display: 'flex',
    flexDirection: ('vertical' === uischema!.options!.orientation) ? 'column' : 'row'
  };

  /**
   * This method handles the click event of the SelectItem and updates either the single String value (RadioButton)
   * or the String array (CheckBox)
   * <p>
   * The method verifies if the value is of type string or array
   * 
   * @param path 
   * @param value 
   */
  // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
  const handleSelectionChange = (path: string, value: any) => {
      console.log('select case...');
      console.log('path='+path);
      console.log('value='+value);

      // test if we have an array
      if (Array.isArray(data)) {
        console.log("checkbox case...");
        // add value only if not yed done
        if (!data.includes(value)) {
          data.push(value);
        } else {
          console.log('unselect ....');
          const iPos: number = data.indexOf(value);
          if (iPos !== -1) {
            data.splice(iPos, 1);
          }
        }
      } else {
        console.log("radiobutton case...");
        data = value;
      }

      // finally we call the default change event handler...
      handleChange(path, data);
  };

  /**
   * Returns true if if the current value is selected
   *
   * @param value
   */
  const isSelected = (value: string): boolean => {
    // test if we have an array
    const _valuePart=getValuePart(value);
    console.log('was ist den wohl selected von ' + _valuePart);
    if (Array.isArray(data)) {
      return data.includes(_valuePart);
    } else {
      return data === _valuePart;
    }
  };

  /**
   * Returns the value part of a label|value pair
   * @param value
   * @returns
   */
  const getValuePart = (value: string): string => {
    const parts = value.split('|');
    if (parts.length===2) {
      return parts[1];
    }
    else {
      return value;
    }
  };

  /**
   * Returns the label part of a label|value pair
   * @param value
   * @returns
   */
  const getLabelPart = (value: string): string => {
    const parts = value.split('|');
    if (parts.length===2) {
      return parts[0];
    }
    else {
      return value;
    }
  };

  return (
    <div
      className={'control imixs-checkbox-group'}
      hidden={!visible}
      onFocus={() => setFocus(true)}
      onBlur={() => setFocus(false)}
    >
      <label htmlFor={id} className={'imixs'}>
        {computeLabel(
          label,
          false,
          appliedUiSchemaOptions.hideRequiredAsterisk
        )}
      </label>
      <div style={groupStyle}>
        {options!.map(option => (
          <div key={option.label}>
            <input
              type={(Array.isArray(data)) ? 'checkbox' : 'radio'}
              value={getValuePart(option.value)}
              id={getValuePart(option.value)}
              name={id}
              checked={isSelected(option.value)}
              onChange={ev => handleSelectionChange(path, ev.currentTarget.value)}
              disabled={!enabled}
            />
            <label
              htmlFor={getValuePart(option.value)}
            >
              {getLabelPart(option.label)}
            </label>
          </div>
        ))}
      </div>
      <div className={'input-description'}>
        {showDescription ? description : undefined}
      </div>
    </div>
  );
};

/* eslint-disable arrow-body-style */
// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export const SelectItemGroupControl = (props: ControlProps & VanillaRendererProps) => {
  return <SelectItemGroup {...props} />;
};

export const selectItemControlTester: RankedTester = rankWith(
  3,
  and(isEnumControl, optionIs('format', 'selectitem'))
);
export default withVanillaControlProps(withJsonFormsEnumProps(SelectItemGroupControl));
