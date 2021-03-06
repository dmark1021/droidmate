// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org

package org.droidmate.device.datatypes

import groovy.transform.Canonical
import org.droidmate.common.exploration.datatypes.Widget

/**
 * Specialized GuiState class that represents an application with an active "App has stopped" dialog box
 */
@Canonical
class AppHasStoppedDialogBoxGuiState extends GuiState implements Serializable
{
  private static final long serialVersionUID = 1

  AppHasStoppedDialogBoxGuiState(String topNodePackageName, List<Widget> widgets, String androidLauncherPackageName)
  {
    super(topNodePackageName, /* id = */ null, widgets, androidLauncherPackageName)
  }

  Widget getOKWidget() {
    return this.widgets.find { it.text == "OK" }
  }

}
