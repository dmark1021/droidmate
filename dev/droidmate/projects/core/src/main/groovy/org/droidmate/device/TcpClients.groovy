// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org
package org.droidmate.device

import org.droidmate.android_sdk.IAdbWrapper
import org.droidmate.exceptions.DeviceException

class TcpClients implements ITcpClients
{

  @Delegate
  private final IMonitorsClient          monitorsClient
  @Delegate
  private final IUiautomatorDaemonClient uiautomatorClient

  TcpClients(
    IAdbWrapper adbWrapper,
    String deviceSerialNumber,
    int socketTimeout,
    int uiautomatorDaemonTcpPort,
    int uiautomatorDaemonServerStartTimeout,
    int uiautomatorDaemonServerStartQueryDelay)
  {
    this.uiautomatorClient = new UiautomatorDaemonClient(
      adbWrapper,
      deviceSerialNumber,
      uiautomatorDaemonTcpPort,
      socketTimeout,
      uiautomatorDaemonServerStartTimeout,
      uiautomatorDaemonServerStartQueryDelay)

    this.monitorsClient = new MonitorsClient(socketTimeout, deviceSerialNumber, adbWrapper)
  }

  @Override
  void forwardPorts() throws DeviceException
  {
    this.uiautomatorClient.forwardPort()
    this.monitorsClient.forwardPorts()
  }
}
