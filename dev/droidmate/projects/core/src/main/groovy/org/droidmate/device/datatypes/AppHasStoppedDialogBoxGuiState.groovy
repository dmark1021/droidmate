// Copyright (c) 2013-2015 Saarland University
// All right reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org

package org.droidmate.device.datatypes

import groovy.transform.Canonical
import org.droidmate.common.exploration.datatypes.Widget

@Canonical
class AppHasStoppedDialogBoxGuiState extends GuiState implements Serializable
{
  private static final long serialVersionUID = 1

  AppHasStoppedDialogBoxGuiState(String topNodePackageName, List<Widget> widgets)
  {
    super(topNodePackageName, widgets)
  }

  Widget getOKWidget() {
    return this.widgets.find { it.text == "OK" }
  }

}